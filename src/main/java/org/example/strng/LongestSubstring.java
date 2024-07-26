package org.example.strng;

import java.util.HashSet;
import java.util.Set;
//https://leetcode.com/problems/longest-substring-without-repeating-characters/

public class LongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> charSet = new HashSet<>();
        int left=0;
        int finlen =0;
        for (int right = 0; right < s.length() ; right++) {
            if(!charSet.contains(s.charAt(right))) {
                charSet.add(s.charAt(right));
                finlen = Math.max(finlen, right - left + 1);
            } else {
                while(charSet.contains(s.charAt(right))) {
                    charSet.remove(s.charAt(left));
                    left++;
                }
                charSet.add(s.charAt(right));
            }
        }
        return finlen;
    }
}
