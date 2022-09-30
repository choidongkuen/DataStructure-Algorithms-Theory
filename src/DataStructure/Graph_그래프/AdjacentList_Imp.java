// 인접 리스트를 이용한 그래프 구현

package DataStructure.Graph_그래프;

class Node{

    int id;
    Node next;
    public Node(int id, Node next){
        this.id = id;
        this.next = next;
    }

}
class MyAdjacentList{

    char[] vertex;
    Node[] MyadjList;
    int elementCnt;

    public MyAdjacentList(){}

    public MyAdjacentList(int size){
        this.vertex = new char[size];
        this.MyadjList = new Node[size];
        this.elementCnt = 0;
    }

    public boolean isFull(){
        return this.elementCnt == this.vertex.length;
    }
    public void addVertex(char data){
        if(this.isFull()){
            System.out.println("AdjacentList is Full!");
            return;
        }
        this.vertex[this.elementCnt ++] = data;
    }

    public void addEdge(int x, int y){
        this.MyadjList[x] = new Node(y,this.MyadjList[x]);
        this.MyadjList[y] = new Node(x,this.MyadjList[y]);
    }

    public void addDirectedEdge(int x, int y){
        this.MyadjList[x] = new Node(y,this.MyadjList[x]);
    }

    public void printAdjacentList(){
        for (int i = 0; i < this.elementCnt ; i++) {
            System.out.print(this.vertex[i] +": ");

            Node cur = this.MyadjList[i];
            while(cur != null){
                System.out.print(this.vertex[cur.id] +" ");
                cur = cur.next;
            }
            System.out.println();
        }
    }
}
public class AdjacentList_Imp {

    public static void main(String[] args) {

        MyAdjacentList graph = new MyAdjacentList(4);

        graph.addVertex('A');
        graph.addVertex('B');
        graph.addVertex('C');
        graph.addVertex('D');

        graph.addEdge(0,1);
        graph.addEdge(0,2);
        graph.addEdge(1,2);
        graph.addEdge(1,3);
        graph.addEdge(2,3);
        graph.printAdjacentList();

    }
}
