package com.anon;

/*
 * [1] 两数之和
 *
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
 *
 * example：
 * 给定 nums = [2, 7, 11, 15], target = 9
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 */

import java.util.HashMap;

/**
 * @author anon
 * @since 2019-11-24 17:15
 **/
class TwoSum {

    /*
     * 方法一：暴力破解
     *
     * 最容易想到的方法，遍历数组的每个元素x同时，查找其后target-x是否存在
     *
     * 时间复杂度: O(n^2); 两层循环
     * 空间复杂度: O(1); 不需要开辟新的空间
     */
    static int[] twoSum1(int[] nums, int target) {
        if (nums == null) return null;

        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }

    /*
     * 方法二：哈希表
     *
     * 方法一的时间复杂度比较高，在此基础上，应该考虑是否能够以空间换时间。
     * 为了降低查找的效率，很容易想到哈希表，因为它的查找用时近似为常数。在题设中，相同的数不会出现两次，因此哈希表的查找用时为O(1)。
     * 一边遍历数组，一边将target-x的值作为key存在hash表中。
     *
     * 时间复杂度: O(n); 只需一次迭代
     * 空间复杂度: O(n); 哈希表存储了数组中的元素，因此复杂度为n
     *
     * <p>
     *     有网友说hashMap.containsKey(value)最差的情况也是O(n)，在大数据量时才能看到优势。需要多了解数据结构的实现原理，多用不同的场景测试
     * </p>
     */
    static int[] twoSum2(int[] nums, int target) {
        if (nums == null) return null;

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{map.get(target - nums[i]), i};
            }
            map.put(nums[i], i);
        }
        return null;
    }

    public static void main(String[] args) {
        int[] nums = {3, 2, 4};
        int target = 6;

        int[] result = twoSum2(nums, target);

        for (int i : result) {
            System.out.println(i);
        }
    }

}
