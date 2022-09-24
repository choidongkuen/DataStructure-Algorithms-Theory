// 인접행렬로 BFS 구현해보기

package DataStructure.Graph_그래프;

import java.util.LinkedList;
import java.util.Queue;
public class Graph03_BFS_Imp {
    public static final int VERTEX_NUM = 7;
    public static final int EDGES_NUM = 6;

    public static int[][] graph = new int[VERTEX_NUM + 1][VERTEX_NUM + 1]; // 인접행렬
    public static boolean[] visited = new boolean[VERTEX_NUM + 1]; // 방문 기록 저장하는 1차원 배열
    public static Queue<Integer> queue = new LinkedList<>(); // 큐 선언

    public static void BFS(){
        while(!queue.isEmpty()){
            int currV = queue.poll();

            for(int nextV = 1; nextV <= VERTEX_NUM; nextV ++){
                if(graph[currV][nextV] == 1 && !visited[nextV]){
                    visited[nextV] = true; // 방문 기록
                    System.out.print(nextV + " ");
                    queue.add(nextV);
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] startPoints = {1,1,1,2,4,6};
        int[] endPoints = {2,3,4,5,6,7};

        for(int i = 0; i < EDGES_NUM; i++){
            int start = startPoints[i];
            int end = endPoints[i];

            graph[start][end] = 1;
            graph[end][start] = 1; // 양뱡향 그래프
        } // 인접행렬 완성

        int rootVertex = 1;
        visited[rootVertex] = true;
        queue.add(rootVertex);

        System.out.print("BFS(인접행렬) : ");
        System.out.print(rootVertex + " ");
        BFS(); // BFS 메소드 호출
    }
}

/*
public class Graph03_BFS_Imp{
    public static final int VERTEX_NUM = 7;
    public static final int EDGE_NUM = 6;
    public static int[][] graph = new int[VERTEX_NUM + 1][VERTEX_NUM + 1]; // 인접행렬
    public static boolean[] visited = new boolean[VERTEX_NUM + 1];
    public static Queue<Integer> q = new LinkedList<>();

    public static void BFS(){
        while(!q.isEmpty()){
            int currV = q.poll();

            for(int nextV = 1; nextV <= VERTEX_NUM; nextV++){
                if(graph[currV][nextV] == 1 && !visited[nextV]){
                    visited[nextV] = true;
                    q.add(nextV);
                }
            }
        }
    }
    public static void main(String[] args) {


        int[] startPoints = {1,1,1,2,4,6};
        int[] endPoints = {2,3,4,5,6,7};

        for(int i = 0; i < EDGE_NUM; i++){

            int start = startPoints[i];
            int end = endPoints[i];

            graph[start][end] = 1;
            graph[end][start] = 1;
        }

        int rootVertex = 1;
        visited[rootVertex] = true;
        q.add(rootVertex);
        BFS();
    }
}
*/