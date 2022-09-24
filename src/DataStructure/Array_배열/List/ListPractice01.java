// 단순 연결 리스트(simple ver.) 기본 구조 구현 해보기


package DataStructure.Array_배열.List;

class Node{
    int data;
    Node next;
    //Node(){}; // default 생성자
    Node(int data, Node next){
        this.data = data;
        this.next = next;
    }
}
class LinkedList1{
    Node head; // head 노드
    LinkedList1(){}; // default 생성자
    LinkedList1(Node node){
        this.head = node;
    }
    public boolean isEmpty(){
        if(this.head == null){
            return true; // 비어있는 경우
        }
        return false; // 비어있지 않은 경우
    }

    public void insertNode(int data) { // tail 노드 뒤 삽입
        if (this.head == null) {
            this.head = new Node(data, null); // next == null
        } // 비어있었던 경우
        else {
            Node cur = this.head; // 시작 위치! cur = 현재 노드
            while (cur.next != null) {
                cur = cur.next;
            } // tail 일때 까지 순회
            Node newNode = new Node(data, null); // 새로운 노드 생성
            cur.next = newNode; // tail 뒤에 추가 완료
        }
    }
    public void deleteNode(){ // tail 노드 삭제
        if(this.isEmpty()){
            System.out.println("LinkedList is empty");
            return;
        }
        Node cur = this.head;
        Node prev = cur;

        while(cur.next!= null) {
            prev = cur;
            cur = cur.next;
        }
        if(cur == this.head){
            this.head = null;
        }
        else {
            prev.next = null;
        }
        /*
        while(cur.next.next != null){
            cur = cur.next;
        }
        cur.next = null;
        */ // 내가 생각한 방식 -> 불가 (원래 head 밖에 없는 경우)
    }
    public void findElement(int data){
        if(this.isEmpty()){
            System.out.println("LinkedList is empty");
            return;
        }
        Node cur = this.head; // 시작 위치! cur = 현재 노드
        while(cur != null){ // tail까지 모두 순회
            if(cur.data == data){
                System.out.println("Data exists!");
                return; // 존재하므로 return
            }
            cur = cur.next; // 다음 노드로 이동
        }
        System.out.println("Data doesn't exist"); // 존재하지 않는 경우
    }
    public void printAll(){
        if(this.isEmpty()){
            System.out.println("LinkedList is empty");
        }
        Node cur = this.head;
        while(cur != null){
            System.out.print(cur.data+" ");
            cur = cur.next;
        }
        System.out.println();
    }
}


public class ListPractice01 {
    public static void main(String[] args) {
        LinkedList1 myList = new LinkedList1(new Node(1,null));
        myList.printAll();

        myList.insertNode(2);
        myList.insertNode(20);
        myList.insertNode(200);
        myList.insertNode(10);
        myList.insertNode(2);

        myList.findElement(20);
        myList.findElement(-1);

        myList.deleteNode();
        myList.deleteNode();
        myList.deleteNode();

        myList.printAll();
    }
}
