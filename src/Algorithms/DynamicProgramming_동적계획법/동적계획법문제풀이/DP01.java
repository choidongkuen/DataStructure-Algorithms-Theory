// 날짜 : 2022/10/06
// 문제 : 타일 채우기
// 문제 설명 :
// 2×N 크기의 벽을 2×1, 1×2 크기의 타일로 채울려고 합니다.
// N이 주어질때 주어진 벽의 규격으로 채울 수 있는 경우의 수를 구하는 프로그램을 작성하세요.

// dp[0] = 0, dp[1] = 1
// dp[i] = dp[i - 1] + dp[i - 2] , i >= 2



package Algorithms.DynamicProgramming_동적계획법.동적계획법문제풀이;

import java.util.Scanner;

public class DP01 {
    public static long[] dp;

    public static long solution(int n){
        dp = new long[n + 1];
        dp[0] = dp[1] = 1;

        for (int i = 2; i <= n ; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        System.out.print("경우의 수 : ");
        System.out.println(solution(n));
        System.out.print("dp 테이블 : ");
        for (int i = 1; i <= n ; i++) {
            System.out.print(dp[i] +  " ");

        }
    }
}
