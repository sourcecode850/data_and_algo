package com.improve.algo.math;

import org.junit.Test;

/**
 * 纯数学算法
 *
 * @date:2021/3/6 22:27
 **/
public class MathAlgoTest {


    // 有序队列：求出第1500个能被235整除的数，第一个数是2
    @Test
    public void num1500_235() {

        int position = 1500;
        int num = 0;

        for (int i = 2; i <= 30; i++) {
            if (i % 2 == 0 || i % 3 == 0 || i % 5 == 0) {
                num++;
            }
        }
        System.out.println("2-30以内能被235其中之一整除的自然数数目=" + num);

        System.out.println(position / 22);
        System.out.println(position % 22);
        int result = position / 22 * 30;
        // 重置num
        num = 0;
        for (int i = 2; i <= 30; i++) {
            if (i % 2 == 0 || i % 3 == 0 || i % 5 == 0) {
                num++;
                if (num == position % 22) {
                    result += i;
                    break;
                }
            }
        }
        System.out.println(result);
    }

    @Test
    public void book_num1500_235() {
        int n = 1500;
        int[] arr = {0, 2, 3, 4, 5, 6, 8, 9, 10, 12, 14, 15, 16, 18, 20, 21, 22, 24, 25, 26, 27, 28, 30};
        System.out.println("n/arr.length=" + n / arr.length);
        System.out.println("n/%arr.length=" + n % arr.length);
        System.out.println(n / 22 * 30 + arr[n % 22]);
    }

}
