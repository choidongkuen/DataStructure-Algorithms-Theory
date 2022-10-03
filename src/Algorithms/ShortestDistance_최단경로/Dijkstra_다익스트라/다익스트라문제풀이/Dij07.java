// 날짜 : 2022/10/03
// 문제 : 최단거리11

// 문제 설명 :
// n개의 정점과 m개의 간선에 대한 정보로 각 간선의 길이가 주어질 때,
// 정점 A에서 정점 B까지의 최단 거리와 그 때의 경로를 구하는 프로그램을 작성해보세요.
// 이때 주어지는 정점과 간선들로 구성되는 그래프는 양방향 그래프라고 가정합니다.

// 입력 형식 :
// 첫 번째 줄에 정점의 개수 n, 간선의 개수 m 이 공백을 두고 주어집니다.
// 두 번째 줄부터 m개의 줄에 걸쳐 각 간선 양쪽 끝 정점의 번호와 해당 간선의 길이가 공백을 사이에 두고 주어집니다. 단, 동일한 간선이 여러 번 주어지는 경우는 없다고 가정해도 좋습니다.
// m+2 번째 줄에는 구하려는 도시 A와 B의 정점 번호가 공백을 사이에 두고 주어집니다.
// 1 ≤ n ≤ 1,000
// 1 ≤ m ≤ 100,000
// 1 ≤ 각 간선의 길이 ≤ 100,000


// 입력 예시01 :
// 5 8
// 1 2 2
// 1 3 3
// 1 4 1
// 1 5 3
// 2 4 2
// 3 4 1
// 3 5 1
// 4 5 3
// 1 5

// 출력 예시01 :
// 3
// 1 4 3 5

package Algorithms.ShortestDistance_최단경로.Dijkstra_다익스트라.다익스트라문제풀이;

import java.util.Scanner;

public class Dij07 {

    public static final int MAX_N = 1000;
    public static final int MAX_M = 100000;

    public static int n,m;
    public static int start,end;
    public static int[][] graph = new int[MAX_N + 1][MAX_N + 1]; // 인접 행렬
    public static int[] dist = new int[MAX_N + 1];
    public static boolean[] visited = new boolean[MAX_N + 1];


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        while(m -- > 0){
            int x = sc.nextInt();
            int y = sc.nextInt();
            int z = sc.nextInt();

            graph[y][x] = z;
            graph[x][y] = z;
        }

        start = sc.nextInt();
        end = sc.nextInt();

        for (int i = 1; i <= n ; i++) {
            dist[i] = (int)1e9;
        }

        dist[end] = 0;

        for (int i = 1; i <= n ; i++) {
            int minIndex = -1;

            for (int j = 1; j <= n ; j++) {
                if(visited[j])
                    continue;

                if(minIndex == -1 || dist[minIndex] > dist[j]){
                    minIndex = j;
                } // dist 배열에서의 최소값을 갖는 정점의 번호를 get
            }

            visited[minIndex] = true;

            for (int j = 1; j <= n ; j++) {
                if(graph[minIndex][j] == 0)
                    continue;

                dist[j] = Math.min(dist[j] , dist[minIndex] + graph[minIndex][j]);
            }
        }

        System.out.println(dist[start]);

        int x = start;
        System.out.print(x + " ");

        while(x != end){
            for (int i = 1; i <= n ; i++) {
                if(graph[i][x] == 0)
                    continue;

                if(dist[i] + graph[i][x] == dist[x]){
                    x = i;
                    break;
                }
            }
            System.out.print(x + " ");
        }
    }
}
