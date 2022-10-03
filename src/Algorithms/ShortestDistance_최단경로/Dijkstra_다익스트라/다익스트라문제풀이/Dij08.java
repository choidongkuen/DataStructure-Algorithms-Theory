// 날짜 : 2022/10/03
// 문제 : 최단거리 3

// 문제 설명 :
// 1부터 n까지 총 n개의 정점과 m개의 간선에 대한 정보로, 각 간선의 길이가 주어질 때,
// 정점 A에서 정점 B까지의 최단 거리를 구하는 프로그램을 작성해보세요. 이때, 주어진 정점과 간선으로 만들어지는 그래프는 양방향 그래프입니다.

// 입력 형식 :
// 첫 번째 줄에 정점의 개수 n, 간선의 개수 m 이 공백을 두고 주어집니다.
// 두 번째 줄부터 m개의 줄에 걸쳐 각 간선을 연결하는 두 정점의 번호와 각 간선의 길이가 공백을 두고 주어집니다.
// m+2 번째 줄에는 구하려는 도시 A와 B의 정점 번호가 공백을 사이에 두고 주어집니다.
// 1 ≤ n ≤ 1,000
// 1 ≤ m ≤ 100,000
// 1 ≤ 각 간선의 길이 ≤ 100,000

// 입력 예시01 :
// 5 8
// 1 2 2
// 1 3 3
// 1 4 1
// 1 5 10
// 2 4 2
// 3 4 1
// 3 5 1
// 4 5 3
// 1 5

// 출력 얘시01 :
// 3

package Algorithms.ShortestDistance_최단경로.Dijkstra_다익스트라.다익스트라문제풀이;

import java.util.Scanner;

public class Dij08 {

    public static final int MAX_N = 1000; // 정점의 최대 갯수
    public static final int MAX_M = 100000; // 간선정보의 최대 갯수

    public static boolean[] visited = new boolean[MAX_N + 1]; // 방문 기록을 위한 1차원 배열
    public static int[][] graph = new int[MAX_N + 1][MAX_N + 1]; // 인접 행렬
    public static int[] dist = new int[MAX_N + 1]; // 각 정점까지의 거리를 원소로 하는 dist 배열

    public static int n,m;
    public static int start,end; // 시작점,끝점

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        for (int i = 1; i <= m; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            int z = sc.nextInt();

            graph[x][y] = z;
            graph[y][x] = z;
        }

        start = sc.nextInt();
        end = sc.nextInt();

        for (int i = 1; i <= n ; i++) {
            dist[i] = (int)1e9;
        } // dist 배열 초기화

        dist[start] = 0; // 시작 정점 0으로 설정

        for (int i = 1; i <= n ; i++) {

            int minIndex = -1;
            for (int j = 1; j <= n ; j++) {
                if(visited[j])
                    continue;

                if(minIndex == -1 || dist[j] < dist[minIndex]){
                    minIndex = j;
                }
            }
            visited[minIndex] = true; // dist 값이 최소인 정점 방문 기록

            for (int j = 1; j <= n ; j++) {
                if(graph[minIndex][j] == 0)
                    continue;

                dist[j] = Math.min(dist[j], dist[minIndex] + graph[minIndex][j]);
            }
        }
        System.out.print(dist[end]);
    }
}
