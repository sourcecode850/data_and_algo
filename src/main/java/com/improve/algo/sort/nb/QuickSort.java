package com.improve.algo.sort.nb;

import java.util.Arrays;

/**
 * @date:2021/3/2 21:50
 **/
public class QuickSort {

    public static void main(String[] args) {
        int[] arr = {10, 4, 6, 7, 8, 9, 1, 2, 3, 0, 5};
        quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    public static void quickSort(int[] arr, int left, int right) {
        // 递归结束条件
        if (left >= right) {
            return;
        }

        int i = left;
        int j = right;
        int part = arr[left];

        while (i < j) {
            // 向右找第一个大于part的下标i
            while (arr[i] <= part && i < j) {
                i++;
            }
            // 向左找第一个比part小的下标j；这里i<=j取等号，让j跳到比i小
            while (arr[j] >= part && i <= j) {
                j--;
            }

            if (i < j) {
                // 交换ij
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // 将part放入到正确的位置
        arr[left] = arr[j];
        arr[j] = part;

        quickSort(arr, left, j - 1);
        quickSort(arr, j + 1, right);

    }
}
