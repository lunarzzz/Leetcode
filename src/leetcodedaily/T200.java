package leetcodedaily;

public class T200 {
    int m,n;
    int[][] direction = new int[][] {
            {0, 1}, {0, -1}, {1, 0}, {-1, 0}
    };
    public int numIslands(char[][] grid) {
        if (grid.length == 0) {
            return 0;
        }
        m = grid.length;
        n = grid[0].length;
        boolean[][] flag = new boolean[m][n];
        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (flag[i][j]) {
                    continue;
                }
                dfs(grid, flag, i, j);
                count++;
            }

        }
        return count;
    }

    private void dfs(char[][] grid, boolean[][] flag, int i, int j) {
        if (i<0 || i>=m || j<0 || j>=n || flag[i][j]) {
            return;
        }
        flag[i][j] = true;
        for(int k=0; k<direction.length; k++) {
            dfs(grid, flag, i+direction[k][0], j+direction[k][1]);
        }
    }

}
