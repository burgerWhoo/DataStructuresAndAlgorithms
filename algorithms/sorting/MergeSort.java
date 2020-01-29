public class MergeSort {
    /**
     * 归并排序使用了分治思想，用递归来实现
     * 递推公式：merge_sort(p…r) = merge(merge_sort(p…q), merge_sort(q+1…r))
     * 终止条件：p >= r 不用再继续分解
     * <p>
     * 归并排序是稳定的排序
     * 时间复杂度：O(nlogn)
     * 空间复杂度：O(n)
     *
     * @param a 数组
     */
    public static void mergeSort(int[] a) {
        if (a.length < 1) {
            return;
        }
        mergeSort(a, 0, a.length - 1);
    }

    /**
     * 递归调用函数
     *
     * @param a     数组
     * @param start 排序的起始下标
     * @param end   排序的终止下标
     */
    public static void mergeSort(int[] a, int start, int end) {
        if (start >= end) {
            return;
        }

        // 取中间位置
        int mid = (start + end) / 2;
        // 分治递归
        mergeSort(a, start, mid);
        mergeSort(a, mid + 1, end);
        // 合并
        merge(a, start, mid, end);
    }

    /**
     * 归并排序的核心
     * 将有序的两个数组 a[start...mid]与 a[mid+1...end]合并为一个有序数组
     *
     * @param a     数组
     * @param start 起始下标
     * @param mid   中间下标
     * @param end   终止下标
     */
    public static void merge(int[] a, int start, int mid, int end) {
        int i = start;
        int j = mid + 1;
        int[] tmp = new int[end - start + 1];
        int k = 0;
        // 依次比较两个数组中的大小，写入临时数组tmp中
        while (i <= mid && j <= end) {
            if (a[i] < a[j]) {
                tmp[k++] = a[i++];
            } else {
                tmp[k++] = a[j++];
            }
        }

        // 将两个数组中剩余的内容写入临时数组
        while (i <= mid) {
            tmp[k++] = a[i++];
        }
        while (j <= end) {
            tmp[k++] = a[j++];
        }

        // 将临时数组全部拷贝至原数组中
        k = 0;
        while (start <= end) {
            a[start++] = tmp[k++];
        }
    }

    public static void main(String[] args) {
        int[] a = {2, 8, 9, 5, 3, 7, 7, 10, 1};
        mergeSort(a);
        for (int i : a) {
            System.out.println(i);
        }
    }
}