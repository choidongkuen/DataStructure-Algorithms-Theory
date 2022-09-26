// 양의 정수 n이 주어지고 다음의 연산을 수행할 수 있을 때,
// 1. n이 짝수인 경우, 2로 나누기 연산
// 2. n이 홀수인 경우, 1을 더하거나 1을 빼는 연산
// 주어진 n이 1이 되는데 필요한 '최소한의 연산 횟수'를 반환하세요.

// 입출력 예시
// n : 8
// 출력 : 3

// n : 7
// 출력 : 4

// n : 9
// 출력 : 4

// 아이디어 :
// 4의 배수인 숫자만 연속적인 짝수 순열을 이룰 수 있음 !!

package Algorithms.Greedy_그리디.그리디알고리즘문제풀이;

public class GreedyProblem03 {

    public static int solution(int x){

        if(x == 1)
            return 0;
        if(x == 2)
            return 1;

        int cnt = 0; // 최소한의 연산 횟수

        while(x != 1){
/*
            if(x == 3) {
                cnt += 2;
                break;
            }

 */
            if(x % 2 == 0) {
                x /= 2;
            }
            else if((x + 1) % 4 == 0){ // 홀수이면서 1을 더했을때, 4의 배수인 경우
                x += 1;
            }else if((x - 1) % 4 == 0){ // 홀수이면서 1을 뺐을때, 4의 배수인 경우
                x -= 1;
            }
            cnt ++;
        }

        return cnt;
    }

    public static void main(String[] args) {

        System.out.println(solution(8));
        System.out.println(solution(7));
        System.out.println(solution(9));
    }
}
