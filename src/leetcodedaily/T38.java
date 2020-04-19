package leetcodedaily;

public class T38 {


    public static String countAndSay(int n) {
        int i=0;
        String tmp = "1";
        StringBuilder sb;
        while (i<n) {
            sb = new StringBuilder();
            int count = 1;
            char num = tmp.charAt(0);
            for (int j = 1; j < tmp.length(); j++) {
                if (tmp.charAt(j) == num) {
                    count++;
                } else {
                    sb.append(count).append(num);
                    count = 1;
                    num = tmp.charAt(j);
                }
            }
            sb.append(count).append(num);
            tmp = sb.toString();
            i++;
        }
        return tmp;
    }

    public static void main(String[] args) {
        System.out.println(countAndSay(5));
    }
}
