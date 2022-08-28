// 문제 설명 :
// 문자가 주어지면 괄호 쌍이 맞는지 체크하는 프로그램을 작성하라.


package Stack_스택;

import java.util.Scanner;
import java.util.Stack;

public class ParenthesizeCheck {

    public static String str; // 주어지는 문자열
    public static Stack<Character> stack = new Stack<>(); // 스택 프레임워크 선언
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("괄호문자를 입력해주세요: ");
        str = sc.nextLine();

        for (int i = 0; i < str.length() ; i++) {
            if (str.charAt(i) == '(') {
                stack.push('(');
            } else { // ')'에 해당하는 경우
                if (stack.empty()) // 원소가 존재하지 않은 경우( ')'이 더 많은 경우 )
                    System.out.println("false");
                stack.pop(); // 원소 하나 pop
            }
        }
        if(!stack.empty())
            System.out.println("false");
        System.out.println("true");
    }
}
