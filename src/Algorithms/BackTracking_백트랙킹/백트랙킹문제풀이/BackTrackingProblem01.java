// 정수형 n과 m이 주어질때
// '1부터 n까지의 정수 중에서 중복 없이 m개'를 고른 수열을 출력하는 프로그램을 작성하세요.

// 입출력 예시
// n : 3
// m : 2
// 출력 : [1,2],[1,3],[2,1],[2,3],[3,1],[3,2]

// 아이디어 :
// 1 ~ 3 의 수를 2 크기의 자리를 갖는 리스트에 배치시키는 경우의 수를 구하는 것임으로,
// 백트랙킹!(재귀!!) (비슷한 문제 : n 자리의 크기를 갖는 2진수를 오름차순으로 나열하기)

package Algorithms.BackTracking_백트랙킹.백트랙킹문제풀이;
import java.util.ArrayList;

public class BackTrackingProblem01 {
     public static ArrayList<Integer> answer = new ArrayList<>();
     public static int n,m; // n : 숫자의 범위, m : 리스트의 크기

    public static void print(){
        System.out.println(answer);
    }

    public static void solution(int currNum){
        if(currNum == m + 1){
            print();
            return;
        }
        for(int i = 1; i <= n; i ++){
            answer.add(i);
            solution(currNum + 1);
            answer.remove(answer.size() - 1);
        }
    }

    public static void main(String[] args) {
        // case 01
        n = 3;
        m = 2;
        solution(1);
        // case 02
        n = 4;
        m = 3;
        solution(1);
    }
}
