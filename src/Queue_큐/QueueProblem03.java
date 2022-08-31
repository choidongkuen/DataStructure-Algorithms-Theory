// 배열을 이용한 기본 큐 직접 구현해보기
// 배열은 한정된 공간 - > 스택보다 배열을 이용해서 구현하기 어려움 - > 원형 큐

package Queue_큐;


class Queue2{
    int[] arr;
    int front = 0; // 삭제시 + 1
    int rear = 0; // 삽입시 + 1
    Queue2(int size){
        arr = new int[size + 1]; // 배열 생성
    }
    public boolean isEmpty(){
        return this.rear == this.front;
    }
    public boolean isFull(){
        return (this.rear + 1) % this.arr.length == this.front;
    }
    public void enqueue(int data){
        if(this.isFull()){
            System.out.println("Queue is Full!");
            return;
        } // 이미 꽉찬 경우
        this.rear = (this.rear + 1) % this.arr.length;
        this.arr[this.rear] = data;
    }
    public Integer dequeue(){
        if(this.isEmpty()){
            System.out.println("Queue is Empty");
            return null;
        }
        this.front = (this.front + 1) % this.arr.length;
        return this.arr[this.front];
    }
    public void printQueue(){
        int start = (this.front + 1) % this.arr.length;
        int end = (this.rear + 1) % this.arr.length;

        for(int i = start; i != end; i =  (i + 1) % this.arr.length){
            System.out.print(this.arr[i]+ " ");
        }
        System.out.println();
    }
    public void add(int data){
        if(this.rear >= this.arr.length){
            this.arr[front++] = data;
        }
        this.arr[rear++] = data;
    }
}
public class QueueProblem03 {
}
