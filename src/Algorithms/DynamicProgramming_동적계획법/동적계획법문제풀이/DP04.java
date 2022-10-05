// 날짜 : 2022/10/06
// 문제 : 가장 긴 증가 부분 수열의 길이를 구하여라.


package Algorithms.DynamicProgramming_동적계획법.동적계획법문제풀이;

import java.util.Arrays;
import java.util.Scanner;

public class DP04 {

    public static int[] arr;
    public static int[] dp;

    public static int solution(int n){
        dp = new int[n];

        dp[0] = 1;

        for (int i = 1; i < n ; i++) {

            dp[i] = 0;
            for (int j = 0; j < i ; j++) {
                if(arr[i] > arr[j]) {
                    dp[i] = Math.max(dp[i], dp[j]);
                }
            }
            dp[i] += 1;
        }

        return dp[n - 1];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        } // n개의 숫자 입력


        System.out.println(solution(n));
        for (int i = 0; i < dp.length ; i++) {
            System.out.print(dp[i] + " ");
        }
    }
}
