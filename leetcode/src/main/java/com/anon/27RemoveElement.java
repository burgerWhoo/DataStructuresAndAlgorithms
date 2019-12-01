package com.anon;

/**
 * @author wujn
 * @since 2019-11-29 13:03
 **/
class RemoveElement {
    /**
     * leetcode赞数最高的解法。双指针，对不需要删除的数拷贝覆盖。
     * i为快指针，遍历数组；m为慢指针，表示新数组长度。
     * 每当i下标所在的值与删除值不同时，就令nums[m] = nums[i]，此时两个指针都自增。最后返回m
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     */
    public static int removeElement1(int[] nums, int val) {
        if (nums == null) return 0;

        int m = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[m] = nums[i];
                m++;
            }
        }

        return m;
    }

    /**
     * 解法二，也是官方的解法之一。双指针，对需要删除的数交换擦除。
     * 这个代码理解起来更复杂，但是解法一在删除元素少的情况下要做很多赋值操作。解法二更适合删除数比较少的情况。
     * m尾指针表示新数组长度，i头指针。每当i下标所在值为删除值时，nums[i] = nums[m - 1];删除数被覆盖，同时m--，代表擦除一个删除数。
     * 即使删除数被替换到i的位置，因为i没有++，因此下次循环还会再判断的。
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     */
    public static int removeElement2(int[] nums, int val) {
        if (nums == null) return 0;

        int m = nums.length;
        for (int i = 0; i < m; ) {
            if (nums[i] == val) {
                nums[i] = nums[m - 1];
                m--;
            } else {
                i++;
            }
        }
        return m;
    }


    /**
     * 个人解法：与解法2的思想其实类似。
     * 头指针i，尾指针j。i代表删除数，j代表正常数。从头尾找到需要的数后，令nums[i] = nums[j];同时两个指针都向里。
     * 比较好理解，但是不够简洁。
     */
    public static int removeElement(int[] nums, int val) {
        if (nums == null) return 0;

        int i = 0;
        int j = nums.length - 1;
        while (i <= j) {
            if (nums[i] != val) {
                i++;
                continue;
            }
            if (nums[j] == val) {
                j--;
                continue;
            }
            nums[i] = nums[j];
            i++;
            j--;
        }
        return i;
    }

    public static void main(String[] args) {
        int[] nums = {3, 2, 2, 3};
        int val = 3;

        int len = removeElement1(nums, val);

        System.out.println("length: " + len);
        for (int num : nums) {
            System.out.println(num);
        }
    }
}
