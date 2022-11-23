package com.bobo.heap_sort;

/**
 * @author by bobo
 * @Description 堆排序
 * @Date 2022/11/21 11:27
 */
public class Solution {
    /**
     * @param arr    arr
     * @param i      表示非叶子节点在数组中的索引
     * @param length 对多少个元素进行调整
     */
    public void heapAdjust(int[] arr, int i, int length) {
        int temp = arr[i];
        for (int k = i * 2 + 1; k < length; k = k * 2 + 1) {
            if (k + 1 < length && arr[k] < arr[k + 1]) {
                //k指向右子节点
                k++;
            }
            //如果非子节点的值小于左子节点和右子节点的值
            if (arr[k] > temp) {
                //temp和arr[k]进行交换
                arr[i] = arr[k];
                //继续循环比较，假设k是左子节点，k+1是右子节点，然后引出公式
                i = k;
            } else {
                break;
            }
        }
        //循环结束后，arr[i]最大
        arr[i] = temp;
    }

    public void heapSort(int[] arr, int len) {
        int temp = 0;
        for (int i = arr.length / -1; i >= 0; i--) {
            heapAdjust(arr, i, arr.length);
        }
        for (int i = arr.length - 1; i > 0; i--) {
            temp = arr[i];
            arr[i] = arr[0];
            arr[0] = temp;
            heapAdjust(arr, 0, i);
        }

    }

    public static void main(String[] args) {

    }
}
