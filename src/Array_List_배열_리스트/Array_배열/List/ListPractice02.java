package Array_List_배열_리스트.Array_배열.List;

class LinkedList2 extends LinkedList1{

    LinkedList2(Node node) {
        this.head = node;
    }
    // before_data가 null 인 경우 가장 뒤에 추가
    // before_data에 값이 있는 경우, 해당 값을 가진 노드 앞에 추가

    public void insertData(int data,Integer beforeData){ // beforeData 값을 가진 노드 앞에 추가하겠다.
        if(this.head == null){
            this.head = new Node(data,null);
        } // 비어있던 경우
        else if(beforeData == null){
            Node cur = this.head;
            while(cur.next != null){
                cur = cur.next;
            }
            cur.next = new Node(data,null);
        } // beforeData 가 null 인경우
        else{
            Node cur = this.head;
            Node prev = cur;

            while(cur != null){
                if(cur.data == beforeData){ // 해당 데이터를 가진 노드를 찾은 경우
                    if(cur == this.head){
                        this.head = new Node(data,this.head);
                    }else {
                        prev.next = new Node(data, cur);
                    }
                    break;
                }
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
        LinkedList2 linkedList2 = new LinkedList2(new Node(20,null));
    }
}
