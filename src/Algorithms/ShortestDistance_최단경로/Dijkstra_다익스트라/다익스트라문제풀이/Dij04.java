// 날짜 : 2022/10/03
// 문제 : 최단거리 경로
// 특정 시작점에서 다른 모든 정점으로 가는 최단거리를 구하는 알고리즘 = Dijkstra 알고리즘
// 그렇다면 특정 시작점에서 특정 정점으록 가는 '경로'를 구해보자!

package Algorithms.ShortestDistance_최단경로.Dijkstra_다익스트라.다익스트라문제풀이;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Dij04 {
    public static final int MAX = 100;

    public static int n,m;
    public static PriorityQueue<Element> pq = new PriorityQueue<Element>();
    public static ArrayList<Node>[] graph = new ArrayList[MAX + 1];
    public static int[] dist = new int[MAX + 1];
    public static int[] path = new int[MAX + 1];
    public static int start = 5, end = 1; // 시작 정점 : 5 & 도착 정점 : 1 이라고 가정

    static class Element implements Comparable<Element>{
        int index;
        int dist;
        Element(int index, int dist){
            this.index = index;
            this.dist = dist;
        }
        @Override
        public int compareTo(Element o) {
            return this.dist - o.dist;
        } // 거리 기준으로 오름차순
    }
    static class Node{

        int index;
        int dist;

        Node(int index, int dist){
            this.index = index;
            this.dist = dist;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        for (int i = 1; i <= n ; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 1; i <= m ; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            int z = sc.nextInt();

            graph[x].add(new Node(y,z));
        }

        for (int i = 1; i <= n ; i++) {
            dist[i] = (int)1e9;
        }

        dist[start] = 0;
        pq.add(new Element(start,0));

        while(!pq.isEmpty()){

            int minDist = pq.peek().dist;
            int minIndex = pq.peek().index;
            pq.poll();

            for(int i = 0 ; i < graph[minIndex].size(); i++){

                int targetIndex = graph[minIndex].get(i).index;
                int targetDist = graph[minIndex].get(i).dist;

                int newDist = dist[minIndex] + targetDist;

                if(dist[targetIndex] > newDist){
                    dist[targetIndex] = newDist;
                    pq.add(new Element(targetIndex,newDist)); // 해당 정점과 시작점으로터 거리를 속성으로 하는 인스턴스
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

        System.out.print("경로 : ");
        for (int i = vertex.size() - 1; i >= 0 ; i--) {
            System.out.print(vertex.get(i) + " ");
        }
    }
}
