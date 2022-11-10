package com.bobo.leetcode1002;

import java.util.ArrayList;
import java.util.List;

/**
 * @author by bobo
 * @Description leetcode 1002 查找公用字符
 * @Date 2022/11/10 10:06
 */
public class Solution {
    public List<String> commonChars(String[] words) {
        //构建hash表
        List<String> ans = new ArrayList<>();
        int[] hash = new int[26];
        for (int i = 0; i < words[0].length(); i++) {
            //用数组的下标代表当前数组
            hash[words[0].charAt(i) - 'a']++;
        }
        for (int i = 1; i < words.length; i++) {
            int[] hashOtherStr = new int[26];
            for (int j = 0; j < words[i].length(); j++) {
                hashOtherStr[words[i].charAt(j) - 'a']++;
            }
            for (int j = 0; j < 26; j++) {
                hash[j] = Math.min(hash[j], hashOtherStr[j]);
            }
        }
        for (int i = 0; i < hash.length; i++) {
            while (hash[i] != 0) {
                char c = (char) (i + 'a');
                hash[i]--;
                ans.add(String.valueOf(c));
            }
        }
        return ans;
    }


    public static void main(String[] args) {
        String[] words = new String[]{"bella", "label", "roller"};
        List<String> strings = new Solution().commonChars(words);
        System.out.println(strings);
    }
}
