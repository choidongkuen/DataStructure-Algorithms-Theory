// 두 문자열 비교
// 단, #은 backspace 의 의미로, 바로 이전의 문자를 삭제하는 기능이라고 가정

// 입출력 예시
// 입력 : s1 = "tree" , s2 = "th#ree"
// 출력 : true

// 입력 : s1 = "ab#a", s2 = "aab#"
// 출력 : true

// 해결 방안 : stack 을 마련해서 # 이 나오면 pop 하고 그 외의 경우는 push 해서 결과 도출

package DataStructure.Stack_스택.StackProblems;

import java.util.Scanner;
import java.util.Stack;

public class StackProblem07 {
    public static String isEqual(String s){
        Stack<Character> stack = new Stack();

        for(char c : s.toCharArray()){ // for - each 문
            if(c == '#' && !stack.empty()) {
                stack.pop(); // 바로 앞 원소 pop
            }else{
                stack.push(c);
            }
        }
        return String.valueOf(stack);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("두 문자열을 입력해주세요: ");
        String s1 = sc.next();
        String s2 = sc.next(); // 두 문자열 입력(화이트 스페이스 기준 : 탭,스페이스,엔터리턴 등등)

        if(isEqual(s1).equals(isEqual(s2))){
            System.out.println("true");
            //System.out.println(String.valueOf(s1));
        }else{
            System.out.println("false");
        }
    }
}
