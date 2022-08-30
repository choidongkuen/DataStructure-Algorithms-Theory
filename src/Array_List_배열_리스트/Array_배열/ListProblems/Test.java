package Array_List_배열_리스트.Array_배열.ListProblems;

class Node1{
    int data;
    Node1(int data){
        this.data = data;
    }

}

public class Test {
    public static void main(String[] args){
        Node1 a = new Node1(1);
        Node1 b = a;


        for (int i = 0; i < 4 ; i++) {
            a.data ++;
            System.out.println(b.data);
        }
    }
}
