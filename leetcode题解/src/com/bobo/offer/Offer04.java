package com.bobo.offer;

/**
 * @Description 剑指offer第4题  二维数组中的查找
 * @Date 2022/3/2 11:19 PM
 * @Created by bobo
 */

public class Offer04 {
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix == null||matrix.length==0) {
            return false;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        int row = 0;
        int col = n - 1;

        while (row < m && col >= 0) {
            if (matrix[row][col] < target) {
                row++;
            } else if (matrix[row][col] > target) {
                col--;
            } else {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Offer04 offer04 = new Offer04();
        int[][] arr = {{}};
//        int m = arr[0].length;
//        int n = arr.length;
//        int i = 0;
//        int j = 0;
        boolean numberIn2DArray = offer04.findNumberIn2DArray(arr, -5);
        System.out.println(numberIn2DArray);


    }
}
