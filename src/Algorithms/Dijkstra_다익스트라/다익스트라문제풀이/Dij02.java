// 날짜 : 2022/10/03
// 문제 : 가장 오래 걸리는 학생
// 문제 설명 :
// N개의 서로 장소가 있습니다. 1번부터 N - 1번 장소에는 학생이 한 명씩 살고 있고, N번 장소는 학교입니다.
// 두 개의 장소를 연결하는 간선은 없거나, 있다면 최대 1개만 있으며 주어지는 모든 간선은 방향성을 갖습니다.
// 간선마다 길이가 주어지며, 각 학생은 등교시 최단거리로 학교로 이동한다고 합니다. 모든 학생은 거리 1을 이동하는 데 1초의 시간이 걸린다 했을 때,
// 학교에 등교하는 데 가장 오래 걸리는 학생의 소요 시간을 구하는 프로그램을 작성해보세요.

// 입력 형식 :
// 첫 번째 줄에는 N(장소의 개수)과 M(간선의 개수)이 공백을 사이에 두고 차례대로 주어집니다.
// 두 번째 줄에는 간선을 이루고 있는 두 장소의 번호 i, j와 간선의 길이 d가 각각 공백을 사이에 두고 차례대로 주어집니다.
// 이는 장소 i에서 장소 j로 가는 데 길이가 d 임을 뜻합니다.
// 모든 학생이 등교하는 것이 가능함을 가정해도 좋습니다.
// 1 ≤ N ≤ 100,000
// 1 ≤ M ≤ 100,000
// 1 ≤ 간선의 길이 ≤ 1,000

// 입력 예시 01 :
// 5 6
// 2 1 1
// 1 5 2
// 4 5 100
// 4 2 9
// 3 2 3
// 4 3 5

// 출력 예시 01 :
// 11

// 아이디어 :
// 각 지점에서 n정점까지의 거리를 매번 구하기 보다는
// 주어지는 간선의 정보를 반대로 설정하여 n번 정점에서 각 정점까지의 거리를 구한다. O(ElogV)

package Algorithms.Dijkstra_다익스트라.다익스트라문제풀이;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Dij02 {
    public static final int MAX_N = 100000;
    public static final int MAX_M = 100000;

    public static int n, m;
    public static ArrayList<Edge>[] graph = new ArrayList[MAX_N + 1]; // 각 정점에 연결된 정점들을 구현하기 위한 인접리스트
    public static PriorityQueue<Element> pq = new PriorityQueue<>(); // 최소거리 우선순위 큐
    public static int[] dist = new int[MAX_N + 1]; // 각 정점까지의 거리를 원소로 하는 1차원 배열

    static class Edge {
        int index;
        int dist;

        Edge(int index, int dist) {
            this.index = index;
            this.dist = dist;
        }
    }

    static class Element implements Comparable<Element> {
        int index;
        int dist;

        Element(int index, int dist) {
            this.index = index;
            this.dist = dist;
        }

        @Override
        public int compareTo(Element o) {
            return this.dist - o.dist;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        while (m-- > 0) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            int z = sc.nextInt();

            graph[y].add(new Edge(x, z)); // y -> x with z
        } // 인접리스트 원소 입력

        for (int i = 1; i <= n; i++) {
            dist[i] = (int) 1e9;
        }

        dist[n] = 0; // 출발 지점(학교)
        pq.add(new Element(n, 0));

        while (!pq.isEmpty()) {

            int minIndex = pq.peek().index;
            int minDist = pq.peek().dist;
            pq.poll(); // dist값이 가장 작은 정점 삭제

//            if(minDist != dist[minIndex])
//                continue;

            for (int i = 0; i < graph[minIndex].size(); i++) {

                int targetIndex = graph[minIndex].get(i).index; // minIndex 정점으로부터 갈 수 있는 정점의 인덱스
                int targetDist = graph[minIndex].get(i).dist; // // minIndex 정점으로부터 갈 수 있는 정점까지의 거리

                int newDist = dist[minIndex] + targetDist;
                if (dist[targetIndex] > newDist) {
                    dist[targetIndex] = newDist;
                    pq.add(new Element(targetIndex, newDist));
                }
            }
        }

//        for (int i = 1; i <= n ; i++) {
//            System.out.print(dist[i] + " ");
        System.out.println(Arrays.stream(dist).max().getAsInt());
    }
}
