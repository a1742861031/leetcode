package com.bobo.week.week316.test1;

/**
 * @author by bobo
 * @Description 6214. 判断两个时间是否存在冲突
 * @Date 2022/10/23 10:31
 */
public class Solution {
    public boolean haveConflict(String[] event1, String[] event2) {
        //转换为数字
        int event1Start = convert(event1[0]);
        int event1End = convert(event1[1]);
        int event2Start = convert(event2[0]);
        int event2End = convert(event2[1]);
        if (event2Start >= event1Start && event2Start <= event1End) {
            return true;
        }
        if (event2End >= event1Start && event2End <= event1End) {
            return true;
        }
        if (event2Start <= event1Start && event2End >= event1End) {
            return true;
        }
        return false;
    }

    public int convert(String time) {
        return Integer.parseInt(time.substring(0, 2)) * 100 + Integer.parseInt(time.substring(3, 5));
    }

    public static void main(String[] args) {
        String[] event1 = new String[]{"15:19","17:56"};
        String[] event2 = new String[]{"14:11","20:02"};
        boolean b = new Solution().haveConflict(event1, event2);
        System.out.println(b);
    }
}
