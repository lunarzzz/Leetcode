package leetcodedaily;

public class T123 {

    public static int maxProfit(int[] prices) {
        int l = prices.length;
        int k = 3;
        int j = 2;
        // k 可交易次数
        // j 是否拥有股票 0--否 1---是
        int[][][] res = new int[l][k][j];
        res[0][1][1] = -prices[0];
        res[0][2][0] = 0;
        res[0][0][1] = Integer.MIN_VALUE;
        res[0][2][1] = Integer.MIN_VALUE;
//        res[0][][]
        for(int i=1; i<l; i++) {
            res[i][2][1] = Math.max(res[i-1][1][0] - prices[i], res[i-1][2][1]);
            res[i][1][1] = Math.max(res[i-1][0][0] - prices[i], res[i-1][1][1]);
            res[i][0][1] = res[i-1][0][1];

            // res[i][k][0] = Math.max(res[i-1][k][1] + prices[i], res[i-1][k][0]);
            res[i][2][0] = Math.max(res[i-1][2][1] + prices[i], res[i-1][2][0]);
            res[i][1][0] = Math.max(res[i-1][1][1] + prices[i], res[i-1][1][0]);
            res[i][0][0] = Math.max(res[i-1][0][1] + prices[i], res[i-1][0][0]);
        }
        return Math.max(Math.max(res[l-1][2][0], res[l-1][1][0]), res[l-1][0][0]);
    }

    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{1, 2, 3, 4, 5}));
    }
}
