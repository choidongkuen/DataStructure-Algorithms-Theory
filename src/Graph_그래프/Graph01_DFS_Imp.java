// 인접행렬을 이용하여 DFS 구현해보기

package Graph_그래프;

// 정점(vertex)의 갯수 : 7 , 간선(edges)의 갯수 : 6
public class Graph01_DFS_Imp {
    public static final int VERTEX_NUM = 7; // 정점의 갯수
    public static final int EDGES_NUM = 6; // 간선의 갯수

    public static int[][] graph = new int[VERTEX_NUM + 1][VERTEX_NUM + 1]; // 인접행렬
    public static boolean[] visited = new boolean[VERTEX_NUM + 1]; // 방문 기록 저장하는 1차원 배열

    public static void DFS(int vertex){
        for(int currv = 1; currv <= VERTEX_NUM; currv++)
            if(graph[vertex][currv] == 1 && !visited[currv]){
                visited[currv] = true; // 방문 기록
                System.out.print(currv + " ");
                DFS(currv); // 재귀적 호출
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
        System.out.print("DFS(인접행렬) : ");
        System.out.print(rootVertex + " ");
        DFS(rootVertex); // DFS 메소드 호출
    }
}
