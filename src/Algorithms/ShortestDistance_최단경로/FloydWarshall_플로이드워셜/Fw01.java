// 각 정점에서 모든 정점으로 가는 최단거리를 모두 구해주는 알고리즘
// 음수 가중치에도 적용 가능
// 시간 복잡도 : O(v^3)

// 테이블의 "대각선 원소가 0이 아니면 음수 싸이클이 존재하는 것"

package Algorithms.ShortestDistance_최단경로.FloydWarshall_플로이드워셜;

public class Fw01 {

    static int[][] dist;
    static final int INF = 100000000; // 오버플로우가 일어날 수 있음으로 충분이 큰 값으로 설정
    public static void floydWarshall(int v, int e, int[][] data, int start){

        dist = new int[v + 1][v + 1];
        for (int i = 1; i <= v ; i++) {
            for (int j = 1; j <= v ; j++) {
                if (i != j) {
                    dist[i][j] = INF; // 대각을 제외한 모든 성분을 INF 설
                }
            }
        }

        for (int i = 0; i < e ; i++){
            dist[data[i][0]][data[i][1]] = data[i][2];
        } // 초기화 1단계

        for (int k = 1; k <= v ; k++) {
            // i -> j (k 를 거쳐서 가는 경우가 있을 때 업데이트)
            for (int i = 1; i <= v ; i++) {
                for (int j = 1; j <= v ; j++) {
                    if(dist[i][k] != INF && dist[k][j] != INF){
                        dist[i][j] = Math.min(dist[i][j],dist[i][k] + dist[k][j]);
                    }
                }
            }
        }
        for (int i = 1; i <= v ; i++) {
            for (int j = 1; j <= v ; j++) {
                if(dist[i][j] >= INF){
                    System.out.printf("%5s ","INF");
                }else{
                    System.out.printf("%5s ",dist[i][j]);
                }
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {

    int[][] data = {{1, 2, 8}, {1, 3, 6}, {1, 5, 5}, {2, 3, -5}, {2, 4, 1}, {2, 6, 4}, {3, 4, 4}, {4, 7, 3}, {5, 6, 5}, {6, 2, 0}, {6, 7, -7}};
    floydWarshall(7,11,data,1);
    }
}
