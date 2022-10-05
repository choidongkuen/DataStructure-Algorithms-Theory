// 날짜 : 2022/10/05
// 문제 : BST 개수 세기
// n이 주어질 때, 1 ~ n개로 구성할 수 있는 BST 의 개수를 구하는 프로그램을 작성하시오.


package Algorithms.DynamicProgramming_동적계획법.동적계획법문제풀이;

import java.util.Scanner;

public class DP02 {
    public static long[] dp;
    public static long solution(int n){

        dp[0] = dp[1] = 1;

        for (int i = 2; i <= n ; i++) {
            dp[i] = 0;
            for (int j = 0; j < i ; j++) {
                dp[i] += dp[j] * dp[i - 1 - j];
            }
        }

        return dp[n];
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        dp = new long[n + 1];

        System.out.print("경우의 수 : ");
        System.out.println(solution(n));

        System.out.print("dp 테이블 : ");
        for (int i = 0; i <= n ; i++) {
            System.out.print(dp[i] + " ");
        }
    }
}
