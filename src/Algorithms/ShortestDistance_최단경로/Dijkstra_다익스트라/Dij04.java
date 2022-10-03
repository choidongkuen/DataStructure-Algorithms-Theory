// 다익스트라 기본 구현
// 강의 그대로 구현해보기
// 우선순위 큐로 해결

package Algorithms.ShortestDistance_최단경로.Dijkstra_다익스트라;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class Dij04 {

    static class Node{
        int to; // 시작 정점
        int weight; // 가중치

        public Node(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }
    public static void dijkstra(int v, int[][] data, int start){

        ArrayList<ArrayList<Node>> graph = new ArrayList<>();
        // 인접리스트
        int[] dist = new int[v + 1];
        // 각 정점까지의 거리를 원소로 하는 1차원 배열
        boolean[] visited = new boolean[v + 1];
        // 방문 기록용 배열

        for (int i = 1; i <= v ; i++) {
            dist[i] = (int)1e9;
        }

        dist[start] = 0;

        for (int i = 0; i <= v ; i++) {
            graph.add(new ArrayList<>());
        } // 정점 갯수 만큼 배열리스트 추가

        for (int i = 0; i < data.length ; i++) {
            graph.get(data[i][0]).add(new Node(data[i][1], data[i][2]));
        }

        PriorityQueue<Node> pq = new PriorityQueue<>((x,y) -> x.weight - y.weight);
        pq.add(new Node(start,0));

        while(!pq.isEmpty()){
            Node curNode = pq.poll();

            if(dist[curNode.to] < curNode.weight){
                continue;
            } // curNode 에서 curNode.to로 갈려고 할때,
              // 가중치 자체가 기존의 dist[curNode.to]보다 클 때


            for (int i = 0; i < graph.get(curNode.to).size() ; i++) {
                Node adjNode = graph.get(curNode.to).get(i);

                //////////////////////////////////////////////////////
                if(dist[adjNode.to] > curNode.weight + adjNode.weight){
                    dist[adjNode.to] = curNode.weight + adjNode.weight;
                    pq.add(new Node(adjNode.to, dist[adjNode.to]));
                }
                //////////////////////////////////////////////////////
            }
        }

        for(int i = 1; i <= v; i ++){
            if(dist[i] == (int)1e9)
                System.out.print("INF" + " ");
            else
                System.out.print(dist[i] + " ");
        }
    }

    public static void main(String[] args) {

        int[][] data = {{1,2,2},{1,3,3},{2,3,4},{2,4,5},{3,4,6},{5,1,1}};
        dijkstra(5,data,1);
        // v : 정점의 갯수
        // start : 시작 정점 번호
    }
}
