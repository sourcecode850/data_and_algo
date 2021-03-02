package com.improve.algo.sort.other;

import java.util.Arrays;

/**
 * @date:2021/3/2 22:04
 **/
public class ShellSort {


    public static void main(String[] args) {
        int[] arr = {10, 4, 6, 7, 8, 9, 1, 2, 3, 0, 5};
        shellSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void shellSort(int[] arr) {

        int step = 1;
        while (step < arr.length / 3) {
            step = step * 3 + 1;
        }
        while (step > 0) {
            for (int i = step; i < arr.length; i += step) {
                int insertValue = arr[i];
                int j = i - step;
                while (j >= 0 && arr[j] > insertValue) {
                    arr[j + step] = arr[j];
                    j -= step;
                }
                arr[j + step] = insertValue;
            }
            step = (step - 1) / 3;
        }
    }

}
