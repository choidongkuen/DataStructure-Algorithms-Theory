// trim 으로 구현해보기

package Algorithms.MiningSpanningTree_최소신장트리;

import com.sun.java.accessibility.util.SwingEventMonitor;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class Mst02 {
    static class Node{
        int to;
        int weight;

        public Node(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }

    public static boolean[] visited;
    public static PriorityQueue<Node> pq = new PriorityQueue<>((x,y) -> x.weight - y.weight);
    public static int prim(int[][] data, int v, int e){

        int weightSum = 0;
        ArrayList<Node>[] graph = new ArrayList[v + 1];
        visited = new boolean[v + 1];


        for (int i = 1; i <= v ; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < e ; i++) {
            graph[data[i][0]].add(new Node(data[i][1],data[i][2]));
            graph[data[i][1]].add(new Node(data[i][0],data[i][2]));
        } // 간선 수만큼 그래프 정보 업데이트

        pq.add(new Node(1,0)); // 임의의 노드 선택

        int cnt = 0;

        while(!pq.isEmpty()){
            Node cur = pq.poll();
            cnt += 1;

            if(visited[cur.to])
                continue;
            visited[cur.to] = true;
            weightSum += cur.weight;

            if(cnt == v){ // 모든 정점 연결
                return weightSum;
            }

            for (int i = 0; i <  graph[cur.to].size(); i++) {
                Node adjNode = graph[cur.to].get(i);

                if(visited[adjNode.to])
                    continue;
                pq.add(adjNode);
            }
        }

        return weightSum;
    }
    public static void main(String[] args) {

        int v = 7;
        int e = 10;
        int[][] graph = {{1,3,1},{1,2,9},{1,6,8},{2,4,13},{2,5,2},{2,6,7},
                {3,4,12},{4,7,17},{5,6,5},{5,7,20}};

        System.out.println(prim(graph,v,e));

    }
}
