// 인접 리스트 그래프의 DFS,BFS

package DataStructure.Graph_그래프;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

class MyGraphList extends MyAdjacentList{

    public MyGraphList(int size){
        super(size);
    }

    public void dfs(int id){
        boolean[] visited = new boolean[this.elementCnt];
        Stack<Integer> stack = new Stack<>();

        stack.push(id);
        visited[id] = true;

        while(!stack.isEmpty()){
            int currId = stack.pop();
            System.out.print(this.vertex[currId] + " ");

            Node cur = this.MyadjList[currId];
            while(cur != null){
                if(!visited[cur.id]){
                    stack.push(cur.id);
                    visited[cur.id] = true;
                }
                cur = cur.next;
            }
        }
        System.out.println();

    }
    public void bfs(int id){

        boolean[] visited = new boolean[this.elementCnt];
        Queue<Integer> queue = new LinkedList<>();

        visited[id] = true;
        queue.add(id);

        while(!queue.isEmpty()){
            int currId = queue.poll();
            System.out.print(this.vertex[currId] + " ");

            Node cur = this.MyadjList[currId];

            while(cur != null){
                if(!visited[cur.id]){
                    queue.add(cur.id);
                    visited[cur.id] = true;
                }
                cur = cur.next;
            }
        }
        System.out.println();
    }
}

public class DFS_BFS_Imp02_Bylecture {
    public static void main(String[] args) {


        MyGraphList graph = new MyGraphList(7);
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

        graph.printAdjacentList(); // 인접행렬을 출력

        System.out.println();
//        graph.dfs(0);
        graph.bfs(0);

    }
}