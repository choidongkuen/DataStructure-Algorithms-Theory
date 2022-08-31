// 연결리스트 연습 문제 01
// Palindrome 연결 리스트
// 추가 자료구조 없이 연결 리스트만으로 풀어보기

// 입력 예시)
// 입력 : 1 3 5 3 1
// 결과 : true

// 입력 : 3 5 5 3
// 결과 : true

// 입력 : 1 3 5 1
// 결과 : false
package Array_List_배열_리스트.Array_배열.ListProblems;
import java.util.Scanner;

public class ListPractice05 {
    public static int n;
    public static boolean checkPalindrome(LinkedList list) {
        Node cur = list.head;
        Node left = list.head;
        Node right = null;

        int cnt = 0;
        while (cur != null) {
            cnt++;
            right = cur;
            cur = cur.next;
        }

        Node prevRight = right;
        for (int i = 0; i < cnt / 2; i++) {
            if (left.data != right.data) {
                return false;
            }

            left = left.next;
            right = left;
            while (right.next != prevRight) {
                right = right.next;
            }
        }

        return true;
    }
    public static void main(String[] args){
        LinkedList myList = new LinkedList(); // ListPractice04 에 존재하는 LinkedList 객체 선언
        Scanner sc = new Scanner(System.in);
        System.out.print("원소 개수 입력: ");
        n = sc.nextInt(); // 원소 개수 입력

        System.out.printf("%d 개의 원소 입력합니다.",n);
        for (int i = 0; i < n ; i++) {
            myList.insertData(Integer.parseInt(sc.next()));
        }
        if(checkPalindrome(myList))
            System.out.println("true");
        else
            System.out.println("false");
    }
}

