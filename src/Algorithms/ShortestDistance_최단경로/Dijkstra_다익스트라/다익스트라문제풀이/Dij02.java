// 날짜 : 2022/10/03
// 문제 : 각 정점까지의 최단 경로
// 문제 설명 :
// n개의 정점이 존재하고 m개의 간선의 양 끝 정점과 가중치가 주어질 때, k번 정점에서 다른 모든 정점으로 가는 최단 경로를 구하는 프로그램을 작성해보세요.
// 이때 주어지는 정점과 간선들로 구성되는 그래프는 '양방향 그래프'라고 가정합니다.

// 입력 형식 :
// 첫 번째 줄에 정점의 개수 n과 간선의 개수 m이 공백을 두고 주어집니다.
// 두 번째 줄에 k가 주어집니다.
// 세 번째 줄부터 m개의 줄에 걸쳐, 각 간선의 양 끝 정점의 번호와 해당 간선에 주어진 가중치가 공백을 두고 주어집니다.
// 중복되는 간선은 주어지지 않는다고 가정해도 좋습니다.
// 1 ≤ n ≤ 20,000
// 1 ≤ m ≤ 300,000
// 1 ≤ k ≤ n
// 1 ≤ 간선의 가중치 ≤ 10

// 입력 예시01 :
// 5 6
// 1
// 5 1 1
// 1 2 2
// 1 3 3
// 2 3 4
// 2 4 5
// 3 4 6

// 출력 예시01 :
// 0
// 2
// 3
// 7
// 1

package Algorithms.ShortestDistance_최단경로.Dijkstra_다익스트라.다익스트라문제풀이;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Dij02 {
    public static final int MAX_N = 20000;
    public static final int MAX_M = 300000;
    public static int n,m,k;

    public static ArrayList<Edge>[] graph = new ArrayList[MAX_N + 1];
    public static PriorityQueue<Element> pq = new PriorityQueue<>();
    public static int[] dist = new int[MAX_N + 1];

    static class Edge{
        int index, dist;
        Edge(int index, int dist){
            this.index = index;
            this.dist = dist;
        }
    }

    static class Element implements Comparable<Element>{

        int index, dist;
        Element(int index, int dist){
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
        n = sc.nextInt(); // 정점의 갯수
        m = sc.nextInt(); // 간선의 갯수
        k = sc.nextInt(); // 시작하는 정점

        for (int i = 1; i <= n ; i++) {
            graph[i] = new ArrayList<>();
        }

        while(m -- > 0){
            int x = sc.nextInt();
            int y = sc.nextInt();
            int z = sc.nextInt();

            graph[x].add(new Edge(y,z));
            graph[y].add(new Edge(x,z));
        }

        for (int i = 1; i <= n ; i++) {
            dist[i] = (int)1e9;
        }

        dist[k] = 0; // 시작 정점은 0
        pq.add(new Element(k,0));


        while(!pq.isEmpty()){

            int minDist = pq.peek().dist;
            int minIndex = pq.peek().index;
            pq.poll();

            if(minDist != dist[minIndex])
                continue;

            for (int i = 0; i < graph[minIndex].size() ; i++) {
                int targetIndex = graph[minIndex].get(i).index;
                int targetDist = graph[minIndex].get(i).dist;

                int newDist = dist[minIndex] + targetDist;
                if(dist[targetIndex] > newDist){
                    dist[targetIndex] = newDist;
                    pq.add(new Element(targetIndex, newDist));
                }
            }
        }

        for(int i = 1;i <= n; i ++){

            if(dist[i] == (int)1e9){
                System.out.println(-1);
            }else{
                System.out.println(dist[i]);
            }
//            System.out.println(dist[i]);
        }
    }
}
