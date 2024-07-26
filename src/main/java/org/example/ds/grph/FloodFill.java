package org.example.ds.grph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class FloodFill {

    //BFS
    public static int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if(image[sr][sc] == color) return image;

        int start = image[sr][sc];
        Queue<int[]> que = new LinkedList<>();
        que.add(new int[]{sr,sc});

        while(!que.isEmpty()) {
            for(int i=0; i< que.size() ;i++){
                int[] curr = que.poll();
                image[curr[0]][curr[1]] = color;
                int[] dx = new int[]{0, 0, 1, -1};
                int[] dy = new int[]{1, -1, 0, 0};

                for(int j=0; j<4; j++) {
                    int x = curr[0]+dx[j];
                    int y = curr[1]+dy[j];
                    if(x < 0 || y < 0 || x > image.length-1 || y > image[0].length-1 || image[x][y] != start){
                        continue;
                    }
                    que.add(new int[]{x,y});
                }
            }
        }
        return image;
    }

    //----------------------------------//
    int m, n, org;
    int[][] grid;

    public boolean isValid(int i, int j) {
        return (i >= 0 && j >= 0 && i < m && j < n && grid[i][j] == org);
    }

    public void helper(int sr, int sc, int color) {
        if (isValid(sr, sc)) {
            grid[sr][sc] = color;
            helper(sr+1, sc, color); // Bottom
            helper(sr-1, sc, color); // Top
            helper(sr, sc+1, color); // Right
            helper(sr, sc-1, color); // Left
        }
        return;
    }

    public int[][] floodFillRec(int[][] image, int sr, int sc, int color) {
        if (image[sr][sc] == color) return image;
        m = image.length;
        n = image[0].length;
        org = image[sr][sc];
        grid = image;

        helper(sr, sc, color);

        return grid;
    }

    public static void main(String[] args) {
        int[][] myarr = new int[3][];
        myarr[0] = new int[]{1, 1, 1};
        myarr[1] = new int[]{1, 1, 0};
        myarr[2] = new int[]{1, 0, 1};
        Arrays.stream(myarr).forEach(e -> {
            Arrays.stream(e).forEach(System.out::print);
            System.out.println();
        });
        myarr = floodFill(myarr, 1, 1, 2);
        Arrays.stream(myarr).forEach(e -> {
            Arrays.stream(e).forEach(System.out::print);
            System.out.println();
        });
    }

}
