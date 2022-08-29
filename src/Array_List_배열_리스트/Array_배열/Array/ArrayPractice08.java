// Practice 08
// 배열 arr 에서 중보고딘 값을 제거한 새 배열을 만드시오.

// 입출력 예시)
// arr : 1 5 3 2 2 3 1 4 1 2 3 5
// 결과 : 1 5 3 2 4
// 이중 루프 ?
// 배열에 기록 ?

package Array_List_배열_리스트.Array_배열.Array;

import java.util.Scanner;

public class ArrayPractice08 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("원소의 개수 입력: ");
        int n = sc.nextInt();

        int[] arr = new int[n]; // 배열 생성
        int[] newArr = new int[n]; // 중복제거한 원소 담은 배열 생성

        System.out.printf("%d 개의 원소를 입력해주세요. ",n);
        for (int i = 0; i < n ; i++) {
            arr[i] = sc.nextInt();
        }

        int index = 0;
        for (int i = 0; i < n ; i++) {
            boolean overlap = false;
            for (int j = 0; j < index; j++) {
                if (arr[i] == arr[j]) {
                    overlap = true;
                    break; // 중복되는 원소가 이미 newArr에 존재
                }
            }
            if(!overlap)
                newArr[index++] = arr[i];
        }
        for (int i = 0; i < index ; i++) {
            System.out.print(newArr[i]+" ");
        }
    }
}
