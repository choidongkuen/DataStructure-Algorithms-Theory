// 인접리스트로 BFS 구현해보기

package Graph_그래프;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Graph04_BFS_Imp {
    public static final int VERTEX_NUM = 7;
    public static final int EDGES_NUM = 6;

    public static ArrayList<Integer>[] adList = new ArrayList[VERTEX_NUM + 1]; // 인접 리스트 선언
    public static Queue<Integer> queue = new LinkedList<>(); // 큐 선언
    public static boolean[] visited = new boolean[VERTEX_NUM + 1]; // 방문 기록 저장하는 1차원 배열

    public static void BFS(){
        while(!queue.isEmpty()){
            int currV = queue.poll();
            for(int i = 0; i < adList[currV].size(); i ++){
                int nextV = adList[currV].get(i);

                if(!visited[nextV]){
                    System.out.print(nextV + " ");
                    visited[nextV] = true;
                    queue.add(nextV); // 큐에 추기
                }
            }
        }
    }
    public static void main(String[] args) {
        for(int i = 1; i <= VERTEX_NUM; i++){
            adList[i] = new ArrayList<>();
        } // 인접 리스트 초기화

        int[] startPoints = {1,1,1,2,4,6};
        int[] endPoints = {2,3,4,5,6,7};

        for(int i = 0; i < EDGES_NUM; i++){
            int start = startPoints[i];
            int end = endPoints[i];

            adList[start].add(end);
            adList[end].add(start);
        } // 인접 리스트 완성

        int rootVertex = 1;
        visited[rootVertex] = true; // 방문 기록
        System.out.print("BFS(인접리스트) : ");
        System.out.println(rootVertex + " ");
        queue.add(rootVertex);
        BFS(); // BFS 메소드 호출
    }
}
/* - 연습 -

public class Graph04_BFS_Imp{
    public static final int VERTEX = 7;
    public static final int EDGE = 6;

    public static ArrayList<Integer>[] adList = new ArrayList[VERTEX + 1]; // 인접리스트
    public static boolean[] visited = new boolean[VERTEX + 1];
    public static Queue<Integer> q = new LinkedList<>();

    public static void BFS(){
        while(!q.isEmpty()){
            int currV = q.poll();
            for(int i = 0; i < adList[currV].size(); i++){
                int nextV = adList[currV].get(i);

                if(!visited[nextV]) {
                    visited[nextV] = true;
                    q.add(nextV);
                }
            }
        }
    }

    public static void main(String[] args) {

        for(int i = 1; i <= VERTEX; i++)
            adList[i] = new ArrayList<>();

        int[] startPoints = {1,1,1,2,4,6};
        int[] endPoints = {2,3,4,5,6,7};

        for(int i = 0 ; i < EDGE; i++){
            int start = startPoints[i];
            int end = endPoints[i];

            adList[start].add(end);
            adList[end].add(start);
        }
        int rootVertex = 1;
        visited[rootVertex] = true;
        q.add(rootVertex);
        BFS();
    }
}
*/