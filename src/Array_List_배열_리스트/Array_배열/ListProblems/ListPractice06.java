// 연결 리스트 부분 뒤집기
// 주어진 연결 리스트에서 시작 위치부터 끝 위치 사이의 노드들을 뒤집으시오.

// 입력 예시 )
// 입력 연결 리스트: 1 2 3 4 5
// 시작 위치 : 2
// 끝 위치 : 4
// (처음 위치는 1)
// 결과 연결 리스트 ; 1 4 3 2 5

package Array_List_배열_리스트.Array_배열.ListProblems;
import java.util.Scanner;

public class ListPractice06 {
    public static int n; // 원소 개수
    public static Scanner sc = new Scanner(System.in);

    LinkedList afterList = new LinkedList(); // 결과를 담을 단방향 연결 리스트

    public static LinkedList reverseList(LinkedList myList){ // start - end 노드의 순서를 뒤집어주는 메서드 
        System.out.print("시작 위치와 끝 위치를 입력해주세요. ");
        int start = sc.nextInt(); // 시작 위치 입력
        int end = sc.nextInt(); // 끝 위치 입력

        Node cur1 = null;
        Node pre1 = null;
        
        cur1 = myList.head;
        for (int i = 0; i < start - 1 ; i++) {
            pre1 = cur1;
            cur1 = cur1.next;
        }

        Node cur2 = cur1;
        Node pre2 = pre1;
        Node after = null;

        for (int i = start; i <= end ; i++) {
            after = cur2.next;
            cur2.next = pre2;
            pre2 = cur2;
            cur2 = after;
        }
        pre1.next = pre2;
        cur1.next = cur2;
        return myList;

    }
    public static void main(String[] args){
        LinkedList myList = new LinkedList();

        System.out.print("원소 개수 입력: ");
        n = sc.nextInt();

        System.out.printf("%d 개의 원소를 입력해주세요. ",n);
        for (int i = 0; i < n ; i++) {
            myList.insertData(sc.nextInt());
        }

        LinkedList resultList = reverseList(myList); // 함수 호출
        resultList.showData(); // 결과 출력

    }
}
