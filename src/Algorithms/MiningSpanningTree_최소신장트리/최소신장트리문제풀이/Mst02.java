// practice 02
// 문제 설명 :
// v 개의 건물과 e 개의 도로로 구성된 도시가 있다.
// 도로는 양방향이고, 연결된 도로는 유지하는데 비용이 든다.

// 새롭게 도시 계획을 개편하여 기존의 도시를 두 개의 도시로 분할해서 관리하고자 한다.
// 도시에는 하나 이상의 건물이 있어야 하고,
// 도시 내의 임의의 두 건물은 도로를 통해 이동이 가능해야 한다.
// 두 건물 간 도로가 직접 연결이 되지 않고 다른 건물을 통해서 이동해도 가능하다.
// 새롭게 개편하는 도시 계획에 따라 구성했을 때 최소한의 도로 유지비 비용 계산 프로그램을 작성하세요.


// 입출력 예시
// 입력 :
// v : 7
// e : 12
// data : {{1,2,3},{1,3,2},{1,6,2},{2,5,2},{3,2,1},{3,4,4},{4,5,3},{5,1,5},{6,4,1},
//              {6,5,3},{6,7,4},{7,3,6}}

// 출력 : 8

// MST 로 최소한의 가중치로 모든 정점을 연결한 후,
// 두개의 도시로 분할가능하여 최소한의 도로 유지비 비용 계산 ? - > 간선 중 가장 가중치가 큰 간선을 삭제!
// prim 으로 풀어보자

package Algorithms.MiningSpanningTree_최소신장트리.최소신장트리문제풀이;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class Mst02 {
    public static ArrayList<Node>[] graph;
    public static boolean[] visited;

    static class Node{
        int to;
        int weight;

        Node(int to, int weight){
            this.to = to;
            this.weight = weight;
        }
    }

    public static int prim() {
        PriorityQueue<Node> pq = new PriorityQueue<>((x, y) -> x.weight - y.weight);
        int weightSum = 0;
        int maxWeight = 0; // 마지막에 구한 weightSum에서 maxWeight을 빼줘야 한다.

        pq.add(new Node(1, 0));
        int cnt = 0;

        while (!pq.isEmpty()) {
            Node cur = pq.poll();

            if (visited[cur.to])
                continue;

            visited[cur.to] = true;
            weightSum += cur.weight;

            maxWeight = Math.max(maxWeight, cur.weight);

            for (int i = 0; i < graph[cur.to].size(); i++) {
                Node adjNode = graph[cur.to].get(i);

                if (visited[adjNode.to]) {
                    continue;
                }
                pq.add(adjNode);

            }
        }
        return weightSum - maxWeight;

    }
        public static void solution ( int v, int e, int[][] data) {
            graph = new ArrayList[v + 1];


            for (int i = 1; i <= v; i++) {
                graph[i] = new ArrayList<>();
            }

            for (int i = 0; i < data.length; i++) {
                graph[data[i][0]].add(new Node(data[i][1], data[i][2]));
                graph[data[i][1]].add(new Node(data[i][0], data[i][2]));
            }

            visited = new boolean[v + 1];
            System.out.println(prim());
        }

    public static void main(String[] args) {

        int v = 7;
        int e = 12;
        int[][] data = {{1,2,3},{1,3,2},{1,6,2},{2,5,2},{3,2,1},{3,4,4},{4,5,3},{5,1,5},{6,4,1},
         {6,5,3},{6,7,4},{7,3,6}};

        solution(v,e,data);
    }
}
