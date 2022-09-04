package com.bobo.LeetCode409;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author by bobo
 * @Description LeetCode409
 * @Date 2022/7/7 9:26 AM
 */
public class Solution {
    public int longestPalindrome(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                Integer count = map.get(s.charAt(i));
                map.put(s.charAt(i), ++count);
            } else {
                map.put(s.charAt(i), 1);
            }
        }
        Set<Character> characters = map.keySet();
        int maxOdd = 0;
        int evenNum = 0;
        boolean flag = false;
        for (Character character : characters) {
            Integer i = map.get(character);
            if (i % 2 == 0) {
                evenNum += i;
            } else {
                flag = true;
                evenNum += i - 1;
            }
        }
        if(flag==true){
            return evenNum + maxOdd + 1;
        }else {
            return evenNum+maxOdd;
        }
    }

    public static void main(String[] args) {
        String s = "bb";
        Solution solution = new Solution();
        System.out.println(solution.longestPalindrome(s));

    }
}
