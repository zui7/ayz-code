package org.example.strng;

public class FirstUnique {
    //https://leetcode.com/problems/first-unique-character-in-a-string

    public  static int firstUniqueChar(String s) {
        int[] mya = new int[26];

        for(int i=0; i< s.length(); i++){
            char ch = s.charAt(i);
            mya[ch - 'a']++ ;
        }

        int mini = Integer.MAX_VALUE;
        for(int i=0; i<mya.length ; i++) {
            if ( mya[i] == 1)
                mini = Math.min( mini, s.indexOf(i + 'a'));

        }
        if (mini != Integer.MAX_VALUE) return mini;
        return -1;
    }
}
