package com.improve.algo.sort.lowb;

import java.util.Arrays;

/**
 * @date:2021/2/28 22:44
 **/
public class BubbleSort {

    public static void main(String[] args) {
        int[] arr = {10, 4, 6, 7, 8, 9, 1, 2, 3, 0, 5};
        bubbleSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    // 交换
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

}
