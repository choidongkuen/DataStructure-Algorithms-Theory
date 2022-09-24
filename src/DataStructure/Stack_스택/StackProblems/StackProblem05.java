// 괄호 짝 검사
// 입출력 예시)
// 입력 : "("
// 출력 : Fail

// 입력 : "(((())))"
// 출력 : Pass
package DataStructure.Stack_스택.StackProblems;
import java.util.Scanner;
import java.util.Stack;

public class StackProblem05 {
    public static void main(String[] args){

        Stack stack = new Stack(); // 스택 정의

        Scanner sc = new Scanner(System.in);
        String parenthesis = sc.nextLine(); // 괄호쌍 입력

        for (int i = 0; i < parenthesis.length(); i++) {
            if (parenthesis.charAt(i) == '(') {
                stack.push('(');
            } else { // ')' 에 해당하는 경우
                if (stack.empty()) { // stack 이 비어있을때
                    System.out.println("Fail");
                    return; // 함수 종료
                }
                stack.pop(); // '(' pop
            }
        }
        if(!stack.empty()){
            System.out.println("Fail");
            return;
        }
        System.out.println("Pass");
    }
}
