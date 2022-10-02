// 날짜 : 2022/10/02
// 문제 : 큰 숫자만 계속 고르기

// 문제 설명 :
// n개의 숫자가 주어졌을 때 그 중 가장 큰 숫자를 골라 1씩 빼는 작업을 m번 반복하려고 합니다.
// 이를 반복한 이후 남아있는 숫자들 중 최댓값을 구하는 프로그램을 작성해보세요.
// 단, 가장 큰 숫자가 여러 개라면 이 중 아무거나 하나를 골라 진행하면 됩니다.

// 입력 형식 :
// 첫 번째 줄에는 n과 m이 공백을 사이에 두고 주어집니다.
// 두 번째 줄에는 n개의 숫자가 공백을 사이에 두고 주어집니다.
// 1 ≤ n, m ≤ 100,000
// 1 ≤ 주어지는 숫자들 ≤ 10
// 9

// 입력 예시01:
// 5 4
// 1 5 4 2 1

// 출력 예시01:
// 3

package DataStructure.PriortyQueue_힙.힙문제풀이;

import java.util.PriorityQueue;
import java.util.Scanner;

public class HeapProblem03 {
    public static final int MAX = 100000;
    public static PriorityQueue<Integer> pq = new PriorityQueue<>();
    public static int n,m;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        for (int i = 0; i < n ; i++) {
            pq.add(-sc.nextInt());
        }

        while(m -- > 0){
            int x = -pq.poll() - 1; // 최대값을 가져와서 -1 하고
            pq.add(-x); // 다시 그 값을 추가
        }

        System.out.println(-pq.peek());
    }
}
