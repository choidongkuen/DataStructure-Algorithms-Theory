// 인접리스트로 DFS 구현해보기

package DataStructure.Graph_그래프;

import java.util.ArrayList;

// 정점(vertex)의 갯수 : 7 , 간선(edges)의 갯수 : 6
public class Graph02_DFS_Imp {
    public static final int VERTEX_NUM = 7; // 정점의 갯수
    public static final int EDGES_NUM = 6; // 간선 갯수

    public static ArrayList<Integer>[] adList = new ArrayList[VERTEX_NUM + 1]; // ArrayList 를 원소로 갖는 1차원 배열
    public static boolean[] visited = new boolean[VERTEX_NUM + 1]; // 방문 기록 저장하는 1차원 배열

    public static void DFS(int vertex){
        for(int i = 0; i < adList[vertex].size(); i++){
            int currv = adList[vertex].get(i);

            if(!visited[currv]){
                visited[currv] = true; // 방문 기록
                System.out.print(currv + " ");
                DFS(currv);
            }
        }
    }

    public static void main(String[] args){

        for (int i = 0; i <= VERTEX_NUM ; i++) {
            adList[i] = new ArrayList<>();
        } // 인접리스트 완성

        int[] startPoints = {1,1,1,2,4,6};
        int[] endPoints = {2,3,4,5,6,7};

        for(int i = 0; i < EDGES_NUM; i++){
            int start = startPoints[i];
            int end = endPoints[i];

            adList[start].add(end);
            adList[end].add(start);
        }

        int rootVertex = 1;
        visited[rootVertex] = true;
        System.out.print("DFS(인접리스트) : ");
        System.out.print(rootVertex + " ");
        DFS(rootVertex);
    }
}

/* - 연습 -
public class Graph02_DFS_Imp{

    public static final int VERTEX_NUM = 7;
    public static final int EDGE_NUM = 6;
    public static ArrayList<Integer>[] adList = new ArrayList[VERTEX_NUM + 1]; // ArrayList 를 원소로 가지는 배열
    public static boolean[] visited = new boolean[VERTEX_NUM + 1];

    public static void DFS(int vertex){
        for(int i = 0 ; i < adList[vertex].size(); i++){

            int nextV = adList[vertex].get(i);
            if(!visited[nextV]){
                visited[nextV] = true;
                DFS(nextV);
            }
        }
    }

    public static void main(String[] args) {

        for(int i = 1; i <= VERTEX_NUM ; i++)
            adList[i] = new ArrayList<>(); // 배열의 각 원소 초기화

        int[] startPoint = {1,1,1,2,4,6};
        int[] endPoints = {2,3,4,5,6,7};

        for(int i = 0; i < EDGE_NUM; i++){
            int start = startPoint[i];
            int end = endPoints[i];

            adList[start].add(end);
            adList[end].add(start);
        }

        int rootVertex = 1;
        visited[rootVertex] = true; // 방문
        DFS(rootVertex);
    }
}
 */
