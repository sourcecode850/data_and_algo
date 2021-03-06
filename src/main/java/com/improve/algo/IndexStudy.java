package com.improve.algo;

import org.junit.Test;

import java.util.Arrays;

/**
 * 总是难以搞清各种算法的index下标问题，集中研究下
 *
 * @date:2021/3/6 18:41
 **/
public class IndexStudy {

    @Test
    public void insertSort() {

        int[] arr = {10, 9, 3, 7, 6, 8, 5, 4, 1, 2};

        for (int i = 1; i < arr.length; i++) {
            int temp = arr[i];
            int index = i - 1;
            // 新摸到的牌小，则需要右移动
            while (index >= 0 && temp < arr[index]) {
                arr[index + 1] = arr[index];
                index--;
            }
            // 上面的循环结束，说明index 下标大于temp了，所以temp需要赋值给index+1
            arr[index + 1] = temp;
        }

        System.out.println(Arrays.toString(arr));
    }

    @Test
    public void getK() {
        int[] arr = {2, 10, 8, 7, 6, 9, 3, 1, 0, 4, 5};
        int k = 3;
        int[] result = new int[k + 1];
        Arrays.fill(result, Integer.MIN_VALUE);
        for (int i = 0; i < arr.length; i++) {
            // 当前i可以进入result
            if (arr[i] > result[0]) {
                // 上面已经判断0了，这里可以从1开始
                int index = 1;
                // 找到arr[i]在result中的正确位置；下标越界判断放在左边，即先判断下标是否越界
                while (index <= k && arr[i] > result[index]) {
                    // 当前index值需要向后移一位，注意不是 result[index] = result[index+1]，两者有差别
                    result[index - 1] = result[index];
                    index++;
                }
                // 插入arr[i]到result数组中的正确位置；上面循环结束可知，arr[i]不会大于result[index]了，所以将arr[i]赋值给index-1而不是index
                result[index - 1] = arr[i];
            }

        }
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
        System.out.println(result[0]);
    }

}
