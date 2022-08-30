// 양방향 연결 리스트(Doubly Linked List) 구현


package Array_List_배열_리스트.Array_배열.List;

import java.util.LinkedList;

class Node1{
    int data; // 데이터
    Node1 prev; // 이전 노드
    Node1 next; // 다음 노드

    Node1(int data,Node1 prev, Node1 next){
        this.data = data;
        this.prev = prev;
        this.next = next;
    }
}
class DoublyLinkedList extends LinkedList{
    Node1 head;
    Node1 tail;
    DoublyLinkedList(Node1 node){
        this.head = node;
        this.tail = node;
    }

    public boolean isEmpty(){
        if(this.head == null){
            return true;
        }
        return false;
    } // 비어있는지 판단하는 메서드

    public void insertData(int data,Integer beforeData){ // beforeData 전 노드 삭제
        if(this.head == null){
            this.head = new Node1(data,null,null);
            this.tail = this.head;
        }else if(beforeData == null){
            this.tail.next = new Node1(data,this.tail,null);
            this.tail = this.tail.next; // tail 갱신
        }else{
            Node1 cur = this.head;
            Node1 pre = cur;

            while(cur != null){
                if(cur.data == beforeData){
                    if(cur == this.head){
                        this.head = new Node1(data,null,this.head);
                        this.head.next.prev = this.head;
                    }
                    else{
                         pre.next = new Node1(data,pre,cur);
                         cur.prev = pre.next;
                    }
                    break;
                }
                pre = cur;
                cur = cur.next;
            }
        }
    }
    public void deleteData(int data){ // data 를 지닌 노드 삭제
        if(this.head == null){ // 연결리스트가 비어있는 경우
            System.out.println("List is Empty");
            return;
        }
        Node1 cur = this.head;
        Node1 pre = cur;

        while(cur != null){
            if(cur.data == data){
                if(cur == this.head && cur == this.tail){ // 해당 노드가 head 이면서 tail 노드인 경우 -> 원래 노드가 하나인 경우

                }
                else if(cur == this.head){ // 해당 노드가 head 인 경우
                    this.head.next = this.head;
                    this.head.prev = null;
                }
                else if(cur == this.tail){ // 해당 노드가 tail 인 경우
                    this.tail = this.tail.prev;
                    this.tail.next = null;
                }
                else{ // 그 외 경우
                    pre.next = cur.next;
                    cur.next.prev = pre;
                }
                break;
            }
            pre = cur;
            cur = cur.next;
        }
    }
    public void showData(){ // head - tail 출력
        if(this.isEmpty()){
            System.out.println("List is empty");
            return;
        }
        Node1 cur = this.head;
        while(cur != null){
            System.out.print(cur.data+" ");
            cur = cur.next;
        }
        System.out.println();
    }
    public void reverseShowData(){ // tail - head 출력
        if(this.isEmpty()){
            System.out.println("List is empty");
            return;
        }
        Node1 cur = this.tail;
        while(cur != null){
            System.out.print(cur.data+" ");
            cur = cur.prev;
        }
    }
}

public class ListPractice03 {
    public static void main(String[] args){
        DoublyLinkedList myList3 = new DoublyLinkedList(new Node1(1,null,null));

        myList3.showData();

        myList3.insertData(2,null);
        myList3.insertData(3,null);
        myList3.insertData(4,null); // tail 뒤에 삽입 하는 명령

        myList3.showData();


        myList3.insertData(100,2);
        myList3.insertData(200,3);
        myList3.insertData(300,4);

        myList3.showData();
        /*
        myList3.reverseShowData();

        myList3.deleteData(100);
        myList3.deleteData(200);

        myList3.showData();
        myList3.reverseShowData();
*/

    }
}
