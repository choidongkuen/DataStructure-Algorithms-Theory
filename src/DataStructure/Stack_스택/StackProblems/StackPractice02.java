// ArrayList 로 Stack 구현해보기

package DataStructure.Stack_스택.StackProblems;
import java.util.ArrayList;
import java.util.Random;

class MyStack{
    ArrayList<Integer>list; //
    MyStack(){
        this.list = new ArrayList<>(); // generic 으로 선언 안 할 수 있지만, 그런 경우는 형변환이 필수!!!!
    }
    public boolean empty(){
        if(this.list.isEmpty()){
            return true;
        }
        return false;
    }
    public void push(int data){
        this.list.add(data);
    }
    public Integer pop(){
        if(this.list.isEmpty()){
            System.out.println("Stack is empty");
            return null;
        }
        Integer ele = this.list.get(this.list.size() - 1);
        this.list.remove(this.list.get(this.list.size() - 1));
        return ele;
    }
    public Integer peek(){
        if(this.list.isEmpty()){
            System.out.println("Stack is empty");
            return null;
        }
        return this.list.get(this.list.size() - 1);
    }
    public void printStack(){
        System.out.println(this.list);
    }
}
public class StackPractice02 {
    public static void main(String[] args){
        MyStack stack = new MyStack();
        Random random = new Random();

        for (int i = 0; i < 50 ; i++) {
            stack.push(random.nextInt(100)); // 랜덤한 숫자 push
        } // stack 마련
        stack.printStack(); //상태 출력

        for (int i = 0; i < 10; i++) {
            System.out.println(stack.pop());
        }

        System.out.println(stack.peek());
        System.out.println(stack.peek());
        System.out.println(stack.peek());

        stack.printStack();



    }
}
