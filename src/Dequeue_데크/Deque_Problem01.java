package Dequeue_데크;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class Deque_Problem01 {
    public static void main(String[] args) {
        // addFirst, addLast, offerFirst, offerLast, pollFirst, pollLast, removeFirst, removeLast

        Deque<Integer> deque = new ArrayDeque<>(); // deque 선언
        Queue<Integer> queue = new LinkedList<>(); // queue 선언

        // front 부분 입력
        deque.addFirst(1);
        deque.addFirst(2);
        deque.addFirst(3);
        deque.addFirst(4);
        deque.addFirst(5); // 앞쪽에 값 삽입

        System.out.println(deque); // 데크 출력
        deque.clear();
        // rear 부분 입력

        deque.addLast(1);
        deque.addLast(2);
        deque.addLast(3);
        deque.addLast(4);
        deque.addLast(5);

        System.out.println(deque); // 데크 출력

        // front 부분 출력
        System.out.println(deque.removeFirst());
        System.out.println(deque);

        // rear 부분 출력
        System.out.println(deque.removeLast());
        System.out.println(deque);

        // front 부분 출력

        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);
        queue.add(5);

        System.out.println(queue);
    }
}
