// 후위표기법 연산
// 입출력 예시)
// 입력 "2 2 +"
// 출력 4

// 입력 "2 2 -"
// 출력 0

// 해결 방법 : 스택을 생성하고, operand 일시 push 하고, operator 이면 두개 pop 해서 계산 후, 다시 push
// 모든 과정이 끝나면 스택에는 결과만 남아 있을 것이다.

package DataStructure.Stack_스택.StackProblems;

import java.util.Scanner;
import java.util.Stack;

public class StackProblem06 {
    public static double calculator(String str){ // postfix 계산하는 메서드
        Stack<Double> stack = new Stack(); // 스택 선언
        String[] arr = str.split(" "); // 문자열 배열 선언

        for(String sub : arr){
            if(sub.equals("+")){ // 더하기
                stack.push(stack.pop() + stack.pop());
            }else if(sub.equals("-")){ // 빼기
                stack.push(- stack.pop() + stack.pop());
            }else if(sub.equals("*")){ // 곱하기
                stack.push(stack.pop() * stack.pop());
            }else if(sub.equals("/")){ // 나누기
                stack.push(1 / stack.pop() * stack.pop());
            }else{
                stack.push(Double.valueOf(sub));
            }
        }
        return stack.pop();
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("profix 입력해주세요: ");
        String str = sc.nextLine(); // 문자열 입력

        double result = calculator(str); // 계산기 메서드 호출
        System.out.println(result); // 결과 출력
    }
}
