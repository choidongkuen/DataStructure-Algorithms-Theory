// 입력 형식
// 첫 번째 줄에는 n이 주어집니다.
//두 번째 줄부터 n개의 원소값이 공백을 사이에 두고 주어집니다.
//1 ≤ n ≤ 100
//1 ≤ 원소 값 ≤ 100

package SortingBasic_정렬기본;
import java.util.*;

public class InsertionSorting {
    public static final int MAX = 100; // 원소의 개수의 최대값
    public static int[] arr = new int[MAX]; // 배열 선언
    public static int n; // size
    public static void insertionSort(){ // 삽입 정렬 함수
        for(int i = 1; i < n; i++){
            int j = i - 1;
            int key = arr[i];
            while(j >= 0 && arr[j] > key){
                arr[j+1] = arr[j];
                j --;
            }
            arr[j+1] = key;
        }
    }
    public static void main(String[] args) {
        // Your Program Goes Here
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt(); // 원소 개수 입력

        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        } // 배열 원소 입력

        insertionSort(); // 함수 호출

        for(int i = 0; i < n; i++){
            System.out.print(arr[i]+" ");
        } // 출력
    }
}