// 큐는 먼저 들어온 데이터를 가장 먼저 처리하는 FIFO 구조이다.
// 우선순위 큐는 데이터의 우선순위가 가장 높은 데이터에만 관심이 있고, 이 데이터만 먼저 나갈 수 있는 형태의 자료구조이다.
// 보총 힙을 이용하여 구현(O(logN))
// PriorityQueue<> 를 이용한다.
// 자바에서의 PriotrityQueue는 최솟값을 우선적으로 뽑아주는 '최소 우선순위 큐'를 의미한다.

// 메소드
// add()
// size()
// peek()
// poll() # 우선순위 큐에서 최솟값에 해당하는 데이터를 반환과 동시에 삭제

// MaxHeap(최대 우선순위 큐)를 원한다면 -부호를 이용하여 컨트롤해야한다.



package DataStructure.PriortyQueue_힙;

import java.util.PriorityQueue;

public class Heap01 {
    public static void main(String[] args) {

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        pq.add(2);
        pq.add(100);
        pq.add(-100);
        pq.add(-2031);
        pq.add(0);

//        System.out.println(pq.peek()); // 2031
        while(!pq.isEmpty()){
            System.out.println(pq.poll());
        }
    }
}
