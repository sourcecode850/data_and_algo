package com.improve.algo.getk;

import java.util.Arrays;

/**
 * @date:2021/3/6 15:59
 **/
public class GetK2 {

    public static void main(String[] args) {

        int[] arr = {2, 10, 8, 7, 6, 9, 3, 1, 0, 4, 5};
        System.out.println(getTopK(arr, 1));
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
        System.out.println(arr[arr.length - 2]);

    }

    public static int getTopK(int[] arr, int k) {
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
        return result[0];
    }

}
