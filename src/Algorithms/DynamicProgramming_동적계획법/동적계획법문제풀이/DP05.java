// 날짜 : 2022/10/05
// 문제 : 가장 긴 감소하는 부분수열

package Algorithms.DynamicProgramming_동적계획법.동적계획법문제풀이;

import java.util.Arrays;
import java.util.Scanner;

public class DP05 {
    public static int[] arr;
    public static int[] dp;

    public static void solution(int n){
        dp = new int[n];
        dp[0] = 1;

        for (int i = 1; i < n ; i++) {
            dp[i] = 0;
            for (int j = 0; j < i ; j++) {
                if(arr[i] < arr[j]){
                    dp[i] = Math.max(dp[i],dp[j]);
                }
            }
            dp[i] += 1;
        }
        System.out.println(Arrays.stream(dp).max().getAsInt());
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        arr = new int[n];

        for (int i = 0; i < n ; i++) {
            arr[i] = sc.nextInt();
        }
        solution(n);

        System.out.println("dp 테이블 출력 : ");
        System.out.println(Arrays.toString(dp));
    }
}
