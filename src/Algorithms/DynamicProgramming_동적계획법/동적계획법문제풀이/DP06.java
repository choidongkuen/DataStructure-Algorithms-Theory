// 날짜 : 2022/10/06
// 문제 : 최소의 동전 갯수로 거슬러주기
// 문제 설명 :
// 1,4,5 원의 동전으로 n원을 거슬러 줄 때, 최소한의 동전 갯수로 거슬러 주려고한다.
// n이 주어질 때, 최소 동전의 수를 구하세요.

package Algorithms.DynamicProgramming_동적계획법.동적계획법문제풀이;

import java.util.Scanner;

public class DP06 {
    public static int[] coins = {1,4,5};
    public static int[] dp;

    public static int solution(int n){

        dp[0] = 0;

        for (int i = 1; i <= n ; i++) {
            dp[i] = Integer.MAX_VALUE;
            for (int j = 0; j < coins.length; j++) {
                if (i >= coins[j])
                    dp[i] = Math.min(dp[i], dp[i - coins[j]]);
            }
            dp[i] ++;
        }

        return dp[n];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        dp = new int[n + 1];

        System.out.println(solution(n));
        System.out.println("dp 테이블 : ");

        for (int i = 0; i <= n ; i++) {
            System.out.print(dp[i] + " ");
        }
    }
}
