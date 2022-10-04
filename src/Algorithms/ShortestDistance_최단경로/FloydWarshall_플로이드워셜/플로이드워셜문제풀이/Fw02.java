// 날짜 : 2022/10/04
// 문제 : 각 정점까지의 최단 경로
// 문제 설명 :
// n개의 정점이 존재하고 m개의 간선의 양 끝 정점과 가중치가 주어질 때,
// "모든 정점 쌍 (i, j) 에 대해 정점 i 에서 출발하여 정점 j에 도착하기 위한 최단 거리"를 구하는 프로그램을 작성해보세요.
// 단, 주어진 정점과 간선으로 이루어지는 그래프는 방향 그래프 입니다.

package Algorithms.ShortestDistance_최단경로.FloydWarshall_플로이드워셜.플로이드워셜문제풀이;

import java.util.Scanner;

public class Fw02 {
    public static final int MAX_N = 100;
    public static final int MAX_M = 100000;
    public static int[][] dist = new int[MAX_N + 1][MAX_N + 1];

    public static int n,m;

    /*
    static class Edge{
        int from,to,weight;

        Edge(int from, int to, int weight){
            this.from = from;
            this.to = to;
            this.weight = weight;
        }
    }*/
    public static void initialize(){

        for (int i = 1; i <= n ; i++) {
            for (int j = 1; j <= n; j++) {
                if (i != j)
                    dist[i][j] = (int) 1e9;
            }
        }
    }
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        initialize();

        for (int i = 0; i < m ; i++) {
            int from = sc.nextInt();
            int to = sc.nextInt();
            int weight = sc.nextInt();

            dist[from][to] = Math.min(dist[from][to],weight);
            // 두 정점을 연결하는 간선이 여러개 일 수 있음으로, 주어지는 정보 중 최소값으로 설정
        } // m개의 간선 정보 입력

        for(int k = 1; k <= n; k++){
            for(int i = 1; i <= n; i++){
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
