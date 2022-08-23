// 입력 형식
// 첫 번째 줄에는 n이 주어집니다.
//두 번째 줄부터 n개의 원소값이 공백을 사이에 두고 주어집니다.
//1 ≤ n ≤ 100
//1 ≤ 원소 값 ≤ 100

package SortingBasic;
import java.util.Scanner;

public class SelectionSorting {
    public static final int MAX = 100; // 원소의 개수의 최대값
    public static int[] arr = new int[MAX]; // 배열언 선언
    public static int n; // size

    private static void swap(int i,int j){ // 원소 교환해주는 함수
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private static void selectionSort(){ // 선택 정렬 함수
        for (int i = 0; i < n - 1 ; i++) {
            int mini = i;
            for (int j = i+1 ; j < n ; j++) {
                if(arr[j] < arr[mini]){
                    mini = j;
                }
            }
            swap(mini,i); // swap 함수 호출
        }
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("배열의 원소 개수: ");
        n = sc.nextInt(); // 원소 개수

        System.out.print("원소 입력: ");
        for (int i = 0; i < n ; i++) {
            arr[i] = sc.nextInt();
        } // 원소 입력

        selectionSort(); // 선택 정렬 함수 호출
        System.out.println("========");
        System.out.println("정렬 결과: ");
        for (int i = 0; i < n ; i++) {
            System.out.print(arr[i]+" "); // 출력
        }
    }
}