// 날짜 : 2022/10/04
// 문제 : 각 지점에서 갈 수 있는 곳들

// 문제 설명 :
// 그래프가 주어졌을 때, 모든 쌍에 대해 정점 A -> 정점 B로 갈 수 있는 경로가 존재하면 1, 존재하지 않는다면 0으로 나타내기
// 플로이드 워셜 알고리즘을 이용하면 쉽게 해결가능

// 아이디어 :
// A -> 정점 B로 갈 수 있는 경로가 존재한다는 것은 중간에 k 지점을 거쳐서 갈 수 있는 부분이 있어야 함

package Algorithms.ShortestDistance_최단경로.FloydWarshall_플로이드워셜.플로이드워셜문제풀이;

import java.util.Scanner;

public class Fw03 {
    public static int v = 5;
    public static int e = 8;
    public static int[][] dist = new int[v + 1][v + 1];

    public static void initialize(){

        for (int i = 1; i <= v ; i++) {
            for (int j = 1; j <= v ; j++) {
                if(i == j)
                    dist[i][j] = 1; // i,j 가 동일하다는 것은 같은 위치임으로 갈 수 있다고 표기
            }
        }
    }
    // dist 배열을 초기화하는 메소드
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        initialize();

        for (int i = 0; i < e ; i++) {

            int from = sc.nextInt();
            int to = sc.nextInt();
            dist[from][to] = 1; // from - to 까지 갈 수 있다는 뜻
        }

        for(int k = 1; k <= v; k ++) {
            for (int i = 1; i <= v; i++) {
                for (int j = 1; j <= v; j++) {

                    if(dist[i][k] == 1 && dist[k][j] == 1)
                        //  i - > k - > j 경로로 갈 수 있음
                        dist[i][j] = 1;
                }
            }
        }

        for (int i = 1; i <= v ; i++) {
            for (int j = 1; j <= v ; j++) {
                System.out.print(dist[i][j] + " ");
            }
            System.out.println();
        }
    }
}
