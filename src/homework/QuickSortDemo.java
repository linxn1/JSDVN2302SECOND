package homework;

import java.util.Arrays;

public class QuickSortDemo {
    public static void main(String[] args) {
        /**
         * 直接对原数组进行修改
         */
        int[] arr = {9, 4, 6, 8, 3, 10, 4, 6};
        quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    private static int partition(int[] arr, int low, int high) {
//        int temp;
        int point = low;//将第一个值作为打标
        while (true) {
            while (arr[low] > arr[point]) {
                low++;
            }
            while (arr[high] < arr[point]) {
                high--;
            }
            if (low >= high) {
                break;
            } else {
                point = low;
                low = high;
                high = point;
            }
        }
        return point;
    }

    private static void quickSort(int[] arr, int low, int high) {
        int k = partition(arr, low, high);//k将数组分为两个部分
        if (low < k) {
            quickSort(arr, low, k);
        }
        if (k < high) {
            quickSort(arr, k, high);
        }
        return;
    }
}
