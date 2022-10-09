// 날짜 : 2022/10/06
// 문제 : 최장공통부분수열(LCS)
// 문제 설명 :
// LCS는 Longest Common Subsequence의 약자로, 최장 공통 부분 수열이라고 해석됩니다.
// 부분 수열이란, 순서대로 뽑아서 나올 수 있는 수열을 의미하며 예를 들어 ABCK는 ACBCK의 부분 수열입니다.
// 그 중에서도 두 문자열에게 공통으로 부분 수열인 경우를 공통 부분 수열이라 부르고, 그 중 가장 길이가 긴 경우를 최장 공통 부분 수열이라고 부릅니다.
// 예를 들어, ABABA와 BAAB의 LCS는 BAB 이므로, LCS의 길이는 3이 됩니다.

// 두 문자열 A,B 가 주어질 때 LCS 의 길이를 구하세요.
// 입출력 예시 :
// A : ABABA
// B : BAAB

// LCS : BAB (3)

// 아이디어 :
// 연속적인 부분 수열 x, only 부분 수열!!
// dp 배열은 1부터 n까지

package Algorithms.DynamicProgramming_동적계획법.동적계획법문제풀이;

import java.util.Arrays;
import java.util.Scanner;

public class DP10 {
    public static String A;
    public static String B;
    public static int[][] dp;
    public static int solution(){

        char[] a = new char[A.length() + 1];
        char[] b = new char[B.length() + 1];

        for (int i = 1; i < a.length ; i++) {
            a[i] = A.charAt(i - 1);
        }
        for (int i = 1; i < b.length ; i++) {
            b[i] = B.charAt(i - 1);
        }

//        System.out.println(Arrays.toString(a));
//        System.out.println(Arrays.toString(b));

        dp = new int[a.length][b.length]; // length + 1

        if(a[1] != b[1])
            dp[1][1] = 0;
        else
            dp[1][1] = 1;

        for (int i = 2; i < a.length ; i++) {
            if(a[i] == b[1]){
                for (int j = i; j < a.length ; j++) {
                    dp[j][1] = 1;
                }
                break;
            }
            dp[i][1] = 0;
        }

        for (int i = 2; i < b.length ; i++) {
            if(a[1] == b[i]){
                for (int j = i; j < b.length ; j++) {
                    dp[1][j] = 1;
                }
                break;
            }
            dp[1][i] = 0;
        }

        for (int i = 2; i < a.length ; i++) {
            for (int j = 2; j < b.length ; j++) {
                if(a[i] == b[i])
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                else
                    dp[i][j] = Math.max(dp[i - 1][j],dp[i][j - 1]);
            }
        }


        return dp[a.length - 1][b.length - 1];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        A = sc.next();
        B = sc.next();

        dp = new int[A.length() + 1][B.length() + 1];
        System.out.println(solution());

        for (int i = 1; i < A.length() + 1; i++) {
            for (int j = 1; j < B.length() + 1; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
    }
}