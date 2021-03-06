package com.improve.algo.self;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * 自己想出的一些问题
 *
 * @date:2021/3/6 22:50
 **/
public class SelfCombination {


    // 给出abcde等任意个不同的字符，打印所有组合，5个数字应该是5!组合
    @Test
    public void test1() {
        String s = "abcde";
        // 采取递归的思想
        Set<String> list = print1(s);
        System.out.println("结果数目===" + list.size());
        System.out.println(list);
    }

    public Set<String> print1(String s) {
        char[] chars = s.toCharArray();
        // 只有一个字符的时候，直接返回
        if (chars.length == 1) {
            Set<String> result = new HashSet<>();
            result.add(s);
            return result;
        }
        // 大于1个的时候递归
        char first = chars[0];
        Set<String> temp = print1(new String(chars, 1, chars.length - 1));
        // 让第一个与characters进行组合，然后最终结果
        return getFinalResult(first, temp);
    }

    private Set<String> getFinalResult(char first, Set<String> temp) {
        Set<String> result = new HashSet<>();
        for (String s : temp) {
            char[] chars = s.toCharArray();
            for (int i = 0; i < chars.length + 1; i++) {
                result.add(getString(first, i, chars));
            }
        }
        return result;
    }

    @Test
    public void testGetFinalResult() {
        char first = 'a';
        Set<String> temp = new HashSet<>();
        temp.add("bc");
        // 期待返回abc,bac,bca;
        System.out.println(getFinalResult(first, temp));

    }

    private String getString(char first, int i, char[] chars) {
        char[] chars1 = new char[chars.length + 1];
        for (int j = 0; j < chars1.length; j++) {
            // 比i小的都跟chars一样，比i大的都复制chars的，等于i的赋值first
            if (j < i) {
                chars1[j] = chars[j];
            } else if (j == i) {
                chars1[j] = first;
            } else {
                chars1[j] = chars[j - 1];
            }
        }
        return new String(chars1);
    }

    @Test
    public void testGetString() {
        char[] chars = {'a', 'b'};
        char first = 'c';
        System.out.println(getString(first, 0, chars));
    }


}
