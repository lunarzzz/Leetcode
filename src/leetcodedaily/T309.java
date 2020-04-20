package leetcodedaily;

public class T309 {
        public int maxProfit(int[] prices) {
            // int ==
            // 其中int
            if(prices.length <= 1) {
                return 0;
            };
            int[][] res = new int[prices.length][3];
            // 0--->买入 1---》卖出  2---》冷冻
            // tansfer 0->1    1->2   2->0
            //1, 2, 3, 0, 2
            for(int i=0; i<prices.length; i++) {
                if(i==0) {
                    // first day
                    res[0][0] = -prices[i];
                    res[0][1] = 0;
                    res[0][2] = 0;
                } else if(i == 1) {
                    res[1][0] = -prices[i];
                    res[1][1] = res[0][0] + prices[1];// 第二天卖出，第一天肯定是买入
                    res[1][2] = res[0][2];// 第二天冷冻--》第一天肯定是冷冻
                } else {
                    res[i][0] = res[i-1][2] - prices[i]; // 买入
                    res[i][1] = Math.max(res[i-1][2], res[i-1][0]) + prices[i]; // 卖出
                    res[i][2] = Math.max(res[i-1][1], res[i-1][2]); // 冷冻
                }
            }
            return Math.max(res[prices.length-1][1], res[prices.length-1][2]);
        }

    public static void main(String[] args) {
        T309 t309 = new T309();
        System.out.println(t309.maxProfit(new int[]{1, 2, 3, 0, 2}));
    }
}
