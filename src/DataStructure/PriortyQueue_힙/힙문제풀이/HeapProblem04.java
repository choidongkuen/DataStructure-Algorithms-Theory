// 날짜 : 2022/10/02
// 문제 : 최소 정수 출력

// 문제 설명 :
// 비어있는 배열에 연산을 하려 합니다. 연산은 다음 2가지입니다.
// 입력이 자연수 x라면, 배열에 자연수 x를 넣습니다.
// 입력이 0이라면 배열에서 가장 작은 값을 출력하고 그 값을 배열에서 제거합니다.
// 입력된 연산을 실행하는 프로그램을 작성해보세요

// 입력 형식 :
// 첫 번째 줄에 연산의 개수 n이 주어집니다.
// 두 번째 줄부터 n + 1 번째 줄 까지는 정수 x 가 주어집니다.
// 1 ≤ n ≤ 100,000
// 0 ≤ x ≤ 2
// 31

// 입력 예시01 :
// 8
// 0
// 1
// 324
// 2346534
// 5
// 0
// 0
// 0

// 출력 예시01 :
// 0
// 1
// 5
// 324

package DataStructure.PriortyQueue_힙.힙문제풀이;

import java.util.PriorityQueue;
import java.util.Scanner;

public class HeapProblem04 {
    public static final int MAX = 100000;

    public static int n;
    public static PriorityQueue<Integer> pq = new PriorityQueue<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt(); // 연산의 갯수 입력

        while (n -- > 0){
            int num = sc.nextInt();
            if(num == 0){
                if(pq.isEmpty()){
                    System.out.println(0);
                }else{
                    System.out.println(pq.poll());
                }
            }else{
                pq.add(num);
            }
        }
    }
}
