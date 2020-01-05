package sorting;

public class BubbleSort {
    /**
     * 冒泡排序
     * 每次冒泡操作会对相邻的两个元素进行比较，对不满足大小关系要求的数进行互换。
     *
     * @param a 数组
     */
    public static void bubbleSort(int[] a) {
        int n = a.length;
        // 数组长度小于1时直接退出
        if (n <= 1)
            return;

        for (int i = 0; i < n; i++) {
            // 标记用来判断是否有数据交换
            boolean flag = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (a[j] > a[j + 1]) { // 交换
                    int tmp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = tmp;
                    flag = true;
                }
            }
            // 没有数据交换，提前退出
            if (flag == false)
                break;
        }
    }

    public static void main(String[] args) {
        int[] a = { 2, 8, 9, 5, 3 };
        bubbleSort(a);
        for (int i : a) {
            System.out.println(i);
        }
    }
}
