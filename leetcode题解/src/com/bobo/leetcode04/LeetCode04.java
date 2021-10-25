package com.bobo.leetcode04;

/**
 * @Description 寻找两个正序数组的中位数
 * @Date 2021/10/23 16:08
 * @Created by bobo
 */
public class LeetCode04 {
    public static void main(String[] args) {
        int[] nums1 = {};
        int[] nums2 = {2, 4};
        LeetCode04 leetCode04 = new LeetCode04();
        double medianSortedArrays = leetCode04.findMedianSortedArrays(nums1, nums2);
        System.out.println(medianSortedArrays);
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] mergeArr = new int[nums1.length + nums2.length];
        int i = 0;
        int j = 0;
        int k = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] <= nums2[j]) {
                mergeArr[k] = nums1[i];
                i++;
            } else {
                mergeArr[k] = nums2[j];
                j++;
            }
            k++;
        }
        while (i < nums1.length) {
            mergeArr[k] = nums1[i];
            i++;
            k++;
        }
        while (j < nums2.length) {
            mergeArr[k] = nums2[j];
            j++;
            k++;
        }

        if (k % 2 != 0) {
            return mergeArr[k / 2];
        } else {
            return (mergeArr[k / 2 - 1] + mergeArr[k / 2]) / 2.0;
        }
    }
}