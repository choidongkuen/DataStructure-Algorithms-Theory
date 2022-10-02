// 날짜 : 2022/10/02
// 문제 : 가장 가까운 점

// 문제 설명 :
// 2차 평면 위에 서로 다른 위치에 놓여있는 n개의 점이 주어집니다. 이때 원점에서 가장 가까운 점을 하나 골라, 해당 점의 x, y 값에 2씩 더해주는 작업을 m번 반복하려고 합니다.
// 이를 전부 반복한 이후 원점에 가장 가까이 있는 점을 출력하는 프로그램을 작성해보세요.
// 원점과 특정 점 (x, y)과의 거리는 ∣x∣+∣y∣ 로 생각하며, 만약 원점과의 거리차 최소인 점이 여러 개 있다면 x값이 가장 작은 점을, 만약 그러한 점이 여러 개라면 y값이 가장 작은 점이 원점과 가장 가까이에 있는 점이라 생각합니다.
// 단, 같은 지점에 서로 다른 점이 여러 개가 있는 경우는 발생하지 않는다고 가정해도 좋습니다.

// 입력 형식 :
// 첫 번째 줄에는 n과 m이 공백을 사이에 두고 주어집니다.
// 두 번째 줄 부터는 n개의 줄에 걸쳐 각 점의 위치 (x, y)가 공백을 사이에 두고 한 줄에 하나씩 주어집니다.
// 1 ≤ n, m ≤ 100,000
// 1 ≤ x, y 값 ≤ 10
// 9

// 입력 예시01:
// 3 3
// 1 2
// 3 3
// 4 7

// 출력 예시01:
// 5 5

// 아이디어 :
// x,y 좌표를 속성으로 갖는 Point 클래스를 만들되, 원점과 가까운 점들이 먼저 위치하도록 comparable 인터페이스를 속성받는다.
// m 번 반복하면서 매 턴마다 가장 가까운 점을 출력해야 함으로, 우선순위큐를 이용

package DataStructure.PriortyQueue_힙.힙문제풀이;
import java.util.PriorityQueue;
import java.util.Scanner;

class Pair implements Comparable<Pair> {
    int x, y;

    Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int compareTo(Pair p) {
        if(p.x + p.y != this.x + this.y){
            return (this.x + this.y) - (p.x + p.y);
        }if(this.x != p.x)
            return this.x - p.x;
        return this.y - p.y;
    }
}


public class HeapProblem06 {
    public static final int MAX = 100000;

    public static int n,m;
    public static PriorityQueue<Pair> pq = new PriorityQueue<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        while(n -- > 0){

            int x = sc.nextInt();
            int y = sc.nextInt();

            pq.add(new Pair(x,y));
        }

        while(m -- > 0){
            Pair p = pq.poll();
            pq.add(new Pair(p.x + 2,p.y + 2));
        }

        Pair closeP = pq.poll();
        System.out.println(closeP.x + " " + closeP.y);
    }
}
