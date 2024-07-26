package org.example.dp;

import java.util.Arrays;

public class LCS {

    public int longestCommonSubsequenceItr(String text1, String text2) {
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

        return arr[m - 1][n - 1];
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

    //char[] A = text1.toCharArray();
    //char[] B = text2.toCharArray();
    //String s = "";
    //int i = 1;
    //int j = 1;
    //
    //        while (i < m-1 && j < n-1)
    //        {
    //        if (A[i] == B[j])
    //        {
    //        System.out.println(A[i] + " " + B[j]);
    //s += A[i];
    //i++; j++;
    //        }
    //        else if (arr[i-1][j] >= arr[i][j-1]) i++;
    //        else j++;
    //        }
    //        System.out.println(s);
    //
//            return arr[m-1][n-1];
//    sequence S = empty;
//          i = 0;
//          j = 0;
//        while (i < m && j < n)
//        {
//        if (A[i]==B[j])
//        {
//          add A[i] to end of S;
//              i++; j++;
//        }
//        else if (L[i+1,j] >= L[i,j+1]) i++;
//        else j++;
//        }
//
//n  e  m  a  t  o  d  e  _  k  n  o  w  l  e  d  g  e
//
//e   7  7  6  5  5  5  5  5  4  3  3  3  2  2  2  1  1  1  0
//m   6  6  6  5  5  4  4  4  4  3  3  3  2  2  1  1  1  1  0
//p   5  5  5  5  5  4  4  4  4  3  3  3  2  2  1  1  1  1  0
//t   5  5  5  5  5  4  4  4  4  3  3  3  2  2  1  1  1  1  0
//y   4  4  4  4  4  4  4  4  4  3  3  3  2  2  1  1  1  1  0
//_   4  4  4  4  4  4  4  4  4  3  3  3  2  2  1  1  1  1  0
//b   3  3  3  3  3  3  3  3  3  3  3  3  2  2  1  1  1  1  0
//o   3  3  3  3  3  3  3  3  3  3  3  3  2  2  1  1  1  1  0
//t   3  3  3  3  3  2  2  2  2  2  2  2  2  2  1  1  1  1  0
//t   3  3  3  3  3  2  2  2  2  2  2  2  2  2  1  1  1  1  0
//l   2  2  2  2  2  2  2  2  2  2  2  2  2  2  1  1  1  1  0
//e   1  1  1  1  1  1  1  1  1  1  1  1  1  1  1  1  1  1  0
//    0  0  0  0  0  0  0  0  0  0  0  0  0  0  0  0  0  0  0
