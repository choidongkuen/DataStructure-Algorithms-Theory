// 배열 arr 의 모든 데이터에 대해서,
// 짝수 데이터들의 평균과 홀수 데이터들의 평균을 출력하세요.

// 입출력 예시)
// 배열 arr: 1,2,3,4,5,6,7,8,9
// 결과 :
// 짝수 평균 : 5.0
// 홀수 평균 : 5.0
// 원소의 최대 크기 : 100

package DataStructure.Array_배열.Array;

import java.util.Scanner;

public class ArrayPractice03 {
    public static final int MAX = 100;
    public static int[] arr = new int[MAX];
    public static int n; // 실제 원소 크기

    public static void getAverage(){
        int sEven = 0,sOdd = 0,cntEven = 0,cntOdd=0;
        for (int i = 0; i < n ; i++) {
            if(arr[i] % 2 == 0){ // 해당 데이터가 짝수이면
                sEven += arr[i];
                cntEven++; // 횟수 증가
            }
            else{ // 해당 데이터가 홀수이면
                sOdd += arr[i];
                cntOdd++; // 횟수 증가
            }
        }
        System.out.printf("짝수 데이터들의 평균: %.1f\n",(float)sEven / cntEven);
        System.out.printf("홀수 데이터들의 평균: %.1f",(float)sOdd / cntOdd);
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("배열 크기 : ");
        n = sc.nextInt(); // 배열 크기 입력

        System.out.printf("%d 개의 원소를 입력해주세요. ",n);
        for (int i = 0; i < n ; i++) {
            arr[i] = sc.nextInt(); // 배열 원소 입력
        }

        getAverage(); // 함수 호출
    }
}
