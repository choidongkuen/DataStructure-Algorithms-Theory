// 다익스트라 구현 방법
// 1. 우선순위 큐와 인접리스트를 이용 O(ElogV)
// 2. 일반 큐와 인접행렬을 이용 O(V^2)

// 1번 방식으로 구현해보기

package Algorithms.Dijkstra_다익스트라;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Dij01 {

    public static final int MAX_N = 100;
    public static final int MAX_M = 100;

    public static int n,m; // 정점의 갯수와 간선의 갯수
    public static ArrayList<Node>[] graph = new ArrayList[MAX_N + 1];
    public static PriorityQueue<Element> pq = new PriorityQueue<>();

    public static int[] dist = new int[MAX_N + 1];
    public static Node[] nodes = new Node[MAX_M + 1];
    static class Node{
        int index,dist;

        Node(int y, int z){
            this.index = y;
            this.dist = z;
        }
    }
    // y 정점으로의 방향으로 z의 가중치를 가진다.
    static class Element implements Comparable<Element>{
        int dist, index;
        public Element(int dist, int index){
            this.dist = dist;
            this.index = index;
        }

        public int compareTo(Element e){
            return this.dist - e.dist;
        } // 가까운 거리가 가장 먼저 위치
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        for (int i = 1; i <= m ; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 1; i <= m ; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            int z = sc.nextInt();

            graph[x].add(new Node(y,z));
        } // x - > y 로 z 의 가중치

        for(int i = 1; i <= n; i ++)
            dist[i] = (int)1e9;

        dist[5] = 0;
        // 시작위치에는 dist값을 0으로 설정

        pq.add(new Element(0,5));
        // 시작위치를 우선순위 큐에 삽입

        while(!pq.isEmpty()){

            int minDist = pq.peek().dist;
            int minInd = pq.peek().index;

            pq.poll(); // 가장 거리가 가까운 정점 삭제

            if(minDist != dist[minInd])
                continue;

            for (int j = 0; j < graph[minInd].size() ; j++) {
                int targetIndex = graph[minInd].get(j).index;
                int targetDist = graph[minInd].get(j).dist;
                // 최솟값에 해당하는 정점에 연결된 간선들을 보며
                // 최단거리 값을 갱신

                int newDist = dist[minInd] + targetDist;
                if(dist[targetIndex] > newDist){
                    dist[targetIndex] = newDist; // 거리 갱신
                    pq.add(new Element(newDist,targetIndex));
                }
            }
        }

        for (int i = 1; i <= n ; i++) {
            System.out.print(dist[i] + " ");
        }
    }
}
