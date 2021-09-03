package arr_str;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @author zengjia
 * @date 2021-09-03 09:48:43
 */
public class SmallestKLCCI {
    public int[] smallestK(int[] arr, int k) {
        Arrays.sort(arr);
        return Arrays.copyOf(arr, k);
    }

    public int[] smallestK1(int[] arr, int k) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        for (int i : arr) {
            priorityQueue.offer(i);
        }
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = priorityQueue.poll();
        }
        return res;
    }

    public int[] smallestK2(int[] arr, int k) {
        quickSort(arr, k, 0, arr.length - 1);
        int[] res = new int[k];
        System.arraycopy(arr, 0, res, 0, k);
        return res;
    }

    public void quickSort(int[] arr, int k, int left, int right) {
        if (left >= right) {
            return;
        }
        int mid = getMiddleAndSwap(arr, left, right);
        if (mid == k) {
            return;
        }
        if (k > mid) {
            quickSort(arr, k, mid + 1, right);
        } else {
            quickSort(arr, k, left, mid - 1);
        }
    }

    private int getMiddleAndSwap(int[] arr, int left, int right) {
        int i = left, j = right;
        int pivot = arr[i];

        while (i < j) {
            while (i < j && arr[j] >= pivot) {
                j--;
            }
            while (i < j && arr[i] <= pivot) {
                i++;
            }
            if (i < j) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        arr[left] = arr[i];
        arr[i] = pivot;

        return i;
    }

    public static void main(String[] args) {
        new SmallestKLCCI().smallestK2(new int[]{1, 3, 5, 7, 2, 4, 6, 8}, 4);
    }
}