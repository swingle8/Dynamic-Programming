class Solution {
    public int minPathSum(int[][] grid) {
        int rows = grid.length;
       int cols = grid[0].length;
       int [][] cost = new int [rows][cols];
       
       cost[0][0] = grid[0][0];
       
       for (int i = 1 ; i < cols ; i++)
            cost[0][i] = cost[0][i-1] + grid[0][i];
       
       for (int i = 1 ; i < rows ; i++)
            cost[i][0] = cost[i-1][0] + grid[i][0];
       
        for (int i = 1 ; i < rows ; i++) {
            for (int j = 1 ; j < cols ; j++) {
                    cost[i][j] = Math.min (cost[i-1][j], cost[i][j-1]) + grid[i][j];
            }
        }
        return cost[rows-1][cols-1];
    }
}