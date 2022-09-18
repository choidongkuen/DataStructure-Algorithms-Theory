import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class Test {
    public static int n;
    public static int[] arr;

    public static void printArr(){

        for(int i = 0; i < n; i++)
            System.out.print(arr[i] + " ");
    }
    public static void swap(int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    //////////////////////////////////////////////////////// 병합 정렬
    public static int[] mergedArr = new int[n];
    public static void merge(int low, int mid, int high) {

        int i = low, j = mid + 1;
        int k = low;

        while(i <= mid && j <= high){
            if(arr[i] < arr[j]){
                mergedArr[k ++] = arr[i ++];
            }
        }

    }

    public static void mergeSort(int low, int high){
        if(low < high){

            int mid = (low + high) / 2;
            mergeSort(low,mid);
            mergeSort(mid + 1,high);
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
        arr = new int[n]; // 배열

        for(int i = 0 ; i < n; i++)
            arr[i] = sc.nextInt();

//        bubbleSort();
//        selectionSort();
//        insertionSort();
    }
}