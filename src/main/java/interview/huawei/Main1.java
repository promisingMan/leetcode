package interview.huawei;// 本题为考试单行多行输入输出规范示例，无需提交，不计分。

import java.util.Arrays;
import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);
        boolean[] visited = new boolean[n];
        int count = n;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (visited[i]) {
                continue;
            }
            for (int j = i; j < n; j++) {
                if (arr[j] % arr[i] == 0 && !visited[j]) {
                    visited[j] = true;
                    count--;
                }
            }
            ans++;
            if (count == 0) {
                break;
            }
        }
        System.out.println(ans);
    }
}