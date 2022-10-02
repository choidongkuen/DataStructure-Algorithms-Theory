// 날짜 : 2022/10/02
// 문제 : 정수 명령 처리
// 문제 설명 :
// 정수를 저장하는 최대 우선순위 큐를 구현한 다음, 입력으로 주어지는 명령을 처리하는 프로그램을 작성해보세요. 명령어는 총 5가지 입니다.
// 명령어 :
// push A: 정수 A를 우선순위 큐에 넣는 연산입니다.
// pop: 우선순위 큐에서 최댓값을 제거하고, 그 값을 출력합니다.
// size: 우선순위 큐에 들어있는 정수의 개수를 출력합니다.
// empty: 우선순위 큐가 비어있으면 1, 아니면 0을 출력합니다.
// top: 우선순위 큐에 들어있는 값 중 최댓값을 출력합니다.

// 입력 형식 :
// 첫 번째 줄에는 명령어의 가짓수 N이 주어집니다.
// 두 번째 줄부터 N번째 줄에는 명령어가 하나씩 주어집니다. 문제에 나와있지 않은 명령이 주어지는 경우는 없으며, 불가능한 명령이 주어지는 경우 역시 없다고 가정해도 좋습니다.
// 1 ≤ N ≤ 10,000
// 1 ≤ 주어지는 정수 ≤ 100,000

// 입력 예시01:
// 6
// push 3
// size
// empty
// pop
// push 3
// size

// 출력 얘시01:
// 1
// 0
// 3
// 1

// 아이디어 :
// 최대 우선순위 큐를 구현해야 함으로, 데이터 삽입 / 반환시 -을 붙인다 !!

package DataStructure.PriortyQueue_힙.힙문제풀이;

import java.util.PriorityQueue;
import java.util.Scanner;

public class HeapProblem01 {

    public static final int MAX_N = 10000;

    public static PriorityQueue<Integer> pq = new PriorityQueue<>();
    public static int n;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        while(n -- > 0){
            String command = sc.next();

            if(command.equals("push")){
                Integer data = sc.nextInt();
                pq.add(-data);
            }else if(command.equals("size")){
                System.out.println(pq.size());
            }else if(command.equals("pop")){
                System.out.println(-pq.poll());
            }else if(command.equals("empty")){
                System.out.println(pq.isEmpty()? 1:0);
            }else{
                System.out.println(-pq.peek());
            }
        }
    }
}
