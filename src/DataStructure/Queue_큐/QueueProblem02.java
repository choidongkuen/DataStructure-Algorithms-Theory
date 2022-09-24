// 연결리스트를 이용해서 큐 구현해보기
package DataStructure.Queue_큐;

import java.util.LinkedList;

class Queue{
    LinkedList<Integer>list;
    Queue(){
        list = new LinkedList();
    }
    public boolean isEmpty(){
        if(this.list.isEmpty()){
            return true;
        }
        return false;
    }
    public void addData(int data){
        this.list.add(data);
    }
    public Integer poll(){
        if(this.isEmpty()){
            System.out.println("Queue is empty");
            return null;
        }
        int data = this.list.get(0);
        list.remove(0);
        return data;
    }
    public Integer peek(){
        if(this.isEmpty()){
            System.out.println("Queue is empty");
            return null; // 해당 메서드 반환형을 int 로 하면 어떤 특정 숫자를 무조건 return 해야함. - > Integer 사용
        }
        int data = this.list.get(0);
        return data;
    }
    public void printQueue(){
        System.out.println(this.list);
    }
}
public class QueueProblem02 {
    public static void main(String[] args){

        Queue queue = new Queue();
        queue.addData(1);
        queue.addData(2);
        queue.addData(3); // 데이터 삽입

        queue.printQueue(); // 상태 출력

        queue.poll(); // 맨 앞 원소 삭제
        queue.poll();
        queue.addData(10);

        System.out.println(queue.peek()); // 맨 앞 원소 출력
        queue.printQueue();
    }
}
