// 요세푸스 문제
// n과 k가 주어질 때, (n,k) 요세푸스 순열을 구하시오.
// n과 k는 n >= k 를 만족하는 양의 정수이다.
// 1부터 n까지 n명이 순서대로 원을 이루어 모여 있다.
// 이 모임에서 원을 따라, 순서대로 k번째 사람을 제외한다.
// 모든 사람이 제외될 때까지, 반복하며 이때, 제외되는 순서가 요세푸스 순열이다.

package Queue_큐;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class QueueProblem05 {
    public static int n,k;
    public static Queue<Integer> q = new LinkedList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();

        for(int i = 1; i <= n ; i++)
            q.add(i);
        // 큐 생성

        System.out.print("요세푸스 순열 => ");
        while(q.size() != 0){
            for(int i = 0; i < k - 1; i++){
                q.offer(q.poll());
            }
            System.out.print(q.poll()+ " ");
        }
    }
 }
