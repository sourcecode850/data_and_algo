package com.improve.algo.getk;

import java.util.Arrays;

/**
 * 获取数组第k小的值
 * 将数组一分为二，按照快排的思路； {...} arr[i] {...};
 * 如果i等于k，直接返回arr[i]，i>k去左边找，i<k去右边找
 *
 * @date:2021/3/6 0:16
 **/
public class GetK1 {

    public static void main(String[] args) {
        int[] arr = {2, 10, 8, 7, 6, 9, 3, 1, 0, 4, 5};
        System.out.println(getK(arr, 7, 0, arr.length - 1));
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
        System.out.println(arr[7]);
    }

    public static int getK(int[] arr, int k, int start, int end) {

        int i = start;
        int j = end;

        int part = arr[start];

        while (i < j) {
            while (arr[i] <= part && i < j) {
                i++;
            }

            while (arr[j] >= part && i <= j) {
                j--;
            }

            if (i < j) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        arr[start] = arr[j];
        arr[j] = part;

        if (j - start == k) {
            return arr[j];
        }

        if (j - start > k) {
            return getK(arr, k, start, j - 1);
        } else {
            // {2, 10, 8, 7, 6, 9, 3, 1, 0, 4, 5}
            // [0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
            // k=7的话 {0,1} {2} {...} k=7,j=2,还需要再右边找5就对了，第5的数，在右边数组其实下标是4； 5-1 = 7-2-1
            return getK(arr, k - j - 1, j + 1, end);
        }
    }


}
