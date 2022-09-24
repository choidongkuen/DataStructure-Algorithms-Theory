// 입력 형식
// 첫 번째 줄에는 n이 주어집니다.
// 두 번째 줄부터 n개의 원소값이 공백을 사이에 두고 주어집니다.
// 1 ≤ n ≤ 100,000
// 1 ≤ 원소 값 ≤ 100,000

package Algorithms.SortingAdvanced_정렬심화;

import java.util.*;
public class HeapSorting {
    public static final int MAX_N = 100000; // 최대 원소 수
    public static int n; // 원소 개수
    public static int[] arr = new int[MAX_N]; // 배열

    public static void swap(int x, int y){
        int temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    } // 원소 교환해주는 메서드

    public static void heapify(int n, int node){
        int largest = node; // 부모노드
        int l = node * 2; // 왼쪽 자식
        int r = node * 2 + 1; // 오른쪽 자식

        boolean nodeIsLargest = true; // largest가 부모인지 판단하는 부울 변수

        if(l <= n && arr[l] > arr[largest]){
            largest = l;
            nodeIsLargest = false;
        }

        if(r <= n && arr[r] > arr[largest]){
            largest = r;
            nodeIsLargest = false;
        }

        if(!nodeIsLargest){
            swap(node,largest);
            heapify(n,largest);
        }
    }
    public static void heapSort(){
        for(int i = n/2; i >= 1 ; i--)
            heapify(n,i); // n/2 ~ 1 heapify()

        for(int i = n; i > 1; i--){
            swap(i,1);
            heapify(i-1,1); // 각 단계마다 정렬되지 않은 구간에서 마지막 인덱스 원소와
                                     // 1 번째 원소 교환 후, max heap 구조를 유지하기 위해 hea[ify(1) 진행
        }
    } // heapsort 메서드
    public static void main(String[] args) {
        // Your Program Goes Here
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        for(int i = 1; i <= n; i++){
            arr[i] = sc.nextInt();
        }

        heapSort(); // 힙 정렬 메서드 호출

        for(int i = 1; i <= n; i++){
            System.out.print(arr[i]+" ");
        }
    }
}