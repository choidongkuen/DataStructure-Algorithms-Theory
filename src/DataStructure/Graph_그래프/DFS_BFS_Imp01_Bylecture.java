// 인접 행렬 그래프의 DFS,BFS
// 강의 기반
package DataStructure.Graph_그래프;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

class MyGrpahMatrix extends MyAdjacentMatrix{

    public MyGrpahMatrix(int size){
        super(size); // 부모 클래스의 생성자 호출
    }

    public void dfs(int id){
        boolean[] visited = new boolean[this.elementCnt];
        Stack<Integer> stack = new Stack<>();

        visited[id] = true;
        stack.push(id);

        while(!stack.isEmpty()){
            int currId = stack.pop(); // 하나 빼고
            System.out.print(this.vertex[currId]+" ");

            for (int i = this.elementCnt - 1 ; i >= 0; i --) { // 역
                if(this.adjMat[currId][i] == 1 && !visited[i]){
                    stack.push(i);
                    visited[i] = true;
                }
            }
        }
    }

    public void bfs(int id){
        boolean[] visited = new boolean[this.elementCnt];
        Queue<Integer> queue = new LinkedList<>();

        queue.add(id);
        visited[id] = true;

        while(!queue.isEmpty()) {
            int currId = queue.poll(); // 하나 빼고
            System.out.print(this.vertex[currId] + " ");

            for (int i = this.elementCnt - 1; i >= 0 ; i--) {
                if(this.adjMat[currId][i] == 1 && !visited[i]){
                    queue.add(i);
                    visited[i] = true;
                }
            }
        }
        System.out.println();
    }
}


public class DFS_BFS_Imp01_Bylecture {
    public static void main(String[] args) {
        MyGrpahMatrix graph = new MyGrpahMatrix(7);
        graph.addVertex('A');
        graph.addVertex('B');
        graph.addVertex('C');
        graph.addVertex('D');
        graph.addVertex('E');
        graph.addVertex('F');
        graph.addVertex('G');

        graph.addEdge(0,1);
        graph.addEdge(0,2);
        graph.addEdge(0,3);
        graph.addEdge(1,4);
        graph.addEdge(2,5);
        graph.addEdge(3,4);
        graph.addEdge(3,5);
        graph.addEdge(4,6);
        graph.addEdge(5,6);

        graph.printAdjacentMatrix(); // 인접행렬을 출력

        System.out.println();
//        graph.dfs(0);
        graph.bfs(0);

    }
}
