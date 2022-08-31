// 큐의 기본적인 메서드 구현해보기

package Queue_큐;

import java.util.LinkedList;
import java.util.Queue;

public class QueueProblem01  {
    public static void main(String[] args){
        Queue queue = new LinkedList(); // linkedlist 을 이용해서 구현

        queue.add(2);
        queue.add(3);
        queue.add(4); // add 메서드
        System.out.println(queue);

        System.out.println(queue.poll()); // 앞(front)에서 삭제
        System.out.println(queue);

        System.out.println(queue.peek()); // 앞(front)출력

        System.out.println(queue.contains(3));
        System.out.println(queue.size());
        System.out.println(queue.isEmpty());

        // 데이터가 없을시 poll 을 하면 null 반환
        // stack 에서는 pop 시 예외 반환
    }
}
