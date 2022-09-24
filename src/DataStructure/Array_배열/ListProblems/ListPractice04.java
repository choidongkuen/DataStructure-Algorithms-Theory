// 연결리스트 연습 문제 01
// 단방향 연결리스트에서 중복 데이터를 찾아 삭제하세요.

// 입출력 예시 )
// 입력 연결 리스트 : 1 3 3 1 4 2 4 2
// 출력 연결 리스트 : 1 3 4 2
package DataStructure.Array_배열.ListProblems;

import java.util.Scanner;


class Node{
    int data;
    Node next;
    Node(int data, Node next){
        this.data = data;
        this.next = next;
    }
}
class LinkedList{
    Node head;

    LinkedList(){} // 빈 단방향 연결리스트

    LinkedList(Node node){
        this.head = node;
    }
    public boolean isEmpty(){
        if(this.head == null){
            return true;
        }
        return false;
    }
    public void insertData(int data){
        if(this.isEmpty()){
            this.head = new Node(data,null);
        }else{
            Node cur = this.head;
            while(cur.next!= null){
                cur = cur.next;
            }
            cur.next = new Node(data, null);
        }
    }
    public void deleteData(int data){
        if(this.isEmpty()){
            System.out.println("List is empty");
            return;
        }
        Node cur = this.head;
        Node pre = cur;
        while(cur != null){
            if(cur.data == data){
                if(cur == this.head){
                    this.head = cur.next;
                }else{
                    pre.next = cur.next;
                }
                break;
            }
            pre = cur;
            cur = cur.next;
        }
    }
    public boolean findData(int data){
        if(this.isEmpty()){
            System.out.println("List is empty");
            return false;
        }
        Node cur = this.head;
        while(cur != null){
            if(cur.data == data){
                return true;
            }
            cur = cur.next;
        }
        return false;
    }
    public void showData(){
        Node cur = this.head;
        while(cur != null){
            System.out.print(cur.data +" ");
            cur = cur.next;
        }
        System.out.println();
    }
}


public class ListPractice04 {
    public static LinkedList removeDup(LinkedList beforeLinkedList){
        LinkedList afterLinkedList = new LinkedList(); // 결과를 담을 단방향 연결 리스트

        Node currentNode = beforeLinkedList.head;
        while(currentNode != null){
            if(!afterLinkedList.findData(currentNode.data)){
                afterLinkedList.insertData(currentNode.data); // 없다면 삽입
            }
            currentNode = currentNode.next;
        }
        return afterLinkedList;
    }
    public static void main(String[] args){
        LinkedList myList = new LinkedList(); // 초기 단뱡향 연결리스트 선언

        Scanner sc = new Scanner(System.in);
        System.out.print("데이터의 개수 입력: ");
        int n = sc.nextInt(); // 데이터 개수 입력

        System.out.printf("%d 개의 데이터를 입력해주세요: ",n);
        while(n -- > 0){
            myList.insertData(sc.nextInt());
        } // n 개 원소 입력

        LinkedList resultList = removeDup(myList); // 함수 호출 후 결과담기
        resultList.showData(); // 결과 출력
    }
}
