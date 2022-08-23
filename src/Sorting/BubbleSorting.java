// 입력 형식
// 첫 번째 줄에는 n이 주어집니다.
//두 번째 줄부터 n개의 원소값이 공백을 사이에 두고 주어집니다.
//1 ≤ n ≤ 100
//1 ≤ 원소 값 ≤ 100

package Sorting;
import java.util.*;

public class BubbleSorting {
    public static final int MAX = 100; // 원소의 개수의 최대값
    public static int[] arr = new int[MAX]; // 배열
    public static int n; // size

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("원소 입력: ");
        n = sc.nextInt(); // size

        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }
        bubbleSort(); // 함수 호출

        System.out.println("==============");
        System.out.print("정렬 결과");
        for(int i = 0; i < n; i++){
            System.out.print(arr[i]+" ");
        } // 출력
    }
    private static void swap(int i,int j){ // swap 함수
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    private static void bubbleSort(){ // 버블 정렬 함수
        for(int i = 0; i < n-1; i++){
            boolean sorted = true;
            for(int j = 0; j < n-1-i; j++){
                if(arr[j] > arr[j+1]){
                    swap(j,j+1); // 함수 호출
                    sorted = false;
                }
            }
            if(sorted) // 순서가 한번도 바뀌지 않았다면 종료 << 개선된 버블 정렬 >>
                break;
        }
    }
}