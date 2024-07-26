package org.example.ds.grph;

import java.util.LinkedList;
import java.util.Queue;

public class RottenOrange {
    public static int orangesRotting(int[][] grid) {
        int len = grid.length;
        int hlen = grid[0].length;
        Queue<int[]> que = new LinkedList<>();
        int time = 0, fresh = 0;

        for (int i = 0; i < len; i++) {
            for (int j = 0; j < hlen; j++) {
                if (grid[i][j] == 2) {
                    que.offer(new int[]{i, j});
                }
                if (grid[i][j] == 1) {
                    fresh++;
                }
            }
        }

        if (fresh == 0) return 0;
        if (que.isEmpty()) return -1;

        int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        while (!que.isEmpty()) {
            while (!que.isEmpty()) {
                int sz = que.size();
                while (sz-- > 0) {
                    int[] curr = que.poll();
                    int x = curr[0];
                    int y = curr[1];

                    for (int[] dir : dirs) {
                        int dx = x + dir[0];
                        int dy = y + dir[1];

                        if (dx >= 0 && dy >= 0 && dx < len && dy < hlen && grid[dx][dy] == 1) {
                            System.out.println(dx + " " + dy);
                            grid[dx][dy] = 2;
                            fresh--;
                            que.offer(new int[]{dx, dy});
                        }
                    }
                }
                time++;
            }
        }
        if (fresh == 0)
            return time;
        return -1;
    }

    public static void main(String[] args) {
        int[][] g = new int[3][];
        g[0] = new int[]{2, 1, 1};
        g[1] = new int[]{1, 1, 0};
        g[2] = new int[]{0, 1, 1};

        System.out.println(orangesRotting(g));
    }
}



