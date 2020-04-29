package leetcodedaily;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class T436 {


    public int[] findRightInterval(int[][] intervals) {
        Map<int[], Integer> map = new HashMap<>();
        for (int i = 0; i < intervals.length; i++) {
            map.put(intervals[i], i);
        }
        int[] res = new int[intervals.length];
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        for (int i = 0; i < intervals.length; i++) {
            int eNum = intervals[i][1];
            int s = i+1;
            int e = intervals.length-1;
            int index = -1;
            if (intervals[i][1] < intervals[intervals.length-1][0]) {
                res[map.get(intervals[i])] = -1;continue;
            }
//            for (int j = i+1; j < intervals.length; j++) {
//                int min=-1;
//                int minValue = Integer.MIN_VALUE;
//
//            }

            while (s < e) {
                int mid = (s + e) / 2;
                if (intervals[mid][0] <= eNum) {
                    s = mid+1;
//                    index = s;
                } else {
                    e = mid;
                }
            }
            if (s<0 || s>=intervals.length) {
                res[map.get(intervals[i])] = -1;
            } else {
                res[map.get(intervals[i])] = map.get(intervals[s]);
            }
        }
        return res;
    }
}
