package org.example.dp;

import java.util.Arrays;

public class LCS {

    public void longestCommonSubsequenceItr(String text1, String text2) {
        int m = text1.length() + 1;
        int n = text2.length() + 1;
        //String s = "";

        int[][] arr = new int[m][n];
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    //s += text1.charAt(i-1);
                    arr[i][j] = 1 + arr[i - 1][j - 1];
                } else {
                    arr[i][j] = Math.max(arr[i - 1][j], arr[i][j - 1]);
                }
            }
        }

        System.out.println("length: " +  arr[m - 1][n - 1]);

        int index = arr[m][n];
        char[] lcs = new char[index];

        int i=m, j=n;
        while( i > 0 && j > 0) {
            if(text1.charAt(i-1) == text2.charAt(j-1)) {
                lcs[index-1] = text1.charAt(i-1);
                i--;j--;index--;
            }
            else if(arr[i-1][j] > arr[i][j-1])
                i--;
            else
                j--;
        }

        StringBuilder sb = new StringBuilder();
        for(char c : lcs) sb.append(c);

        System.out.println(sb);

    }

    public int longestCommonSubsequenceRec(String text1, String text2) {
        int m = text1.length()+1;
        int n = text2.length()+1;
        int[][] arr = new int[m][n];
        for (int[] row: arr)
            Arrays.fill(row, -1);
        return lcs(0, 0, arr, text1.toCharArray(), text2.toCharArray());
    }

    public int lcs(int i, int j , int[][] arr, char[] c1, char[] c2) {
        if (i >= c1.length || j >= c2.length)
            return 0;
        if (arr[i][j] < 0) {
            if (c1[i] == c2[j])
                arr[i][j] = 1 + lcs(i + 1, j + 1, arr, c1, c2);
            else
                arr[i][j] = Math.max(lcs(i, j + 1, arr, c1, c2), lcs(i + 1, j, arr, c1, c2));
        }
        return arr[i][j];
    }
}

