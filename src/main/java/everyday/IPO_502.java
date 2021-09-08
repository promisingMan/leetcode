package everyday;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @author zengjia
 * @date 2021-09-08 14:01:13
 */
public class IPO_502 {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        int n = capital.length;

        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(new int[]{capital[i], profits[i]});
        }
        list.sort((a, b) -> a[0] - b[0]);

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((a, b) -> b - a);

        int i = 0;
        while (k-- > 0) {
            while (i < n) {
                int[] arr = list.get(i);
                if (w < arr[0]) {
                    break;
                }
                priorityQueue.offer(arr[1]);
                i++;
            }
            if (!priorityQueue.isEmpty()) {
                w += priorityQueue.poll();
            }
        }

        return w;
    }

    public static void main(String[] args) {
        new IPO_502().findMaximizedCapital(2, 0, new int[]{1, 2, 3}, new int[]{0, 1, 1});
    }
}
