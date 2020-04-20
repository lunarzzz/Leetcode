package design;

import java.util.*;
import java.util.concurrent.TimeUnit;

public class TweetCounts {

    public TweetCounts() {
        map = new HashMap<>();
    }

    Map<String, List<Integer>> map;
    public void recordTweet(String tweetName, int time) {
        map.computeIfAbsent(tweetName, a -> new ArrayList<>()).add(time);
    }

    public List<Integer> getTweetCountsPerFrequency(String freq, String tweetName, int startTime, int endTime) {
        long delta = TimeUnit.valueOf((freq+"s").toUpperCase()).toSeconds(1L);
        List<Integer> data = map.getOrDefault(tweetName, new ArrayList<>());
        Collections.sort(data);
        int i=startTime,j=0;
        List<Integer> res = new ArrayList<>();
        while (i<=endTime) {
            if(j>=data.size()) {
                i += delta;
                res.add(0);
                continue;
            }
            int count=0;
            int currTh = i + (int) delta;
            while (true) {
                if (j>=data.size()) {
                    break;
                }
                if (data.get(j) < i) {
                    j++;
                } else if (data.get(j) >= i && data.get(j) < currTh && data.get(j) <= endTime){
                    count++;
                    j++;
                } else {
                    break;//
                }
            }
            i = currTh;
            res.add(count);
        }

        return res;
    }

    public static void main(String[] args) {
        TweetCounts tweetCounts = new TweetCounts();
        tweetCounts.recordTweet("tweet3", 0);
        tweetCounts.recordTweet("tweet3", 60);
        tweetCounts.recordTweet("tweet3", 10);
//        tweetCounts.recordTweet("tweet3", 61);
        // "tweet3" 发布推文的时间分别是 0, 10 和 60     [0,60)
        tweetCounts.getTweetCountsPerFrequency("minute", "tweet3", 0, 59).forEach(System.out::println);
        System.out.println("------");
        // 返回 [2]。统计频率是每分钟（60 秒），因此只有一个有效时间间隔 [0,60> - > 2 条推文。
        tweetCounts.getTweetCountsPerFrequency("minute", "tweet3", 0, 60).forEach(System.out::println);
        // 返回 [2,1]。统计频率是每分钟（60 秒），因此有两个有效时间间隔 1) [0,60> - > 2 条推文，和 2) [60,61> - > 1 条推文。
        System.out.println("------");
        tweetCounts.recordTweet("tweet3", 120);
        // "tweet3" 发布推文的时间分别是 0, 10, 60 和 120 。
        tweetCounts.getTweetCountsPerFrequency("hour", "tweet3", 0, 210).forEach(System.out::println);
        // 返回 [4]。统计频率是每小时（3600 秒），因此只有一个有效时间间隔 [0,211> - > 4 条推文。
        System.out.println("------");
//        ["TweetCounts","recordTweet","recordTweet","recordTweet","recordTweet","recordTweet","recordTweet","getTweetCountsPerFrequency","getTweetCountsPerFrequency"]
//        [[],["tweet0",13],["tweet1",16],["tweet2",12],["tweet3",18],["tweet4",82],["tweet3",89],["day","tweet0",89,9471],["hour","tweet3",13,4024]]
    }
}

/**
 * Your TweetCounts object will be instantiated and called as such:
 * TweetCounts obj = new TweetCounts();
 * obj.recordTweet(tweetName,time);
 * List<Integer> param_2 = obj.getTweetCountsPerFrequency(freq,tweetName,startTime,endTime);
 */
