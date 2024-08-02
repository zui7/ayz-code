package org.example.strng;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Parentheses {

    //https://leetcode.com/problems/generate-parentheses
    public static List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        recurse(res, 0, 0, "", n);
        return res;
    }

    private static void recurse(List<String> res, int left, int right, String s, int n) {
        if (s.length() == n * 2) {
            res.add(s);
            return;
        }
        if (left < n) {
            recurse(res, left + 1, right, s + "(", n);
        }
        if (right < left) {
            recurse(res, left, right + 1, s + ")", n);
        }
    }

    //https://leetcode.com/problems/valid-parentheses/description/
    public boolean isValid(String s) {
        Stack<Character> stk = new Stack<>();

        for(int i=0; i<s.length(); i++) {
            char ch = s.charAt(i);
            if(ch == '(' || ch =='{' || ch =='['){
                stk.push(ch);
            } else{
                if(stk.isEmpty())
                    return false;
                char p = stk.pop();
                if((p == '(' && ch != ')') || (p == '{' && ch != '}')||(p == '[' && ch != ']') )
                    return false;
            }
        }

        return stk.isEmpty();
    }
}
