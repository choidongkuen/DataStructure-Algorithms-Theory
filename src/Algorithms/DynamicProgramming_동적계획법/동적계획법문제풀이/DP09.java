// 날짜 : 2022/10/06
// 문제 : 숫자 암호 만들기
// 주어진 숫자 [1,2,3,4] 를 이용하여 만들 수 있는 암호의 갯수는?

// 입출력 예시
// n : 4
// 1 + 1 + 1 + 1 → 1111
// 1 + 1 + 2 → 112
// 1 + 2 + 1 → 121
// 2 + 1 + 1 → 211
// 1 + 3 → 13
// 2 + 2 → 22
// 3 + 1 → 31
// 4 → 4

// 8 개

package Algorithms.DynamicProgramming_동적계획법.동적계획법문제풀이;

import java.util.Arrays;
import java.util.Scanner;

public class DP09 {

    public static int[] numbers = {1,2,3,4};
    public static int[] dp;
    public static int n;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        dp = new int[n + 1];

        dp[0] = 1; // 의미상 1가지
        dp[1] = 1;

        for (int i = 2; i <= n ; i++) {
            dp[i] = 0;

            for (int j = 0; j < numbers.length ; j++) {
                if(i >= numbers[j])
                    dp[i] += dp[i - numbers[j]];
            }
        }
        System.out.println(dp[n]);
        System.out.println(Arrays.toString(dp));
    }
}
