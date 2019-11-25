package com.anon;

/*
 * [66] 加一
 *
 * 给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
 * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 *
 * example:
 * 输入: [1,2,3]
 * 输出: [1,2,4]
 * 解释: 输入数组表示数字 123。
 */

/**
 * @author anon
 * @since 2019-11-25 10:18
 **/
class PlusOne {
    /*
     * 可将问题分为以下三种情况：
     *  1、给定整数最后一位不是9，如1234；
     *  2、给定整数最后几位是9，如1239；
     *  3、给定整数所有位数均为9，如9999；
     *
     * 解决方法：
     *  1、最后一位 + 1，返回数组；
     *  2、从最后一位遍历数组，逢9置0，前一位 + 1，一直到非9结束；
     *  3、从最后一位遍历数组，没有非9的数。由于999加一变成1000，因此可以新建一个长度增加一位的数组，将数组首位置1。
     *
     */
    public static int[] plusOne(int[] digits) {
        if (digits == null) return null;

        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] == 9) {
                digits[i] = 0;
            } else {
                digits[i]++;
                return digits;
            }
        }
        int[] newDigits = new int[digits.length + 1];
        newDigits[0] = 1;
        return newDigits;
    }

    public static void main(String[] args) {
        int[] digits = {9};

        int[] result = plusOne(digits);

        for (int i : result) {
            System.out.println(i);
        }
    }
}
