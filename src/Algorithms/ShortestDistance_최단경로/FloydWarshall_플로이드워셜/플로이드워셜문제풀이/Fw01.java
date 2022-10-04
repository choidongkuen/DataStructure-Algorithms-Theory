// 모든 정점에서 각 정점까지의 최단 거리를 구하는 알고리즘
// 시간 복잡도 : O(v^3)
// 공간 복잡도 : O(v^2)

package Algorithms.ShortestDistance_최단경로.FloydWarshall_플로이드워셜.플로이드워셜문제풀이;

public class Fw01 {

    public static int n = 5, m = 8;
    public static int[][] dist = new int[n + 1][n + 1]; // dist 배열

    static class Edge {
        int from;
        int to;
        int weight;
    }

    public static void main(String[] args) {

        // n : 정점의 수, m : 간선의 수

        int[][] data = {{2,1,3},{1,4,3},{4,2,1},{5,2,4},{5,4,2},{4,3,2},{3,4,1},{1,3,6}};

        for (int i = 1; i <= n ; i++) {
            for (int j = 1; j <= n ; j++) {
                if(i != j)
                    dist[i][j] = (int)1e9;
            }
        } // dist 배열 초기화

        for (int i = 0; i < m ; i++) {
            dist[data[i][0]][data[i][1]] = data[i][2];
        } // dist 베열 2차 초기화

        for (int k = 1; k <= n ; k++) {
            for (int i = 1; i <= n ; i++) {
                for (int j = 1; j <= n ; j++) {
                    dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                }
            }
        }

        for (int i = 1; i <= n ; i++) {
            for (int j = 1; j <= n ; j++) {
                if(dist[i][j] == (int)1e9)
                    System.out.print(-1 + " ");
                else
                    System.out.print(dist[i][j] + " ");
            }
            System.out.println();
        }
    }
}
