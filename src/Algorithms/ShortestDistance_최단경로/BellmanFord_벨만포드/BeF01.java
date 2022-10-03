// 다익스트라는 음수 가중치가 있을 때 정상 작동하지 않는다.
// 매번 모든 간선을 확인하기 때문에 다익스트라에 비해 느리다.
// 시간 복잡도 : O(VE)

package Algorithms.ShortestDistance_최단경로.BellmanFord_벨만포드;

public class BeF01 {

    static class Edge{
        int from;
        int to;
        int weight;

        Edge(int from, int to, int weight){
            this.from = from;
            this.to = to;
            this.weight = weight;
        }
    }
    public static void bellmanFord(int v, int e, int[][] data, int start){

        Edge[] edges = new Edge[e];

        for (int i = 0; i < e ; i++) {
            edges[i] = new Edge(data[i][0],data[i][1],data[i][2]);
        } // 간선 정보 저장

        int[] dist = new int[v + 1];
        for (int i = 1; i <= v ; i++) {
            dist[i] = (int)1e9;
        } // 거리 배열 초기화

        dist[start] = 0;
        boolean isMinusCycle = false;

        for(int i = 0; i < v + 1; i ++){ // 모든 정점에 대해서
            for(int j = 0; j < e; j ++){ // 모든 간선 체크
                Edge cur = edges[j];

                if(dist[cur.from] == (int)1e9)
                    continue;
                // 시작 정점이 무한대라면 업데이트 의미 x
                if(dist[cur.to] > dist[cur.from] + cur.weight){
                    dist[cur.to] = dist[cur.from] + cur.weight;

                    if(i == v){ // 마지막 사이클
                        isMinusCycle = true;
                    }
                } // 업데이트
            }
        }
        System.out.println("음수 사이클 발생 : " + isMinusCycle);
        for(int i = 1; i <= v; i ++){
            if(dist[i] == (int)1e9)
                System.out.print("INF" + " ");
            else
                System.out.print(dist[i] + " ");
        }

    }
    public static void main(String[] args) {
        int[][] data = {{1,2,8},{1,3,6},{1,5,5},{2,3,-5},{2,4,1},{2,6,4},{3,4,4},{4,7,3},{5,6,5},{6,2,0},{6,7,-7}};
        bellmanFord(7,11,data,1);
        // v : 정점의 수
        // e : 간선의 수
        // start : 시작 정점
    }
}
