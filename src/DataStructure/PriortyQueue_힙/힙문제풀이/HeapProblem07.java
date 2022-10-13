// 날짜 : 2022/10/13
// 문제 : 배열 추출

// 문제 설명 :
// 배열에 다음과 같은 연산을 할 수 있습니다.
// 배열에 자연수 x를 넣습니다.
// 배열에서 가장 큰 값을 출력하고, 그 값을 배열에서 제거합니다.
// 비어있는 배열에서 시작하여 입력된 연산을 실행하는 프로그램을 작성해보세요.

// 입력 형식 :
// 첫 번째 줄에 연산의 개수 n이 주어집니다.
// 다음 n개의 줄에는 연산에 대한 정보를 나타내는 정수 x가 주어집니다.
// x가 자연수라면 배열에 x라는 값을 넣습니다.
// x가 0이라면 배열에서 가장 큰 값을 출력하고 그 값을 배열에서 제거합니다.

// 1 ≤ n ≤ 10,000
//
// 0 ≤ 입력되는 수 ≤ 100,000


// 입력 예시 01 :

// 12
// 0
// 1
// 2
// 0
// 0
// 3
// 2
// 1
// 0
// 0
// 0
// 0

// 출력 예시 01 :
// 0
// 2
// 1
// 3
// 2
// 1
// 0
package DataStructure.PriortyQueue_힙.힙문제풀이;

import java.util.PriorityQueue;
import java.util.Scanner;

public class HeapProblem07 {

    public static final int MAX = 10000; // n 의 최대값

    public static PriorityQueue<Integer> pq = new PriorityQueue<>();
    public static int n;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        while(n --> 0){
            int x = sc.nextInt();
            if(x != 0){
                pq.add(-x);
            }else{
                if(x == 0 && pq.size() == 0){
                    System.out.println(0);
                }else{
                    int result = pq.poll();
                    System.out.println(-result);
                }
            }
        }
    }
}
