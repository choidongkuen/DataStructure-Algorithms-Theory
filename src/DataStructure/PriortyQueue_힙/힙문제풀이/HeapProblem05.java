// 날짜 : 2022/10/2
// 문제 : 원하는 기준에 맞춰 정렬하기

// 문제 설명 :
// [(1, 7), (3, 2), (3, 1), (6, 2)] 와 같이 2차 평면상의
//점들의 위치가 순서대로 주어졌을 때,
//각각의 점의 위치가 주어질 때 마다 지금까지 주어진 점들 중 x,y 의 곱이 가장 큰 경우를 출력하는 프로그램을 작성하시오.

// 아이디어 :
// x,y 좌표값을 속성으로 갖는 클래스를 하나 생성하고,
// 이를 통해 만들 수 있는 인스턴스 우선순위 큐를 하나 생성한다.
// 그 후, n개의 x,y 좌표가 주어질때마다 최대값 반환

// Comparable 인터페이스를 상속하여 클래스를 설계하면
// compareTo 메소드를 통해 우선순위 큐의 우선순위를 정할 수 있다.
// 해당 문제는 두 수의 곱의 큰 값이 앞에 위치(가장 우선순위가 높음)
// 일반적 정수를 원소로 갖는 우선순위 큐일때는 최소 우선순위 큐를 이룬다.

package DataStructure.PriortyQueue_힙.힙문제풀이;

import java.awt.*;
import java.util.PriorityQueue;
import java.util.Scanner;

class Point implements Comparable<Point>{
    int x,y;
    Point(int x, int y){
        this.x = x;
        this.y = y;
    }

    @Override
    public int compareTo(Point o) {
        return o.x * o.y - this.x * this.y;
    }
    // x * y 의 값이 크면 앞에 위치(내림차순)
}


public class HeapProblem05 {

    public static int n;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt(); // n개의 점이 주어진다.

        PriorityQueue<Point> pq = new PriorityQueue<>();

        for (int i = 0; i < n ; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();

            pq.add(new Point(x,y));
            Point bestP = pq.peek(); // x * y 의 값이 가장 큰 경우

            System.out.println(bestP.x + " " + bestP.y);

        }
    }
}
