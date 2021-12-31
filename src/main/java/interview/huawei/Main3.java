package interview.huawei;// 本题为考试单行多行输入输出规范示例，无需提交，不计分。

import java.util.Scanner;

public class Main3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int x = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int[] suffixSum = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            suffixSum[i] = suffixSum[i - 1] + arr[i - 1];
        }

        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (suffixSum[j + 1] - suffixSum[i] >= x) {
                    ans += n - j;
                    break;
                }
            }
        }

        System.out.println(ans);
    }
}