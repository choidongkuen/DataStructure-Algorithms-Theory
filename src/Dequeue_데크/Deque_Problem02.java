// ArrayList 를 이용한 deque 구현해보기


package Dequeue_데크;

import java.util.ArrayList;

class MyDeque{
    ArrayList list;

    MyDeque(){
        this.list = new ArrayList();
    }

    public boolean isEmpty(){
        return this.list.isEmpty(); // 비어있으면 true, 아니면 false
    }
    public int size(){
        return this.list.size();
    }
    public void addFirst(int data){
        this.list.add(0,data);
    }
    public void addLast(int data){
        this.list.add(data);
    }
    public Integer pollFirst(){
        if(this.list.isEmpty()){
            System.out.println("Deque is Empty!");
            return null;
        }
        int data = (int)this.list.get(0);
        this.list.remove(0);
        return data;
    }
    public Integer pollLast(){
        if(this.list.isEmpty()){
            System.out.println("Deque is Empty!");
            return null;
        }
        int data = (int)this.list.get(this.list.size() - 1);
        this.list.remove(this.list.size() - 1);
        return data;
    }
    public void printDeque(){
        System.out.println(this.list);
    }
}

public class Deque_Problem02 {
    public static void main(String[] args) {
        MyDeque deque = new MyDeque();

        deque.addFirst(1);
        deque.addFirst(2);
        deque.addFirst(3);
        deque.addFirst(4); // 4 - 3 - 2 - 1
        System.out.println(deque.size()); // 4

        deque.pollFirst(); // 4
        deque.pollFirst(); // 3

        deque.printDeque(); // 출력

        System.out.println(deque.pollLast()); // 1
    }
}
