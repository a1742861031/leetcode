package com.bobo.leetcode503;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @author by bobo
 * @Description 下一个更大元素 II
 * @Date 2022/10/26 09:43
 */
public class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int length = nums.length;
        int[] newNums = new int[2 * length - 1];
        int[] ans = new int[length];
        Arrays.fill(ans, -1);
        Deque<Integer> stack = new LinkedList<>();
        System.arraycopy(nums, 0, newNums, 0, length);
        for (int i = 0; i < nums.length - 1; i++) {
            newNums[length] = nums[i];
            length++;
        }
        for (int i = 0; i < newNums.length; i++) {
            if (stack.isEmpty() || newNums[i] <= newNums[stack.peek()]) {
                stack.push(i);
            } else {
                while (!stack.isEmpty() && newNums[i] > newNums[stack.peek()]) {
                    if(stack.peek()<ans.length){
                        ans[stack.peek()] = newNums[i];
                    }
                    stack.pop();
                }
                if (i < nums.length) {
                    stack.push(i);
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 1};
        int[] ints = new Solution().nextGreaterElements(nums);

    }
}
