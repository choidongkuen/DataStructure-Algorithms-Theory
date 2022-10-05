package Algorithms.DynamicProgramming_동적계획법;


import java.util.Arrays;

public class DP01 {
    public static long[] memo;
    public static long[] dp;

    public static long fibo01(int x){ // recursive O(2^n)
        if(x <= 2)
            return 1;
        return fibo01(x - 1) + fibo01(x - 2);
    }

    public static long fibo02(int x){ // memoization O(n)
        if(memo[x] != -1)
            return memo[x];

        if(x <= 2){
            memo[x] = 1;
        }
        else{
            memo[x] = fibo02(x - 1) + fibo02(x - 2);
        }

        return memo[x];
    }

    public static long fibo03(int x){ // tabulation O(n)
        dp[1] = dp[2] = 1;

        for (int i = 3; i <= x ; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[x];
    }
    public static void main(String[] args) {

        int n = 10000000; // 50 번째 피보나치 수
        memo = new long[n + 1];
        dp = new long[n + 1];
        Arrays.fill(memo,-1);

        System.out.println(fibo01(10));
        System.out.println(fibo02(100));
        System.out.println(fibo03(100));
    }
}
