package DataStructure.PriortyQueue_힙.힙문제풀이;

import java.io.PrintWriter;
import java.util.PriorityQueue;

public class HeapProblem02 {
    public static void main(String[] args) {
        int[] arr = {3, 6, 2, 6, 7, 7, 2};

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < 7 ; i++) {
            pq.add(-arr[i]);
            System.out.println();
        }
    }
}
