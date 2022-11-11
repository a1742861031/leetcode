package com.bobo.leetcode925;

/**
 * @author by bobo
 * @Description leetcode925 长按键入
 * @Date 2022/11/10 11:16
 */
public class Solution {
    public boolean isLongPressedName(String name, String typed) {
        int point1 = 1;
        int point2 = 1;
        if (typed.charAt(0) != name.charAt(0)) {
            return false;
        }
        if (name.length() > typed.length()) {
            return false;
        }
        for (; point1 < name.length(); point1++) {
            if (point2 >= typed.length()) {
                return false;
            }
            char c1 = name.charAt(point1);
            while (typed.charAt(point2) != c1) {
                if (typed.charAt(point2) != typed.charAt(point2 - 1)) {
                    return false;
                }
                point2++;
                if (point2 >= typed.length()) {
                    return false;
                }
            }
            point2++;
        }

        while (point2 < typed.length()) {
            if (typed.charAt(point2) != typed.charAt(point2 - 1)) {
                return false;
            }
            point2++;
        }
        return true;
    }

    public static void main(String[] args) {
        boolean longPressedName = new Solution().isLongPressedName("kikcxmvzi", "kiikcxxmmvvzz");
        System.out.println(longPressedName);
    }
}
