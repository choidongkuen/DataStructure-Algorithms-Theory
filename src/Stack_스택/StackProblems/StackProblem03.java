// 배열로 기본 스택 구현해보기
package Stack_스택.StackProblems;

import java.util.ArrayList;

class Stack2{
    int[] arr;
    int top = -1; // 아무것도 안들어 있으면 -1 -> 추가 할 때마다 += 1(일종의 인덱스)
    Stack2(int size){
        arr = new int[size];
    }
    public boolean isEmpty(){
        return this.top == -1;
    }
    public boolean isFull(){
        return this.top == this.arr.length;
    }
    public void push(int data){
        if(this.isFull()){
            System.out.println("Stack is Full");
            return;
        }
        this.arr[++this.top] = data;
    }
    public Integer pop() {
        if (this.isEmpty()) {
            System.out.println("Stack is Empty");
            return null; // 반환형이 객체인 경우는 return; 불가!! return null 해야함
        }
        int data = this.arr[this.top];
        this.top -= 1; // top 으로 관리
        return data;
    }
    public Integer peek(){
        if(this.isEmpty()){
            System.out.println("Stack is Empty");
            return null;
        }
        return this.arr[top];
    }
    public void printStack(){
        for (int i = 0; i < this.top ; i++) {
            System.out.print(this.arr[i]+" ");
        }
    }
}

public class StackProblem03 {
    public static void main(String[] args){
        Stack2 stack = new Stack2(10);
        for (int i = 0; i < 4 ; i++) {
            stack.push(i + 10);
        }
        stack.pop();
        System.out.println(stack.pop());
        System.out.println(stack.peek());

        stack.printStack();
    }
}
