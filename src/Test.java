import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;
import java.util.Scanner;

public class Test {
    public static int n;
    public static int[] arr;
    public static int[] mergedArr = new int[100];
    public static ArrayList<Integer>[] list = new ArrayList[100];
//    public static Queue<Integer> queue//
    public static void printArr(){

        for(int i = 0; i < n; i++)
            System.out.print(arr[i] + " ");
    }

    public static void printArr(String s){

        for (int i = 1; i <= n ; i++) {
            System.out.print(arr[i] + " ");
        }
    }
    public static void swap(int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    //////////////////////////////////////////////////////// 힙 정렬
    public static void heapify(int n, int node){ // n : 원소 개수 , node : heapify 대상이 되는 노드
        // 완전 이진 트리를 이용
        int largest = node;
        int left = node * 2;
        int right = node * 2 + 1;

        while(left <= n && arr[left] > arr[largest])
            largest = left;

        while(right <= n && arr[right] > arr[largest])
            largest = right;

        if(largest != node){
            swap(node,largest);
            heapify(n,largest);
        }
    }
    public static void heapSort(){
        for(int i = n / 2; i >= 1; i --){
            heapify(n,i);
        } // n/2 ~ 1

        for(int i = n; i > 1; i --){
            swap(i,1);
            heapify(i - 1,1);
        }
    }
    //////////////////////////////////////////////////////// 퀵 정렬
    public static int partition(int low, int high){
        int pivot = high;
        int i = low - 1;

        for(int j = low; j <= high; j++){
            if(arr[j] < arr[pivot]){
                i ++;
                swap(i,j);
            }
        }
        swap(i + 1,pivot);
        return i + 1;
    }

    public static void quickSort(int low, int high){

        if(low < high){
            int pos = partition(low,high);
            quickSort(low,pos - 1);
            quickSort(pos + 1,high);
        }
    }

    //////////////////////////////////////////////////////// 병합 정렬

    public static void merge(int low, int mid, int high){
        int i = low, j = mid + 1;
        int k = low;

        while(i <= mid && j <= high){
            if(arr[i] < arr[j]){
                mergedArr[k++] = arr[i];
                i ++;
            }else{
                mergedArr[k++] = arr[j];
                j ++;
            }
        }

        while(i <= mid){
            mergedArr[k++] = arr[i];
            i ++;
        }

        while(j <= high){
            mergedArr[k++] = arr[j];
            j ++;
        }

        for(int s = low; s <= high; s++)
            arr[s] = mergedArr[s]; // 옮김
    }

    public static void mergeSort(int low, int high){
        if(low < high){
            int mid = (low + high) / 2;
            mergeSort(low,mid);
            mergeSort(mid + 1, high);
            merge(low,mid,high);
        }
    }


    ////////////////////////////////////////////////////////

    public static void insertionSort(){

        // 앞쪽에 정렬된 영역에 해당 순서에 해당하는 인덱스의 원소를 적절히 삽입
        for(int i = 1; i < n; i++) {
            int key = arr[i];
            int j = i - 1;

            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }

            arr[j + 1] = key;
        }
        System.out.print("선택 정렬 => ");
        printArr();
    }
    public static void seletionSort() {
        // 총 n - 1번의 pass 과정을 듣고, 각 pass 마다 비교횟수가 1 씩 감소한다.

        for(int i = 0 ; i < n - 1; i++){
            int mini = i;

            for(int j = i + 1; j < n; j++){
                if(arr[j] < arr[mini])
                    mini = j;
            }
            swap(i,mini);
        }

        System.out.print("삽입 정렬 => ");
        printArr();
    }

    public static void bubbleSort(){
        // 총 n - 1번의 pass 과정을 돌고, 각 pass 마다 비교횟수가 1 씩 감소한다.
        for(int i = 0; i < n - 1; i ++) {
            boolean isSorted = true;
            for (int j = 0; j < n - 1 - i; j++) {
                if(arr[j] > arr[j + 1]){
                    swap(j, j + 1);
                    isSorted = false;
                }
            }
            if(isSorted)
                break;
        }
        System.out.print("버블 정렬 => ");
        printArr();

    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        arr = new int[n + 1]; // 배열

//        for(int i = 0 ; i < n; i++)
//            arr[i] = sc.nextInt();

//        bubbleSort();
//        selectionSort();
//        insertionSort();
//        mergeSort(0,n-1);
        /////////////////////////////////// - 병합
//        System.out.print("병합 정렬 => ");
//        printArr();
        /////////////////////////////////// - 퀵
//        System.out.print("퀵 정렬 => ");
//        quickSort(0,n - 1);
//        printArr();
        ////////////////////////////////// - 힙
//        for(int i = 1; i <= n ; i++)
//            arr[i] = sc.nextInt();
//        System.out.print("힙 정렬 => ");
//        heapSort();
//        printArr("heap");
        ///////////////////////////////// - 기수

//        for(int i = 0; i < n; i++)
//            list[i] = new ArrayList<>();
    }
}