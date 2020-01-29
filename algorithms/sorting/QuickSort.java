public class QuickSort {
    /**
     * 快速排序使用了分治思想，用递归来实现 递推公式：quick_sort(p…r) = quick_sort(p…q-1) + quick_sort(q+1…
     * r) 终止条件：p >= r
     * <p>
     * 快速排序过程中相同元素可能因为分区而交换顺序，因此它不是一个稳定的排序算法 时间复杂度：O(nlogn)，在极端情况下会退化至O(n^2)
     * 空间复杂度：O(n)
     *
     * @param a
     */
    private static void quickSort(int[] a) {
        if (a.length < 1) {
            return;
        }
        quickSort(a, 0, a.length - 1);
    }

    /**
     * 快速排序的递归函数
     *
     * @param a     数组
     * @param start 起始下标
     * @param end   终止下标
     */
    private static void quickSort(int[] a, int start, int end) {
        if (start >= end) {
            return;
        }
        // 获取分区点
        int p = partition(a, start, end);
        // 以分区点划分分区，进行分治递归
        quickSort(a, start, p - 1);
        quickSort(a, p + 1, end);
    }

    /**
     * 快速排序的分区函数，这是快排的核心 在本例中借鉴了插入排序的做法，使用交换元素来避免进行元素的搬移 默认的基准元素为数组的最后一个元素
     *
     * @param a     数组
     * @param start 起始下标
     * @param end   终止下标
     * @return 分区完成后分区点的下标
     */
    private static int partition(int[] a, int start, int end) {
        // a[i]左边存放比基准元素小的元素，右边存放比基准元素大的元素
        int i = start;
        // j表示当前遍历到的元素下标
        int j = start;
        while (j < end) {
            // 如果a[j]比基准元素小，交换a[i],a[j],并将下标i增加一位
            if (a[j] < a[end]) {
                swap(a, i, j);
                i++;
            }
            j++;
        }
        // 将a[i]与基准元素交换
        swap(a, i, end);
        return i;
    }

    /**
     * 数组元素交换函数
     *
     * @param a 数组
     * @param i 需要交换的元素下标
     * @param j 需要交换的元素下标
     */
    private static void swap(int[] a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    public static void main(String[] args) {
        int[] a = { 2, 8, 9, 5, 3, 7, 7, 10 };
        quickSort(a);
        for (int i : a) {
            System.out.println(i);
        }
    }

}