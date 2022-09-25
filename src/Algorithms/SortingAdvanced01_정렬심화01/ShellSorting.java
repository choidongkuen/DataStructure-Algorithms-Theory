package Algorithms.SortingAdvanced01_정렬심화01;

import java.util.Arrays;

public class ShellSorting {
    public static void shellSorting(int[] arr){
        int gap = arr.length / 2;

        for(int g = gap; g > 0; g --)
            for(int i = g; i < arr.length; i ++){
                int tmp = arr[i];

                int j = 0;
                for(j = i - g; j >= 0; j -= g){
                    if(arr[j] > tmp){
                        arr[j + g] = arr[j];
                    }else{
                        break;
                    }
                }
                arr[j + g] = tmp;
            }
    }
    public static void main(String[] args) {

        int[] arr = {10,32,52,27,48,17,99,56};
        shellSorting(arr);
        System.out.println(Arrays.toString(arr));
    }
}
