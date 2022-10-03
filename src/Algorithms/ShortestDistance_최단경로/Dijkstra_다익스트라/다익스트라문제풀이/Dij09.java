// 날짜 : 2022/10/03
// 문제 : 천 개의 정거장

// 문제 설명 :
// 1,000개의 지점에 각각 1부터 1,000까지의 숫자가 매겨져있습니다. N개의 버스가 이 지점들 사이를 정해진 노선대로 돌아다니며, 각 버스는 다음과 같은 특징이 있습니다.
// 각 노선은 최소 2개 이상의 지점을 포함하고 있으며, 한 노선 내에 같은 지점이 두 번 이상 나올수는 없습니다.
// 버스는 노선을 순서대로 운행하며, 마지막 지점에 도착하면 다시 처음부터 순서대로 운행을 시작합니다.
// 각 버스에는 탑승료가 있으며, 특정 버스에서 내렸다가 다른 버스로 갈아 탈 때에는 탑승료를 다시 지불해야합니다.
// 각 버스의 일부 노선만 이용하는것도 가능하며, 이 경우에도 탑승료는 동일하게 지불해야합니다.
// 버스가 마지막 지점에 도착하면 반드시 내려야하며, 버스로 연속된 두 지점 사이를 이동하는데에는 1초가 걸립니다.
// 주어진 버스들을 활용해 A번 지점부터 B번 지점까지 이동할 때 필요한 최소 비용과 이러한 최소 비용을 만족시키기 위해 걸리는 시간 중 최솟값을 구하는 프로그램을 작성해보세요.

// 입력 형식 :
// 첫 번째 줄에 지점 A의 번호, 지점 B의 번호, 버스의 수 N이 공백을 사이에 두고 차례대로 주어집니다.
// 두 번째 줄부터 2N개의 줄에 걸쳐 각 버스에 대한 정보가 다음과 같은 형식으로 두 줄씩 주어집니다.
// 각 버스에 대한 정보의 '첫 번째 줄'에는 버스 탑승료와 통과하는 지점의 개수가 공백을 사이에 두고 차례대로 주어집니다.
// 각 버스에 대한 정보의 '두 번째 줄'에는 버스 노선이 통과하는 점이 공백을 사이에 두고 차례대로 주어집니다.
// 1 ≤ N ≤ 1,000
// 1 ≤ 탑승료 ≤ 1,000,000,000
// 1 ≤ 노선을 이루는 점의 개수 ≤ 100
// 1 ≤ 점의 번호 ≤ 1,000

// 아이디어 :
// 주어지는 n개의 버스에 대한 정보를 입력 후,
// 하나씩 다익스트라 알고리즘을 통해 해볼까?...

package Algorithms.ShortestDistance_최단경로.Dijkstra_다익스트라.다익스트라문제풀이;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Dij09 {
    public static final int MAX_N = 1000;

    public static int A,B,n; // 시작지점, 도착 지점, 버스의 수 입력
    public static int[][] graph = new int[MAX_N + 1][MAX_N + 1]; // 인접행렬로 구현
    public static boolean[] visited = new boolean[MAX_N + 1];
    public static int[] dist = new int[MAX_N + 1];
    public static ArrayList<Bus> bus = new ArrayList<>(); // bus에 대한 정보를 인스턴스화 해서 배열리스트에 저장

    public static int minCost = (int)1e9, minTime = (int)1e9;

    static class Bus{
        int fare;
        int n;
        int[] stop = new int[n];

        Bus(int fare, int n, int[] stop){
            this.fare = fare;
            this.n = n;
            this.stop = stop;
        }
    }

    public static void dijkstra(){

        for (int i = 1; i <= n ; i++) {

            int minIndex = -1;
            for (int j = 1; j <= n ; j++) {
                if(visited[j])
                    continue;

                if(minIndex == -1 || dist[minIndex] > dist[j])
                    minIndex = j;


                visited[minIndex] = true;
            }

            for (int j = 1; j <= n ; j++) {
                if(graph[minIndex][j] == 0)
                    continue;

                dist[j] = Math.min(dist[j], dist[minIndex] + graph[minIndex][j]);
            }
        }
    }

    public static void initialize(){
        // 각종 필요한 리소스를 초기화하는 메소드

        Arrays.fill(visited, false);
        // visited 배열 초기화
        Arrays.fill(dist,(int)1e9);
        // dist 배열 초기화
        for(int[] sub : graph){
            Arrays.fill(sub,0);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        A = sc.nextInt();
        B = sc.nextInt();
        n = sc.nextInt();

        for (int i = 0; i < n ; i++) {
            int fare = sc.nextInt();
            int n = sc.nextInt();
            int[] stop = new int[n];

            for (int j = 0; j < n ; j++) {
                stop[i] = sc.nextInt();
            }
            bus.add(new Bus(fare,n,stop));
        }

        for (int i = 0; i < n ; i++) {
            initialize(); // 초기화 하고

            int fare = bus.get(i).fare;
            int n = bus.get(i).n;
            int[] stop = new int[n];
            stop = bus.get(i).stop;
            // 미리 저장해 놓은 배열리스트부터 정보 가져오고

            for (int j = 0; j < n - 1 ; j++) {
                graph[j][j + 1] = 1; // 인접행렬 만들고
                dist[stop[0]] = 0; // 시작 지점 0으로 설정
                dijkstra(); // 다익스트라 메소드 실행

                if(dist[A] != (int)1e9 && dist[B] != (int)1e9){
                    if(dist[B] - dist[A] < minCost){
                        minCost = dist[B] - dist[A];
//                        minTime =
                    }
                }
            }
        }
    }
}
