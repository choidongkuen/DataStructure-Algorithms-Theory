// 인접 행렬을 이용한 그래프 구현
// 인접 행렬에 대한 속성 + 기능을 MyAdjacentMatrix 클래스로 구현
package DataStructure.Graph_그래프;

import java.util.Arrays;

class MyAdjacentMatrix{

    char[] vertex; // 문자 정보를 담을 1차원 배열
    int[][] adjMat; // 인접행렬
    int elementCnt; // 원소의 갯수

    public MyAdjacentMatrix(){}

    public MyAdjacentMatrix(int size){
        this.vertex = new char[size];
        this.adjMat = new int[size][size];
        this.elementCnt = 0;
    }


    public boolean isFull(){
        return this.elementCnt == this.vertex.length;
    }

    public void addVertex(char element){
        if(isFull()){
            System.out.println("Graph is full!");
            return;
        } // 이미 꽉 찬 경우

        this.vertex[this.elementCnt ++] = element;
    }

    public void addEdge(int x, int y){
        this.adjMat[x][y] = 1;
        this.adjMat[y][x] = 1;
    } // 무방향 그래프

    public void directedAddEdge(int x, int y){
        this.adjMat[x][y] = 1;
    } // 방향 그래프

    public void deleteEdge(int x, int y){
        this.adjMat[x][y] = 0;
        this.adjMat[y][x] = 0;
    } // 무방향 그래프

    public void directedDeleteEdge(int x, int y){
        this.adjMat[x][y] = 0;
    } // 방향 그래프

    public void printAdjacentMatrix(){
//        System.out.println(Arrays.deepToString(adjMat));

        System.out.print("  ");
        for (int i = 0; i < vertex.length; i++) {
            System.out.print(vertex[i] + " ");
        }
        System.out.println();

        for (int i = 0; i < this.elementCnt ; i++) {
            System.out.print(this.vertex[i] + " ");
            for (int j = 0; j < adjMat[i].length ; j++) {
                System.out.print(this.adjMat[i][j]+ " ");
            }
            System.out.println();
        }
    }
}

public class AdjacentMatrix_Imp {

    public static void main(String[] args) {
        MyAdjacentMatrix graph = new MyAdjacentMatrix(4);

        graph.addVertex('A');
        graph.addVertex('B');
        graph.addVertex('C');
        graph.addVertex('D');

        graph.addEdge(0,1);
        graph.addEdge(0,2);
        graph.addEdge(1,2);
        graph.addEdge(1,3);
        graph.addEdge(2,3);
        graph.printAdjacentMatrix();
    }
}
