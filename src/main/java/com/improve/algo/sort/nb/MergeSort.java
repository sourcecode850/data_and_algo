package com.improve.algo.sort.nb;

import java.util.Arrays;

/**
 * 归并排序
 *
 * @date:2021/3/2 21:23
 **/
public class MergeSort {

    public static void main(String[] args) {

        int[] arr1 = {2, 4, 6, 8, 10};
        int[] arr2 = {8, 12, 13, 14, 15};

        System.out.println(Arrays.toString(merge(arr1, arr2)));

        int[] arr = {10, 4, 6, 7, 8, 9, 1, 2, 3, 0, 5, 10, 4, 6, 7, 8, 9, 1, 2, 3, 0, 5};
        System.out.println(Arrays.toString(mergeSort(arr, 0, arr.length - 1)));
        System.out.println(Arrays.toString(arr));

    }

    public static int[] mergeSort(int[] arr, int start, int end) {
        if (start >= end) {
            return new int[]{arr[start]};
        }
        int mid = (start + end) / 2;
        int[] arr1 = mergeSort(arr, start, mid);
        // mid+1放在低下，否则出错；具体细节debug可以发现!!!
        int[] arr2 = mergeSort(arr, mid + 1, end);
        return merge(arr1, arr2);
    }


    public static int[] merge(int[] arr1, int[] arr2) {
        int[] arr = new int[arr1.length + arr2.length];
        int index1 = 0;
        int index2 = 0;
        for (int i = 0; i < arr.length; i++) {
            // index1小于arr1长度； arr1当前值小于arr2当前值或者arr2已经取完了，就用arr1赋值；下标越界要检查
            if (index1 < arr1.length && (index2 == arr2.length || arr1[index1] <= arr2[index2])) {
                arr[i] = arr1[index1++];
            } else if (index2 < arr2.length && (index1 == arr1.length || (arr2[index2]) < arr1[index1])) {
                arr[i] = arr2[index2++];
            }
        }
        return arr;
    }

}
