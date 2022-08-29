// Practice07
// 배열 arr 의 값을 오름차순으로 출력

// 1. 인덱스를 이용
// 2. Array.sort()
// 3. 다양한 정렬 방식 v


// 입출력 예시)
// arr : 5,3,1,4,6,1
// 결과 : 1,1,3,4,5,6


// 추가적으로 주어진 배열을 배웠던 정렬방식(버블,선택,삽입,병합,힙,퀵 정렬)로 구현해보기
// Stable : 버블 삽입 기수 병합 vs Unstable : 선택 힙 퀵
// In - place : 기수, 병합

package Array_배열;

import java.util.Arrays;
import java.util.Scanner;

public class ArrayPractice07 {
    public static final int MAX = 100;
    public static int[] arr = new int[10];
    public static int n; // 원소 개수
    public static void printElements(int[] arrayy){
        for (int i = 0; i < n ; i++) {
            System.out.print(arrayy[i]+" ");
        }
    }
    public static void swap(int[] arrGiven, int i, int j){
        int temp = arrGiven[i];
        arrGiven[i] = arrGiven[j];
        arrGiven[j] = temp;
    }
    public static void bubbleSort(int[] arr1){
        for (int i = 0; i < n - 1; i++) {
            boolean sorted = true;
            for (int j = 0; j < n - 1 - i ; j++) {
                if(arr1[j] > arr1[j + 1]){
                    swap(arr1,j,j + 1);
                    sorted = false;
                }
            }
            if(sorted) { // 정렬된 상태
                break;
            }
        }
        System.out.println("== 버블 정렬 ==");
        printElements(arr1);
        System.out.println();
    }
    public static void selectionSort(int[] arr2){
        for (int i = 0; i < n - 1; i++) {
            int mini = i; // i = 해당 번째에 최소값이 들어가야 할 인덱스
            for (int j = i + 1; j < n ; j++) {
                if(arr2[j] < arr2[mini]){
                    mini = j;
                }
            }
            swap(arr2,mini,i);
        }
        System.out.println("== 선택 정렬 ==");
        printElements(arr2);
        System.out.println();
    }
    public static void insertionSort(int[] arr3){
        for (int i = 1; i < n; i++) {
            int j = i - 1;
            int key = arr3[i];
            while(j >= 0 && arr3[j] > key){
                arr3[j+1] = arr3[j];
                j--;
            }
            arr3[j + 1] = key;
        }
        System.out.println("== 삽입 정렬 ==");
        printElements(arr3);
        System.out.println();
    }
    public static int[] mergedArr = new int[MAX];
    public static void merge(int[] arr5,int left,int mid,int right){
        int i = left,j = mid + 1;
        int k = left;

        while(i <= mid && j <= right){
            if(arr5[i] < arr5[j]){
                mergedArr[k++] = arr5[i++];
            }
            else{
                mergedArr[k++] = arr5[j++];
            }
        }
        while(i <= mid){
            mergedArr[k++] = arr5[i++];
        }
        while(j <= right){
            mergedArr[k++] = arr5[j++];
        }
        for (int l = left; l <= right; l++) {
            arr5[l] = mergedArr[l];
        }
    }
    public static void mergeSort(int[] arr5,int left,int right){
        if(left < right){
            int mid = (left + right) / 2;
            mergeSort(arr5, left, mid);
            mergeSort(arr5,mid + 1,right);
            merge(arr5,left,mid,right);
        }
    }
    public static int partition(int[] arr,int left,int right){
        int pivot = arr[right];
        int i = left - 1;

        for (int j = left; j < right  ; j++) {
            if(arr[j] < pivot){
                i++;
                swap(arr,i,j);
            }
        }
        swap(arr,i+1,right);
        return i + 1;
    }
    public static void quickSort(int[] arr6,int left, int right) {
        if (left < right) {
            int pos = partition(arr6, left, right);
            quickSort(arr6, left, pos - 1);
            quickSort(arr6, pos + 1, right);
        }
    }
    public static void heapify(int[] arr7, int n ,int node){
            int largest = node;
            int l = node * 2;
            int r = node * 2 + 1;

            if(l <= n && arr7[largest] < arr7[l])
                largest = l;

            if(r <= n && arr7[largest] < arr7[r])
                largest = r;

            if(largest != node){
                swap(arr7,node,largest);
                heapify(arr7,n,largest);
            }
    }
    public static void heapSort(int[] arr7){
        for (int i = n / 2; i >= 1; i--) {
            heapify(arr7,n,i);
        }
        for (int i = n; i > 1 ; i--) {
            swap(arr7,i,1);
            heapify(arr7,i - 1,1);
        }
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("원소 개수 입력: ");
        n = sc.nextInt(); // 원소 개수 입력

        System.out.printf("%d 개의 원소를 입력해주세요: ",n);
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println("== 초기 배열 ==");
        printElements(arr);
        System.out.println();

        int[] arrDup1 = arr.clone();
        bubbleSort(arrDup1);

        int[] arrDup2 = arr.clone();
        insertionSort(arrDup2);

        int[] arrDup3 = arr.clone();
        selectionSort(arrDup3);

        /*
        int[] arrDup4 = arr.clone();
        System.out.println("== Arrays 클래스 사용 ==");
        Arrays.sort(arrDup4);
        printElements(arrDup4); // 원소중에 0이 존재한다!!
        */

        int[] arrDup5 = arr.clone();
        System.out.println("== 병합 정렬 ==");
        mergeSort(arrDup5,0,n-1);
        printElements(arrDup5);
        System.out.println();

        int[] arrDup6 = arr.clone();
        System.out.println("== 퀵 정렬 == ");
        quickSort(arrDup6,0,n-1);
        printElements(arrDup6);
        System.out.println();

        int[] arrDup7 = arr.clone();
        int[] newArr = new int[arr.length + 1];
        for (int i = 0; i < arr.length ; i++) {
            newArr[i + 1] = arrDup7[i];
        }
        System.out.println("== 힙 정렬 =="); // 힙정렬은 1번인덱스 부터 작동하도록 설계
        heapSort(newArr);
        for (int i = 1; i < n + 1; i++) {
            System.out.print(newArr[i] + " ");
        }

        //System.out.println(Arrays.toString(arr));
        //System.out.println(Arrays.toString(newArr));
    }
}
