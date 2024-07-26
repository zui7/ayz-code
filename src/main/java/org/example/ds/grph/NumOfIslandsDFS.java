package org.example.ds.grph;

public class NumOfIslandsDFS {
    int m,n;
    public int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0 ) return 0;

        m = grid.length;
        n = grid[0].length;
        int numOfI = 0;
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j] == '1'){
                    numOfI++;
                    dfs(grid, i, j);
                }
            }
        }
        return numOfI;
    }

    public void dfs(char[][] grid, int i, int j) {
        if(i >= 0 && j >= 0 && i < m && j < n && grid[i][j] == '1') {
            grid[i][j] = '0';
            dfs(grid, i+1, j);
            dfs(grid, i-1, j);
            dfs(grid, i, j+1);
            dfs(grid, i, j-1);
        }
    }
}
