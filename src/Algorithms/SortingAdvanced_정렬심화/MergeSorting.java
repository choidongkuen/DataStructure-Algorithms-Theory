// 입력 형식
// 첫 번째 줄에는 n이 주어집니다.
//두 번째 줄부터 n개의 원소값이 공백을 사이에 두고 주어집니다.
//1 ≤ n ≤ 100,000
//1 ≤ 원소 값 ≤ 100,000


package Algorithms.SortingAdvanced_정렬심화;
import java.util.*;

public class MergeSorting {
    public static final int MAX_N = 100000; // 원소 최대 개수
    public static int[] arr = new int[MAX_N]; // 배열 선언
    public static int[] mergedArr = new int[MAX_N]; // mergedArr 배열 선언
    public static int n; // 원소 개수

    public static void merge(int low,int mid,int high){
        int i = low, j = mid+1;
        int k = low; // mergeArr 시작 인덱스

        while(i <= mid && j <= high){
            if(arr[i] < arr[j]){
                mergedArr[k++] = arr[i++];
            }
            else{
                mergedArr[k++] = arr[j++];
            }
        } // 두 배열의 모두 원소 남아 있는 경우

        while(i <= mid){
            mergedArr[k++] = arr[i++];
        }

        while(j <= high){
            mergedArr[k++] = arr[j++];
        }

        for(int s = low; s <= high; s++){
            arr[s] = mergedArr[s];
        } // arr 업데이트
    }

    public static void mergeSort(int low, int high){
        if(low < high){
            int mid = (low + high) / 2;
            mergeSort(low,mid);
            mergeSort(mid+1,high);
            merge(low,mid,high);
        }
    }
    public static void main(String[] args) {
        // Your Program Goes Here
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        } // 원소 입력

        int low = 0,high = n-1;
        mergeSort(low,high); // 함수 호출

        for(int i = 0; i < n; i++){
            System.out.print(arr[i]+" ");
        } // 결과 출력
    }
}