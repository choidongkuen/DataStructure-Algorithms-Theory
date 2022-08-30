// 단순 연결 리스트(advanced ver.) 기본 구조 구현 해보기

package Array_List_배열_리스트.Array_배열.List;
class LinkedList2 extends LinkedList1{

    LinkedList2(Node node){
        this.head = node;
    }
    // before_data 가 null 인 경우 가장 뒤에 추가
    // before_data 에 값이 있는 경우, 해당 값을 가진 노드 앞에 추가

    public void insertData(int data,Integer beforeData){ // beforeData 값을 가진 노드 앞에 추가하겠다.
        if(this.head == null){ // 비어있던 경우
            this.head = new Node(data,null);
        }

        else if(beforeData == null){ // beforeData 가 null 인경우
            Node cur = this.head;
            while(cur.next != null){
                cur = cur.next;
            }
            cur.next = new Node(data,null);
        }

        else{ // beforeData 에 값이 있는 경우
            Node cur = this.head;
            Node prev = cur;

            while(cur != null){
                if(cur.data == beforeData){
                    if(cur == this.head){
                        this.head = new Node(data,this.head);
                    }else {
                        prev.next = new Node(data, cur);
                    }
                    break;
                } // beforeData 를 가진 노드를 찾은 경우
                prev = cur;
                cur = cur.next;
            }
        }
    }
    public void deleteNode(int data){
        if(this.isEmpty()){
            System.out.println("List is Empty");
            return;
        }

        Node cur = this.head;
        Node prev = cur;

        while(cur != null){
            if(cur.data == data){
                if(cur == this.head){
                    this.head = cur.next;
                }else{
                    prev.next = cur.next;
                }
                break;
            }
            prev = cur;
            cur = cur.next;
        }
    }
}
public class ListPractice02 {
    public static void main(String[] args){
        LinkedList2 myList2 = new LinkedList2(new Node(20,null));
        myList2.printAll();

        myList2.insertNode(2);
        myList2.insertNode(3);
        myList2.insertNode(4);
        myList2.insertNode(5);

        myList2.printAll();

        myList2.insertData(100,2);
        myList2.insertData(200,3);
        myList2.insertData(300,4);
        myList2.insertData(400,5);

        myList2.printAll();

        myList2.deleteNode(100);
        myList2.deleteNode(200);
        myList2.deleteNode(300);

        myList2.printAll();

    }
}
