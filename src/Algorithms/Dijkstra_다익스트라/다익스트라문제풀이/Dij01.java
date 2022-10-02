// 날짜 : 2022/10/02
// 문제 : 각 정점까지의 최단 경로

// 문제 설명 :
//n개의 정점이 존재하고 m개의 간선의 양 끝 정점과 가중치가 주어질 때, 1번 정점에서 다른 모든 정점으로 가는 최단 경로를 구하는 프로그램을 작성해보세요.
// 이때 주어지는 정점과 간선들로 구성되는 그래프는 단방향 그래프라고 가정합니다.

// 입력 형식 :
// 첫 번째 줄에 정점의 개수 n과 간선의 개수 m이 공백을 두고 주어집니다.
// 두 번째 줄부터 m개의 줄에 걸쳐, 각 간선의 시작 정점의 번호, 끝 정점의 번호, 그리고 해당 간선에 주어진 가중치가 공백을 두고 주어집니다. 단, 동일한 간선이 여러 번 주어지는 경우는 없다고 가정해도 좋습니다.
// 1 ≤ n ≤ 100
// 1 ≤ m ≤ 1,000
// 1 ≤ 간선의 가중치 ≤ 10

// 입력 예시01 :
// 5 6
// 2 1 1
// 1 5 2
// 4 2 9
// 4 3 5
// 5 4 3
// 3 2 3

// 출력 예시01 :
// 13
// 10
// 5
// 2
package Algorithms.Dijkstra_다익스트라.다익스트라문제풀이;

import java.util.Scanner;

public class Dij01 {

    public static final int MAX_N = 100; // 정점의 최대 갯수
    public static final int MAX_M = 1000; // 간선의 최대 갯수

    public static boolean[] visited = new boolean[MAX_N + 1]; // 각 정점에 대한 방문을 기록할 배열
    public static int[][] graph = new int[MAX_N + 1][MAX_N + 1]; // 인접 행렬
    public static int[] dist = new int[MAX_N + 1]; // 1번 정점에서의 각 정점까지의 거리를 원소로 하는 배열
//    public static Point[] points = new Point[MAX_M]; // 간선의 정보를 담을 1차원 배열

    public static int n,m;

    static class Point{ // 정점의 정보를 인스턴스화
        int x,y,z;
        Point(int x, int y, int z){
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }
    public static void dijkstra(){

        for (int i = 1; i <= n ; i++) {

            int minDist = -1; // dist 배열에서 최소값을 갖는 정점의 인덱스

            for (int j = 1; j <= n ; j++) {
                if(visited[j])
                    continue; // 방문한적이있는 정점

                if(minDist == -1 || dist[minDist] > dist[j])
                    minDist = j;
            }
            visited[minDist] = true; // 방문 기록
            // 방문한적이 없으면서 dist 배열에서의 최소값을 가지는 정점을 구함

            for (int j = 1; j <= n ; j++) {
                if(graph[minDist][j] == 0)
                    continue;

                dist[j] = Math.min(dist[j], dist[minDist] + graph[minDist][j]);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        for (int i = 1; i <= m ; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            int z = sc.nextInt();

//            points[i] = new Point(x,y,z);
            graph[x][y] = z; // 인접행렬 채우기
        } // m개의 간선정보 저장

        for(int i = 1; i <= n ; i ++){
            dist[i] = (int)1e9;
        }
        dist[1] = 0;

        dijkstra(); // 다익스트라 메소드 호출

        for (int i = 2; i <= n ; i++) {
            if(dist[i] == (int)1e9){
                System.out.println(-1);
            }else{
                System.out.println(dist[i]);
            }
        } // 1번 정점에서 각 정점까지의 거리 출력
    }
}
