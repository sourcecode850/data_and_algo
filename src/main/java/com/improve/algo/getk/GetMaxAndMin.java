package com.improve.algo.getk;

import java.util.LinkedList;
import java.util.List;

/**
 * 递归实现取数组最值
 *
 * @date:2021/3/6 0:03
 **/
public class GetMaxAndMin {

    public static void main(String[] args) {
        int[] arr = {10, 2, 3, 4, 2, 1, 7, 78, -1, 100, 7, 4, 2, 54, 65};
        System.out.println(getMaxAndMin(arr, 0, arr.length - 1));
    }

    public static List<Integer> getMaxAndMin(int[] arr, int start, int end) {
        if (start == end || start == end - 1) {
            List<Integer> list = new LinkedList<>();
            if (arr[start] > arr[end]) {
                list.add(arr[end]);
                list.add(arr[start]);
            } else {
                list.add(arr[start]);
                list.add(arr[end]);
            }
            return list;
        }
        int mid = (start + end) / 2;
        List<Integer> list1 = getMaxAndMin(arr, start, mid);
        List<Integer> list2 = getMaxAndMin(arr, mid + 1, end);

        List<Integer> result = new LinkedList<>();
        result.add(list1.get(0) < list2.get(0) ? list1.get(0) : list2.get(0));
        result.add(list1.get(1) > list2.get(1) ? list1.get(1) : list2.get(1));
        return result;
    }


}
