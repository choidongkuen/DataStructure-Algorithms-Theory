// 숫자 7193 은 7193도 소수이고,
// 719, 71, 7 도 각각 소수이다.
// n 이 주어질때, n자리 수 중에 위와 같은 소수를 찾는 프로그램을 작성하세요.

// 입출력 얘시 :
// 입력 n : 3
// 출력 : 233, 239, 293, 311, 313, 317, 373, 379, 593, 599, 719, 733, 739, 797


// 아이디어 :
// 특정 n자리 숫자 x 가 해당 조건을 만족하는 수가 되기 위해서는
// 뒤에 자리부터 하나씩 줄였을 때, 계속 소수여야한다.

package Algorithms.BackTracking_백트랙킹.백트랙킹문제풀이;

import java.util.ArrayList;

public class BackTrackingProblem02 {
    public static ArrayList<Integer> answer;

    public static boolean isPrimeNum(int num){
        for(int i = 2; i < num; i ++){
            if(num % i == 0)
                return false;
        }
        return true;
    }
    public static void backTracking(int primeNum, int len, int n) {
        if (len >= n) {
            answer.add(primeNum);
            return;
        }

        for (int i = 0; i < 10; i++) {
            if (i % 2 != 0) {
                int candidatePrimeNum = primeNum * 10 + i;
                if(isPrimeNum(candidatePrimeNum)) {
                    backTracking(candidatePrimeNum, len + 1, n);
                }
            }
        }
    }
    public static ArrayList<Integer> solution(int n){
        answer = new ArrayList<>();

        int[] primeNum = {2,3,5,7};
        for(int i = 0; i < primeNum.length; i ++){
            backTracking(primeNum[i],1,n);
        }

        return answer;
    }
    public static void main(String[] args) {

        System.out.println(solution(3));
        System.out.println();
        System.out.println(solution(4));

    }
}
