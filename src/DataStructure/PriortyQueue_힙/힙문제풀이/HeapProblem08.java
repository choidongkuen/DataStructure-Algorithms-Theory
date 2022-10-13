// 날짜 : 2022/10/02
// 문제 : 마지막으로 남은 숫자

// 문제 설명 :
// n개의 숫자가 주어졌을 때 가장 큰 숫자 2개를 뽑아 제거하고 두 숫자의 차이에 해당하는 숫자를 다시 집어넣는 것을 2개 이상의 숫자가 남아 있는 한 계속 반복하려고 합니다.
// 만약 뽑은 가장 큰 숫자 2개가 동일하다면, 이 경우에는 차이가 0이기 때문에 새롭게 집어넣지 않는다고 합니다.
// 이 과정을 진행한 이후 마지막으로 남게되는 숫자를 구하는 프로그램을 작성해보세요.

// 입력 형식 :
// 첫 번째 줄에는 n이 공백을 사이에 두고 주어집니다.
// 두 번째 줄에는 n개의 숫자가 공백을 사이에 두고 주어집니다.
// 1 ≤ n ≤ 100,000
// 1 ≤ 주어지는 숫자들 ≤ 10 ^ 9

// 입력 예시 01 :
// 5
// 1 5 3 2 8

// 출력 예시 01 :
// 1


package DataStructure.PriortyQueue_힙.힙문제풀이;
import java.util.PriorityQueue;
import java.util.Scanner;

public class HeapProblem08{

    public static final int MAX = 100000; // n의 최대값
    public static int n;

    public static PriorityQueue<Integer> pq = new PriorityQueue<>();
    // 조건에 부합하는 경우 매번 가장 큰 숫자 2개를 뽑아야 함으로 우선순위 큐 자려구조를 사용한다.
    // 우선순위 큐 => 최대값 find O(1)

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        for (int i = 0; i < n ; i++) {
            pq.add(-sc.nextInt());
        } // n 개의 원소 우선순위 큐에 삽입

        while(pq.size() >= 2) {

            int maxFirst = -pq.poll();
            int maxSecond = -pq.poll();
            // 가장 큰 숫자 2개 제거 및 반환

            int diff = maxFirst - maxSecond;

            if (diff != 0) {
                pq.add(-diff);
            } // 동일하지 않은 값이라면 차이를 다시 삽입

        }

        if (pq.size() == 1) {
            System.out.println(-pq.peek());

        } // 위에 과정 후 하나의 원소만 남는다면 해당 원소 출력

        if(pq.size() == 0){
            System.out.println(-1);
        } // 만약 아무 숫자도 남지 않게 된다면 -1 출력
    }
}