// Practice5
// 배열 arr 의 데이터 순서를 거꾸로 변경하시오.
// 추가 배열 사용 x

// 입출력 예시)
// arr : 1,3,5,7,9
// 결과 : 9,7,5,3,1

// stack 을 이용하자

package DataStructure.Array_배열.Array;

import java.util.Scanner;
import java.util.Stack;

public class ArrayPractice05 {
    public static final int MAX = 100; // 원소의 최대값
    public static Stack<Integer> stack = new Stack<>(); // 스택 정의
    public static int[] arr = new int[MAX]; // 배열 정의
    public static int n; // 원소 개수

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("원소의 개수 입력: ");
        n = sc.nextInt();

        System.out.printf("%d 개의 원소를 입력하세요. ",n);
        for (int i = 0; i < n ; i++) {
            arr[i] = sc.nextInt();
            stack.push(arr[i]); // stack 에 push
        } // n개 원소 입력

        System.out.println("== 초기 배열 ==");
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i]+" ");
        }
        System.out.println();
        System.out.println("== 역순 배열 ==");
        for (int i = 0; i < n; i++) {
            System.out.print(stack.pop()+" ");
        }
    }
}
