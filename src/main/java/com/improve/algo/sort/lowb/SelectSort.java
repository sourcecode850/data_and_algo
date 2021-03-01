package com.improve.algo.sort.lowb;

import java.util.Arrays;

/**
 * 选择排序，先选最小的，然后选择次小的，以此类推
 *
 * @date:2021/2/28 22:57
 **/
public class SelectSort {

    public static void main(String[] args) {
        int[] arr = {10, 4, 6, 7, 8, 9, 1, 2, 3, 0, 5};
        selectSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void selectSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int min = arr[i];
            int index = i;
            for (int j = i + 1; j < arr.length; j++) {
                // 选择最小的；和第一个位置的交换位置
                // 抽象：选择i之后最小的，与位置i的元素交换位置
                if (arr[j] < min) {
                    min = arr[j];
                    index = j;
                }
            }
            // 一次循环下来，找到最小的元素min，与i交换
            if (min < arr[i]) {
                arr[index] = arr[i];
                arr[i] = min;
            }
        }
    }

}
