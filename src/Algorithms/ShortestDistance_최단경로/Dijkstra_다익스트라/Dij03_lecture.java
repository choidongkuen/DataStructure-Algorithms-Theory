// 다익스트라 기본 구현
// 강의 그대로 구현해보기
// 반복문으로 해결

package Algorithms.ShortestDistance_최단경로.Dijkstra_다익스트라;

import java.util.ArrayList;

public class Dij03_lecture {
    static class Node{
        int to; // 시작 정점
        int weight; // 가중치

        public Node(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }

    public static void dijkstra(int v, int[][] data, int start) {

        ArrayList<ArrayList<Node>> graph = new ArrayList<>();
        // 2차원 배열 리스트를 선언
        boolean[] visited = new boolean[v + 1];
        // 방문 배열
        int[] dist = new int[v + 1];
        // 각 지점까지의 거리 배열

        for (int i = 0; i < v + 1; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < data.length; i++) {
            graph.get(data[i][0]).add(new Node(data[i][1], data[i][2]));
        } // 인접리스트 초기화

        for (int i = 1; i <= v; i++) {
            dist[i] = (int) 1e9;
        } // 거리 배열 초기화

        dist[start] = 0;

        for (int i = 1; i <= v; i++) {
            int minDist = (int) 1e9;
            int minIdx = 0;
            for (int j = 1; j <= v; j++) {
                if (!visited[j] && dist[j] < minDist) {
                    minDist = dist[j];
                    minIdx = j;
                }
            }
            // 최소 거리를 가지는 정점을 뽑아
            visited[minIdx] = true;
            // 선택된 최소 값을 지니는 정점 방문 기록

            for (int j = 0; j < graph.get(minIdx).size() ; j++) {
                Node targetNode = graph.get(minIdx).get(j);

                if(dist[targetNode.to] > dist[minIdx] + targetNode.weight){
                    dist[targetNode.to] = dist[minIdx] + targetNode.weight;
                }
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