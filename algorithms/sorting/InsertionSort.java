public class InsertionSort {
    /**
     * 插入排序
     * 插入排序将数组分为已排序区间和未排序区间。将未排序区间的数逐个插入到已排序区间中。
     * 
     * @param a 数组
     */
    public static void insertionSort(int[] a) {
        int n = a.length;
        if (n <= 1)
            return;

        for (int i = 1; i < n; i++) {
            // 记录此次需要插入的值
            int value = a[i];
            int j = i - 1;
            // 从后向前遍历已排序区，如果插入值更小，则将已排序区的数据往后移动一位，直至找到应插入的位置
            for (; j >= 0; --j) {
                if (value < a[j]) {
                    a[j + 1] = a[j];
                } else {
                    break;
                }
            }
            // 插入
            a[j + 1] = value;
        }
    }

    public static void main(String[] args) {
        int[] a = { 2, 8, 9, 5, 3 };
        insertionSort(a);
        for (int i : a) {
            System.out.println(i);
        }
    }
}