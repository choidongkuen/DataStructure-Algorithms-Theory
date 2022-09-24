package Algorithms.SortingBasic_정렬기본;

import java.util.ArrayList;
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

    public static void selectSort(int[] arr){ // 선택 정렬

        for(int i = 0; i < arr.length - 1; i ++){
            int mini = i;

            for(int j = i + 1; j < arr.length; j ++){
                if(arr[j] < arr[mini])
                    mini = j;
            }
            swap(arr,mini,i);
        }
    }


    public static void radixSort(int[] arr, int maxDigit){ // 기수 정렬

        int p = 1;
        for (int pos = 0; pos < maxDigit; pos++) {

            ArrayList<Integer>[] newArr = new ArrayList[10];
            for(int i = 0; i < 10; i++)
                newArr[i] = new ArrayList<>();

            for(int i = 0; i < arr.length ;i ++){

                int digit = (arr[i] / p) % 10;
                newArr[digit].add(arr[i]);
            }
            int idx = 0;

            int[] storeArr = new int[arr.length];

            for(int i = 0; i < 10; i ++){
                for(int j = 0; j < newArr[i].size(); j ++){
                    storeArr[idx ++] = newArr[i].get(j);
                }
            }

            for(int i = 0; i < storeArr.length; i ++)
                arr[i] = storeArr[i];
            p *= 10;

        }
    }
    public static void main(String[] args) {

        int[] arr1 = {3,5,2,7,1,4};
        int[] arr2 = arr1.clone();
        int[] arr3 = arr1.clone(); // 깊은 복사

        int[] arr4 = {10,32,10,27,32,17,99,56};


        bubbleSort(arr1);
        System.out.print(" == 버블 정렬 == \n");
        System.out.println(Arrays.toString(arr1));

        insertSort(arr2);
        System.out.print(" == 삽입 정렬 == \n");
        System.out.println(Arrays.toString(arr2));

        selectSort(arr3);
        System.out.print(" == 선택 정렬 == \n");
        System.out.println(Arrays.toString(arr3));

        radixSort(arr4,2);
        System.out.print(" == 기수 정렬 == \n");
        System.out.println(Arrays.toString(arr4));

    }
}