// 날짜 : 2022/10/05
// 문제 : 격자 안에서 한 칸씩 이동하는 경우
// 문제 설명 :
// 주어지는 격자에서 최상단에서 시작 해서 특정 위치 (r, c)에서의 이동은 (r+1, c) 혹은 (r+1, c+1) 지점으로만 가능할 때
// 최하단 행에서 얻을 수 있는 최대 합을 구할 수 있는 프로그램을 작성하세요.



package Algorithms.DynamicProgramming_동적계획법.동적계획법문제풀이;

import java.util.Arrays;
import java.util.Scanner;

public class DP03 {

    public static int[][] arr; // 원소 정보가 주어지는 2차원 배열
    public static int[][] dp; // 2차원 dp 배열

    public static int solution(int n){

        for (int i = 0; i < n; i++) {
            dp[0][i] = arr[0][i];
        } // 최상단 원소

        for (int i = 1; i < n; i++) {
            dp[i][0] = arr[i - 1][0] + arr[i][0];
        } // 0열 원소(only 위에서 올 수 있음)

        for (int i = 1; i < n ; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = Math.max(dp[i - 1][j - 1],dp[i - 1][j]) + arr[i][j];
            }
        } // 그 외 일반적인 셀

        int maxVal = -1;
        for (int i = 0; i < n ; i++) {
            maxVal = Math.max(maxVal, dp[n - 1][i]);
        } // 최하단 셀들 중 최대값

        return maxVal;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        arr = new int[n][n];
        dp = new int[n][n];

        for (int i = 0; i < n ; i++) {
            for (int j = 0; j < n ; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        System.out.print("최하단 최대값 : ");
        System.out.println(solution(n));
        System.out.println("dp 배열 : ");

        for (int i = 0; i < n ; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
    }
}
