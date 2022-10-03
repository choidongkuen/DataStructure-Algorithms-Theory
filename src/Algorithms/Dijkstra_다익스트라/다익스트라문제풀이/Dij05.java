// 날짜 : 2022/10/03
// 문제 : 최단 거리

// 문제 설명 :
// n개의 정점과 m개의 간선에 대한 정보로 각 간선의 길이가 주어질 때, 정점 A에서 정점 B까지의 최단 거리와 그 때의 경로를 구하는 프로그램을 작성해보세요.
// 이때 주어지는 정점과 간선들로 구성되는 그래프는 '양방향 그래프'라고 가정합니다.

// 입력 형식 :
// 첫 번째 줄에 정점의 개수 n, 간선의 개수 m 이 공백을 두고 주어집니다.
// 두 번째 줄부터 m개의 줄에 걸쳐 각 간선 양쪽 끝 정점의 번호와 해당 간선의 길이가 공백을 사이에 두고 주어집니다.
// 단, 동일한 간선이 여러 번 주어지는 경우는 없다고 가정해도 좋습니다.
// m+2 번째 줄에는 구하려는 도시 A와 B의 정점 번호가 공백을 사이에 두고 주어집니다.
// 1 ≤ n ≤ 1,000
// 1 ≤ m ≤ 100,000
// 1 ≤ 각 간선의 길이 ≤ 100,000

// 입력 예시 01:
// 5 8
// 1 2 2
// 1 3 3
// 1 4 1
// 1 5 10
// 2 4 2
// 3 4 1
// 3 5 1
// 4 5 3
// 1 5

// 출력 예시 01:
// 3
// 1 4 3 5

package Algorithms.Dijkstra_다익스트라.다익스트라문제풀이;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Dij05 {

    public static final int MAX_N = 1000;
    public static final int MAX_M = 100000;
    public static ArrayList<Node>[] graph = new ArrayList[MAX_N + 1];
    public static PriorityQueue<Element> pq = new PriorityQueue();
    public static int[] dist = new int[MAX_N + 1];
    public static int[] path = new int[MAX_N + 1];

    public static int n,m;
    public static int start,end; // 시작 정점과 끝 정점의 번호

    static class Node{
        int index,dist;

        Node(int index, int dist){
            this.index = index;
            this.dist = dist;
        }
    }
    static class Element implements Comparable<Element>{

        int index,dist;

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
        n = sc.nextInt();
        m = sc.nextInt();

        for (int i = 1; i <= n ; i++) {
            graph[i] = new ArrayList<>();
        }

        while(m -- > 0){
            int x = sc.nextInt();
            int y = sc.nextInt();
            int z = sc.nextInt();

            graph[x].add(new Node(y,z));
            graph[y].add(new Node(x,z));
        }



        for (int i = 1; i <= n ; i++) {
            dist[i] = (int)1e9;
        }

        start = sc.nextInt();
        end = sc.nextInt(); // 시작,끝 정점 입력

        dist[start] = 0;
        pq.add(new Element(start,0));

        while(!pq.isEmpty()){

            int minDist = pq.peek().dist;
            int minIndex = pq.peek().index;
            pq.poll();

            for (int i = 0; i < graph[minIndex].size() ; i++) { // minIndex 정점에 연결된 모든 정점 확인

                int targetIndex = graph[minIndex].get(i).index; // minIndex에서 도달할 수 있는 정점
                int targetDist = graph[minIndex].get(i).dist; // minIndx정점으로 부터 targetIndex 정점까지의 거리

                int newDist = targetDist + dist[minIndex];

                if(dist[targetIndex] > newDist){
                    dist[targetIndex] = newDist;
                    pq.add(new Element(targetIndex,newDist));
                    path[targetIndex] = minIndex;
                }
            }
        }

        int x = end;

        ArrayList<Integer> vertex = new ArrayList<>();
        vertex.add(x);
        while(x != start){
            x = path[x];
            vertex.add(x);
        }

        System.out.println(dist[end]);
        for (int i = vertex.size() - 1; i >= 0 ; i--) {
            System.out.print(vertex.get(i) + " ");
        }
    }
}
