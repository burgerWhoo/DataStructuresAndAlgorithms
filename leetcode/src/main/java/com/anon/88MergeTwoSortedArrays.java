package com.anon;

/*
 *给定两个有序整数数组 nums1 和 nums2，将 nums2 合并到 nums1 中，使得 num1 成为一个有序数组。
 * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n。
 * 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
 */

/**
 * @author anon
 * @since 2019-11-23 14:05
 **/
class MergeTwoSortedArrays {
    static void merge1(int[] nums1, int m, int[] nums2, int n) {
        m = m - 1;
        n = n - 1;
        while (m >= 0 && n >= 0) {
            if (nums1[m] > nums2[n]) {
                nums1[m + n + 1] = nums1[m];
                m--;
            } else {
                nums1[m + n + 1] = nums2[n];
                n--;
            }
        }
        for (int i = 0; i <= n; i++) {
            nums1[i] = nums2[i];
        }
    }

    public static void main(String[] args) {
        int[] nums1 = {2, 3, 5, 0, 0, 0};
        int[] nums2 = {1, 4, 5};

        merge1(nums1, 3, nums2, 3);

        for (int i : nums1) {
            System.out.println(i);
        }
    }
}
