package leetcodedaily;

import java.util.LinkedList;

public class T44 {
    public static boolean isMatch(String s, String p) {
        //
        //
        int l1=s.length(),l2=p.length();
        boolean[][] res = new boolean[s.length()+1][p.length()+1];

//        for (int i = 0; i < l1; i++) {
//            res[i][0] = false;
//        }
//        for (int i = 0; i < l2; i++) {
//            res[0][i] = false;
//        }
//        if (p.charAt(0) == '?' || p.charAt(0) == '*') {
//            res[0][0] = true;
//        } else {
//            res[0][0] = p.charAt(0) == s.charAt(0);
//        }
        res[0][0] = true;
        for (int i = 0; i <= l1; i++) {
            for (int j = 0; j <= l2; j++) {
                if (i==0) {
                    if (j == 0) {
                        res[0][0] = true;
                    } else {
                        if (p.charAt(j-1) == '*') {
                            res[0][j] = res[0][j-1];
                        } else {
                            res[0][j] = false;
                        }
                    }
                    continue;
                }
                if (j==0) {
                    res[i][j] = false;
                    continue;
                }

                if (p.charAt(j-1) == '?') {
                    res[i][j] = res[i-1][j-1];
                } else if (p.charAt(j-1) == '*') {
                    boolean tmp = false;
                    // i==0
                    // if (i==0) {
                    //     if (j == 0) {return res[0][0] = true; }
                    //     else {
                    //         res[0][j] = res[0][j-1];
                    //     }
                    //     continue;
                    // }
                    // if (j==0) {
                    //     res[i][j] = false;
                    // }
                    for (int k = 0; k <= i; k++) {
                        if (res[i-k][j-1]) {
                            tmp = true;
                        }
                    }
                    res[i][j] = tmp;
                } else {
                    res[i][j] = s.charAt(i-1) == p.charAt(j-1) && res[i-1][j-1];
                }
            }
        }
        return res[l1][l2];
    }

    public static void main(String[] args) {
        System.out.println(isMatch("adceb", "*a*b"));
        LinkedList linkedList;
    }
}
