// 2번 방식으로 다익스트라를 구현해보자.
// 간선의 정보를 Edge클래스의 인스턴스로 설정

package Algorithms.ShortestDistance_최단경로.Dijkstra_다익스트라;

class Edge{
    int x,y,z;

    public Edge(int x, int y, int z){
        this.x = x;
        this.y = y;
        this.z = z;
    }
}

public class Dij02 {

    public static final int MAX_N = 5; // 정점의 갯수
    public static int[][] graph = new int[MAX_N + 1][MAX_N + 1]; // 인접행렬
    public static boolean[] visited = new boolean[MAX_N + 1]; // 방문 기록을 위한 배열

    public static int[] dist = new int[MAX_N + 1];

    public static void main(String[] args) {

        int n = 5, m = 8;
        // 정점의 수 : 5, 간선의 수 : 8
        // x - > y (z : 가중치)
        Edge[] edges = new Edge[]{
                new Edge(-1, -1, -1),
                new Edge(2, 1, 3),
                new Edge(1, 4, 3),
                new Edge(4, 2, 1),
                new Edge(5, 2, 4),
                new Edge(5, 4, 2),
                new Edge(4, 3, 2),
                new Edge(3, 4, 1),
                new Edge(1, 3, 6)
        };

        for (int i = 1; i <= m; i++) {
            int x = edges[i].x;
            int y = edges[i].y;
            int z = edges[i].z;

            graph[x][y] = z;
        }
        for (int i = 1; i <= n; i++) {
            dist[i] = (int) 1e9; // 무한대로 설정
        }
        dist[5] = 0; // 시작위치 : 5

        for (int i = 1; i < n; i++) {

            int minIndex = -1; // minIndex = 특정 순간의 dist 값이 최소인 원소의 인덱스

            for (int j = 1; j <= n; j++) {
                if (visited[j])
                    continue;
                if (minIndex == -1 || dist[minIndex] > dist[j]) {
                    minIndex = j; // dist 값이 최소인 원소의 인덱스 업데이트
                }
            }

            visited[minIndex] = true; // 방문 기록

            for (int j = 1; j <= n; j++) {
                // 간선이 존재하지 않는 경우에는 넘어갑니다.
                if (graph[minIndex][j] == 0)
                    continue;

                dist[j] = Math.min(dist[j], dist[minIndex] + graph[minIndex][j]);
            }
        }

        // 시작점(5번 정점)으로부터 각 지점까지의 최단거리 값을 출력합니다.
        for (int i = 1; i <= n; i++)
            System.out.print(dist[i] + " ");
    }
}

