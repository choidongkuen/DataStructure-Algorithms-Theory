package Algorithms.SortingBasic_정렬기본;

import java.util.Arrays;

public class Total_BasicSorting{

    public static void swap(int[] arr, int i , int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void bubbleSort(int[] arr){ // 버블 정렬

        for (int i = 1; i < arr.length ; i++) {
            boolean isSorted = true;
            for(int j = 0 ; j < arr.length - i; j ++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                    isSorted = false;
                }
            }
            if(isSorted)
                break;
        }
    }

    public static void insertSort(int[] arr){ // 삽입 정렬

        for(int i = 1; i < arr.length; i ++){
            for(int j = i; j > 0 ; j --){
                if(arr[j] < arr[j - 1]){
                    swap(arr,j,j-1);
                }else{
                    break;
                }
            }
        }
    }

    public static void selectSort(int[] arr){

        for(int i = 0; i < arr.length - 1; i ++){
            int mini = i;

            for(int j = i + 1; j < arr.length; j ++){
                if(arr[j] < arr[mini])
                    mini = j;
            }
            swap(arr,mini,i);
        }
    }

    public static void main(String[] args) {

        int[] arr1 = {3,5,2,7,1,4};
        int[] arr2 = arr1.clone();
        int[] arr3 = arr1.clone(); // 깊은 복사


        bubbleSort(arr1);
        System.out.print(" == 버블 정렬 == \n");
        System.out.println(Arrays.toString(arr1));

        insertSort(arr2);
        System.out.print(" == 삽입 정렬 == \n");
        System.out.println(Arrays.toString(arr2));

        selectSort(arr3);
        System.out.print(" == 선택 정렬 == \n");
        System.out.println(Arrays.toString(arr3));

    }
}