// 날짜 : 2022/10/03
// 문제 : 사전순으로 가장 앞선 최단거리 경로

// 문제 설명 :
// Dij05에서 최단거리의 경로를 구해보았다.
// 그렇다면 이런 최단거리 경로가 2개 이상일 때, 정점의 번호가 가장 작은 경우를 선택하여 출력해보자(사전순)

package Algorithms.Dijkstra_다익스트라.다익스트라문제풀이;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Dij06 {
    public static int n = 5;
    public static int m = 8;

    public static int[] dist = new int[n + 1];
    public static ArrayList<Node>[] graph = new ArrayList[n + 1];
    public static PriorityQueue<Element> pq = new PriorityQueue();

    public static int start = 1;
    public static int end = n;

    static class Node {
        int index, dist;

        Node(int index, int dist) {
            this.index = index;
            this.dist = dist;
        }
    }

    static class Element implements Comparable<Element> {
        int index, dist;

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

        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 1; i <= m; i++) {

            int x = sc.nextInt();
            int y = sc.nextInt();
            int z = sc.nextInt();

            graph[x].add(new Node(y, z));
        }

        for (int i = 1; i <= n; i++) {
            dist[i] = (int) 1e9;
        }

        dist[end] = 0;
        pq.add(new Element(end, 0)); // 시작 위치 : end

        while (!pq.isEmpty()) {

            int minDist = pq.peek().dist;
            int minIndex = pq.peek().index;
            pq.poll();

            for (int i = 0; i < graph[minIndex].size(); i++) {
                int targetIndex = graph[minIndex].get(i).index;
                int targetDist = graph[minIndex].get(i).dist;

                int newDist = targetDist + dist[minIndex];

                if (dist[targetIndex] > newDist) {
                    dist[targetIndex] = newDist;
                    pq.add(new Element(targetIndex, newDist));
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            System.out.print(dist[i] + " ");
        }
        System.out.println();

        int x = start;
        System.out.print(x + " ");

//        System.out.println(graph[2].get(2).dist + dist[2] + " !!!");

        while (x != end) {
            for (int i = 1; i <= n; i++) {
                boolean find1 = false;
                for (int j = 0; j < graph[i].size(); j++) {
                    boolean find2 = false;
                    if (graph[i].get(j).index == x) {
                        boolean find3 = false;
                        if (dist[i] + graph[i].get(j).dist == dist[x]) {
                            x = i;
                            find3 = true;
                            break;
                        }
                        if(find3) {
                            find2 = true;
                            break;
                        }
                    }
                    if(find2){
                        find1 = true;
                        break;
                    }
                }
                if(find1){
                    break;
                }
            }
            System.out.print(x + " ");
        }
    }
}

