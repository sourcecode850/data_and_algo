package com.improve.algo.sort.lowb;

import java.util.Arrays;

/**
 * 跟打牌类似
 *
 * @date:2021/3/1 21:33
 **/
public class InsertSort {

    public static void main(String[] args) {
        int[] arr = {10, 4, 6, 7, 8, 9, 1, 2, 3, 0, 5};
        insertSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void insertSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            // 4, 6, 1, 8, 9, 1, 2, 3, 0, 5,10
            // i就是摸到的牌的下标，i-1之前就是手里的牌，将摸到的牌与手里的牌做比较
            int j = i - 1;
            // 记录下摸到的牌，防止被覆盖了
            int temp = arr[i];
            // 大于等于0的条件放在左边，防止下标越界
            while (j >= 0 && arr[j] > temp) {
                // 手里的牌比摸到的牌大，需要移动
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = temp;
        }
    }

}
