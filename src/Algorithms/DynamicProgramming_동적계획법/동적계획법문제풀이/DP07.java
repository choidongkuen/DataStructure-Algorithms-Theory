// 날짜 : 2022/10/05
// 문제 : 정수 n이 주어질 때 아래의 연산을 통해 1로 만들려고 한다.
    // 2으로 나누어 떨어지면 2으로 나누기
    // 3으로 나누어 떨어지면 3으로 나누기
    // 1 빼기

// 위에 연산을 통해 1로 만들 때 필요한 최소한의 연산 횟수를 출력하는 프로그램을 작성하세요.

package Algorithms.DynamicProgramming_동적계획법.동적계획법문제풀이;

import java.util.Arrays;

public class DP07 {
    public static int[] dp;

    public static int solution(int n){
        dp = new int[n + 1];
        dp[1] = 0;

        for (int i = 2; i <= n ; i++) {
            dp[i] = dp[i - 1] + 1;
            // 모든 수는 1을 뺄 수 있음

            if(i % 2 == 0)
                dp[i] = Math.min(dp[i], dp[i / 2] + 1);
            if(i % 3 == 0)
                dp[i] = Math.min(dp[i], dp[i / 3] + 1);
        }

        return dp[n];
    }
    public static void main(String[] args) {


//        System.out.println(solution(2)); // 1
//        System.out.println(solution(4)); // 2
//        System.out.println(solution(9)); // 2
        System.out.println(solution(10)); // 3
        System.out.println(Arrays.toString(dp));
    }
}
