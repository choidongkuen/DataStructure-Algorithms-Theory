// 문제 설명 :
// 정수를 저장하는 스택을 구현한 다음, 입력으로 주어지는 명령을 처리하는 프로그램을 작성해보세요. 명령어는 총 5가지 입니다.

// 명령어 :
// push A: 정수 A를 스택에 넣는 연산입니다. 새로 들어온 정수는 상단부터 차례대로 스택에 쌓입니다.
// pop: 스택에서 가장 위에 있는 정수를 빼고, 그 수를 출력합니다.
// size: 스택에 들어있는 정수의 개수를 출력합니다.
// empty: 스택이 비어있으면 1, 아니면 0을 출력합니다.
// top: 스택의 가장 위에 있는 정수를 출력합니다.

package DataStructure.Stack_스택.StackProblems;
import java.util.*;

public class CommandProcessing {
    public static Stack<Integer> stack = new Stack<>(); // 스택 정의
    public static int n; // 명령어 개수

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt(); // 명령어 개수 입력
        while(n-- > 0){ // n개 명령어 처리
            String command = sc.next(); // 명령어 입력

            if(command.equals("push"))
                stack.push(sc.nextInt());

            else if(command.equals("size"))
                System.out.println(stack.size());

            else if(command.equals("empty")){
                int result = (stack.empty())? 1 : 0;
                System.out.println(result);
            }
            else if(command.equals("top")){
                System.out.println(stack.peek());
            }
            else{
                System.out.println(stack.pop());
            }
        }
    }
}