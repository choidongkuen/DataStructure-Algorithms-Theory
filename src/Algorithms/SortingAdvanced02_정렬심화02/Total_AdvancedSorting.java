package Algorithms.SortingAdvanced02_정렬심화02;


import java.util.Arrays;


public class Total_AdvancedSorting {

    public static void swap(int[] arr, int i, int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
    ///////////////////////////////////////////////////////////////
    public static void merge(int[] arr, int[] mergedArr,int left, int mid, int right){

        int l = left, r = mid + 1;
        int k = left;

        while(l <= mid && r <= right){
            if(arr[l] < arr[r]){
                mergedArr[k ++] = arr[l];
                l ++;
            }else{
                mergedArr[k ++] = arr[r];
                r ++;
            }
        }

        while(l <= mid){
            mergedArr[k ++] = arr[l];
            l ++;
        }

        while(r <= right){
            mergedArr[k ++] = arr[r];
            r ++;
        }

        for(int i = left ; i <= right ; i ++){
            arr[i] = mergedArr[i];
        }
    }
    public static void mergeSort(int[] arr, int[] mergedArr, int left, int right){ // 병합 정렬
        if(left < right){

            int mid = (left + right) / 2;
            mergeSort(arr,mergedArr,left,mid);
            mergeSort(arr,mergedArr,mid + 1,right);
            merge(arr,mergedArr,left,mid,right);

        }
    }
    //////////////////////////////////////////////////////////////
    public static int partition(int[] arr, int left, int right){

        int pivot = arr[right];
        int p = left - 1;

        for(int i = left ; i < right; i ++){
            if(arr[i] < pivot){
                p ++;
                swap(arr,p,i);
            }
        }
        swap(arr,p + 1, right);
        return p + 1;
    }
    public static void quickSort(int [] arr, int left, int right){
        if(left < right){

            int pivot = partition(arr,left,right);
            quickSort(arr,left,pivot - 1);
            quickSort(arr,pivot + 1, right);
        }
    }
    ///////////////////////////////////////////////////////////////
    public static void heapify(int [] arr, int node, int n){

        int largest = node;
        int left = node * 2;
        int right = node * 2 + 1;

        if(left < n && arr[left] > arr[largest])
            largest = left;

        if(right < n && arr[right] > arr[largest])
            largest = right;

        if(largest != node){

            swap(arr,largest,node);
            heapify(arr,largest,n);
        }
    }
    public static void heapSort(int [] arr){ // 힙 정렬

        for(int i = arr.length / 2 - 1; i >= 0; i --){ // arr.length / 2 ~ 1
            heapify(arr,i,arr.length - 1);
        }

        for(int i = arr.length  - 1 ; i > 0 ; i --){
            swap(arr,0,i); // heapify 후 값 교환
            heapify(arr,0, i ); // 교환으로 인해, heapify 구조 깨졌음으로, 다시 heapify
        }
    }
    ///////////////////////////////////////////////////////////////

    public static void main(String[] args) {

        int[] arr1 = {3,5,2,7,1,4,6};
        int[] mergedArr = new int[arr1.length];

        int[] arr2 = arr1.clone();
        int[] arr3 = arr2.clone();

        System.out.println(" == 병합 정렬 == ");
        mergeSort(arr1,mergedArr,0,arr1.length - 1);
        System.out.println(Arrays.toString(arr1));

        System.out.println(" == 퀵 정렬 == ");
        quickSort(arr2,0,arr2.length - 1);
        System.out.println(Arrays.toString(arr2));

        System.out.println(" == 힙 정렬 == ");
        heapSort(arr3);
        System.out.println(Arrays.toString(arr3));
    }
}
