// 배열을 이용한 deque 구현해보기

package DataStructure.Dequeue_데크;

class MyDeque2{
    int[] arr;
    int size;

    MyDeque2(int size){
        this.arr = new int[size];
        this.size = size;
    }

    public boolean isEmpty(){
        if(this.arr.length == 0)
            return true;
        return false;
    }
    public boolean isFull(){
        if(this.arr.length == size)
            return true;
        return false;
    }
    public void addFirst(int data){
        int[] newArr = new int[this.size + 1];
        newArr[0] = data;
        for(int i = 0; i < this.size; i++)
            newArr[i + 1] = this.arr[i];

        this.arr = newArr;
    }
    public void addLast(int data){
        int[] newArr = new int[this.size + 1];
        for(int i = 0; i < this.size; i++)
            newArr[i] = this.arr[i];

        newArr[newArr.length - 1] = data;

        this.arr = newArr;
    }
    public Integer removeFirst(){
        if(this.isEmpty()){
            System.out.println("Deque is Empty");
            return null;
        }
        Integer data = this.arr[0];
        int[] newArr = new int[this.size - 1];

        for(int i =  1; i < this.arr.length; i ++)
            newArr[i - 1] = this.arr[i];

        this.arr = newArr;
        return data;
    }
    public Integer removeLast(){
        if(this.isEmpty()){
            System.out.println("Deque is Empty");
            return null;
        }
        Integer data = this.arr[this.arr.length - 1];
        int[] newArr = new int[this.size - 1];

        for(int i = 0; i < this.arr.length; i++)
            newArr[i] = this.arr[i];

        this.arr = newArr;

        return data;
    }
    public void printDeque(){
        for(int i = 0 ; i < this.arr.length; i++)
            System.out.print(arr[i] + " ");
    }
}

public class Deque_Problem03 {
    public static void main(String[] args) {

        MyDeque2 myDeque2 = new MyDeque2(5);

        myDeque2.addFirst(1);
        myDeque2.addFirst(2);
        myDeque2.addFirst(3);
        myDeque2.addFirst(4);

        myDeque2.removeFirst();
        myDeque2.printDeque();
    }
}
