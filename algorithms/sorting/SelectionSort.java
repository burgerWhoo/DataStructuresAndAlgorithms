public class SelectionSort {
    /**
     * 选择排序 将数组分为已排序区间和未排序区间。选择未排序区间中最小的数，与未排序区第一个数进行交换(相当于放到已排序区末尾)。
     * 
     * @param a 数组
     */
    public static void selectionSort(int[] a) {
        int n = a.length;
        if (n <= 1)
            return;

        for (int i = 0; i < n; i++) {
            // 找到未排序区最小的数，记录其位置
            int minPos = i;
            for (int j = i + 1; j < n; j++) {
                if (a[j] < a[minPos]) {
                    minPos = j;
                }
            }
            // 将未排序区最小的数与未排序区第一个数进行交换
            int tmp = a[i];
            a[i] = a[minPos];
            a[minPos] = tmp;
        }
    }

    public static void main(String[] args) {
        int[] a = { 2, 8, 9, 5, 3 };
        selectionSort(a);
        for (int i : a) {
            System.out.println(i);
        }
    }
}