// 기본적인 stack 메서드 테스트 해보기

package DataStructure.Stack_스택.StackProblems;
import java.util.Stack;

public class StackPractice01 {
    public static void main(String[] args){
        Stack stack =  new Stack(); // 스택 구현
        int data = 1;
        for (int i = 0; i < 10; i++) {
            stack.push(data++);
        } // 10 개 데이터 push

        stack.pop(); // pop
        System.out.println(stack.pop()); // pop
        System.out.println((stack)); // 리스트 형태로 출력
        System.out.println(stack.peek()); // peek
        System.out.println(stack.contains(1)); // contains
        System.out.println(stack.size()); // size
        System.out.println(stack.empty()); // empty
        System.out.println(stack.isEmpty()); // isEmpty
        stack.clear(); // clear
    }
}
