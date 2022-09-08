package com.bobo.leetcode3;

import java.util.HashMap;
import java.util.Map;

/**
 * @author by bobo
 * @Description leetcode3 无重复字符的最长字串
 * @Date 2022/9/5 1:27 PM
 */
public class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) {
            return 0;
        }
        int ans = Integer.MIN_VALUE;
        int n = s.length();
        Map<Character, Integer> map = new HashMap<>();
        int start = -1;
        for (int end = 0; end < n; end++) {
            Integer alpha = map.get(s.charAt(end));
            if(alpha!=null){
                start = Math.max(start,alpha);
            }
            int len = end - start;
            if (ans < len) {
                ans = len;
            }
            map.put(s.charAt(end),end);
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().lengthOfLongestSubstring("abba"));
    }
}
