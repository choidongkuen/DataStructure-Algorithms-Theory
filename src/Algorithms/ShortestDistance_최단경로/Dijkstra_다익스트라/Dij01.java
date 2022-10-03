// 다익스트라 구현 방법
// 1. 우선순위 큐와 인접리스트를 이용 O(ElogV)
// 2. 일반 큐와 인접행렬을 이용 O(V^2)

// 1번 방식으로 구현해보기

package Algorithms.ShortestDistance_최단경로.Dijkstra_다익스트라;

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

    static class Element implements Comparable<Element>{ // 우선순위 큐에 넣을 인스턴스의 클래스

        int index;
        int dist;

        Element(int index, int dist){
            this.index = index;
            this.dist = dist;
        }
        @Override
        public int compareTo(Element o) {
            return this.dist - o.dist;
        } // 거리 기준 오름차순으로 우선순위 큐에 저장
    }
    static class Node{
        int index; // 해당 정점의 인덱스
        int dist; // 해당 정점까지의 거리

        Node(int index, int dist){
            this.index = index;
            this.dist = dist;
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("정점의 개수: ");
        n = sc.nextInt();

        System.out.print("간선의 개수: ");
        m = sc.nextInt();

        for (int i = 1; i <= n ; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 1; i <= m ; i++) {
            int x = sc.nextInt(); // 출발 정점
            int y = sc.nextInt(); // 도착 정점
            int z = sc.nextInt(); // 가중치

            graph[x].add(new Node(y,z));
        }

        for (int i = 1; i <= n ; i++) {
            dist[i] = (int)1e9;
        }

        dist[n] = 0; // n정점 이 시작 위치

        pq.add(new Element(n,dist[n])); // 시작 정점을 우선순위 큐에 삽입

        while(!pq.isEmpty()){

            int minIndex = pq.peek().index;
            int minDist = pq.peek().dist;
            pq.poll(); // 해당 정점 삭제

            if(minDist != dist[minIndex])
                continue;

            for (int i = 0; i < graph[minIndex].size() ; i++) { // 현재 최소 거리를 갖는 정점과 연결되어 있는 모든 정점확인

                int targetIndex = graph[minIndex].get(i).index;
                int targetDist = graph[minIndex].get(i).dist;

                int newDist = targetDist + dist[minIndex];
                if(newDist < dist[targetIndex]){
                    dist[targetIndex] = newDist;
                    pq.add(new Element(targetIndex,newDist));
                } // dist 값 업데이트
            }
        }

        for (int i = 1; i <= n ; i++) {
            System.out.print(dist[i] + " ");
        }
    }
}