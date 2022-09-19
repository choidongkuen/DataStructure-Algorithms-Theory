// 문제 : 카드 섞기
// 1부터 N 까지의 번호로 구성된 N장의 카드가 있다.
// 1번 카드가 가장 위에 그리고 N번 카드는 가장 아래의 상태로 카드가 순서대로 쌓여있다.
// 아래의 동작을 카드 한 장만 남을 때까지 반복했을 때, 가장 마지막에 남는 카드 번호를 출력하시오.
// 1. 가장 위의 카드는 버린다.
// 2. 그 다음 위의 카드는 쌓여 있는 카드의 가장 아래에 다시 넣는다.

// 예시 입력 1)
// n = 4
// 결과 : 4

// 예시 입력 2)
// n = 7
// 결과 : 6

package Queue_큐;

import java.util.*;
import java.util.Queue;

public class QueueProblem04 {
    public static int n;
    public static Queue<Integer> queue = new LinkedList<>();

    public static void main(String[] args) {


        Scanner sc = new Scanner(System.in);
        System.out.print("n을 입력해주세요 : ");
        n = sc.nextInt();

        for(int i = 1; i <= n ; i++)
            queue.add(i); // if(n == 4) -> 4 - 3 - 2 - 1

        while(queue.size() > 1){
            queue.poll();
            queue.add(queue.poll());
        }
        System.out.print("결과 : ");
        System.out.println(queue.peek());
//        System.out.println(queue);
    }
}
