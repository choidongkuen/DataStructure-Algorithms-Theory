// 날짜 : 2022/10/06
// 문제 : knapsack
// 문제 설명 :
// 가방의 크기와 n개의 보석의 가치, 보석의 무게가 주어 질 때, 주어진 가방의 크기로 훔칠 수 있는 보석의 최대 가치는?

package Algorithms.DynamicProgramming_동적계획법.동적계획법문제풀이;

import java.util.Arrays;
import java.util.Scanner;

public class DP08 {
    public static int bag; // 주어지는 가방의 무게
    public static int n; // 보석의 종류
    public static int k; // 주어지는 가방의 크기
    public static int[] weight; // n개의 보석의 무게
    public static int[] prices; // n개의 보석의 가치

    public static int[][] dp; // dp 테이블
    public static int solution(){
        dp[0][0] = 0;
        // 보석을 0번째 까지 고려해서 0무게 까지 담을 때 최대 가치 = 0

        // case 1 : i 번째 보석을 선택 할 경우
        // 딘 이 경우 weight[i] <= j 여야 한다.
        // dp[i][j] = dp[i - 1][j - weight[i]] + prices[i]

        // case 2 : i 번째 보석을 선택 하지 않은 경우
        // dp[i][j] = dp[i - 1][j]

        // 결론 : 만약 weight[i] <= j:
        // dp[i][j] = Math.min(case1,case2)
        // 그렇지 않다면
        // dp[i][j] = case2;

        for (int i = 1; i <= n ; i++) {
            for (int j = 0; j <= k ; j++) {
                if(weight[i] > j) // case 2
                    dp[i][j] = dp[i - 1][j];
                else{ // case 1
                    dp[i][j] = Math.max(dp[i - 1][j],dp[i - 1][j - weight[i]] + prices[i]);
                }
            }
        }
        int ans = -1;
        for (int i = 0; i <= k ; i++) {
            ans = Math.max(ans, dp[n][k]);
        }
        return ans;
    }
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();

        weight = new int[n + 1];
        prices = new int[n + 1];

        System.out.println("보석의 무게 입력 : ");
        for (int i = 1; i <= n ; i++) {
            weight[i] = sc.nextInt();
        }

        System.out.println("보석의 가치 입력 : ");
        for (int i = 1; i <= n ; i++) {
            prices[i] = sc.nextInt();
        }
        dp = new int[n + 1][k + 1]; // 공간 복잡도 : O(NK)
        System.out.println(solution());

        for (int i = 1;  i <= n ; i++) {
            for (int j = 0; j <= k ; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
    }
}
