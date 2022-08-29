// Pratice 3
// 배열 arr 에서 target 에 해당하는 값의 인덱스 출력
// 해당 값이 여러 개인 경우 가장 큰 인덱스 출력
// lower bound upper bound 사용 할 수 있나? - > 불가할듯.. 예시를 잘 보자 정렬이 필요한데...
// 여러 개인 경우를 대비해 나올때마다 인덱스 갱신하자.


// 입출력 예시)
// 배열 arr : 1,1,100,1,1,1,100
// target : 100
// 결과 : 6
// 원소의 최대 개수 : 100

package Array_List_배열_리스트.Array_배열.Array;

import java.util.Scanner;

public class ArrayPractice04{
    public static final int MAX = 100;
    public static int[] arr = new int[MAX];
    public static int n; // 원소의 개수
    public static void findIndex(int target){
        int ind = -1;
        for (int i = 0; i < arr.length ; i++) {
            if(arr[i] == target){
                ind = i;
            }
        }
        if(ind == -1)
            System.out.println("찾으시는 원소가 존재하지 않습니다.");
        else {
            System.out.printf("찾으시는 원소는 %dindex에 존재합니다.", ind);
        }
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("원소 개수 입력: ");
        n = sc.nextInt(); // 원소 개수 입력

        System.out.printf("%d 개의 원소 입력: ",n);

        for (int i = 0; i < n ; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.print("찾고자 하는 값은? ");
        int target = sc.nextInt();
        findIndex(target);
    }
}