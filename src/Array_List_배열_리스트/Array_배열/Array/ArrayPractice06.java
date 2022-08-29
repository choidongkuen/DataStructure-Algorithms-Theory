// Practice 06
// 배열 arr 에서 peek 값 모두 출력
// peek 란 -> 좌우 보다 큰 경우 peek 라고 함 (마치 산봉우리)

// 입출력 예시)
// arr : 3,1,2,6,2,2,5,1,9,10,1,11
// 결과 : 3,6,5,10,11

package Array_List_배열_리스트.Array_배열.Array;

import java.util.Scanner;

public class ArrayPractice06 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("원소 개수 입력: ");
        int n = sc.nextInt(); // 원소 개수 입력
        int[] arr = new int[n]; // 배열 생성

        System.out.printf("%d개의 원소 입력: ",n);
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        } // 배열 원소 입력

        System.out.println("== peek ==");
        for (int i = 0; i < n ; i++) {
            if(i == 0){
                if(arr[i] > arr[i+1])
                    System.out.print(arr[i]+" ");
            }
            else if(i == n-1){
                if(arr[i] > arr[i-1])
                    System.out.print(arr[i]+" ");
            }
            else{
                if(arr[i] > arr[i - 1] && arr[i] > arr[i+1])
                    System.out.print(arr[i]+" ");
            }
        }


    }
}
