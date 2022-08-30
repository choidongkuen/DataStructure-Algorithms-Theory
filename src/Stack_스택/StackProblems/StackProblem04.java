// 문자열 뒤집기

// 입출력 예시)
// 입력 : Hello
// 출력 : olleH
// 입력 : 1 3 5 7 9
// 출력 : 9 7 5 3 1

package Stack_스택.StackProblems;
import java.util.Scanner;
import java.util.Stack;

public class StackProblem04 {
    
    public static void main(String[] args){
        Stack stack = new Stack(); //  스택 정의
        Scanner sc = new Scanner(System.in);

        String str = sc.nextLine(); // 문자열 입력
        for (int i = 0; i < str.length() ; i++) {
            stack.push(str.charAt(i));
        } // 스택에 원소 입력

        while(!stack.isEmpty()){ // stack 의 원소가 존재하는 동안
            System.out.print(stack.pop()+"");
        }
    }
}
