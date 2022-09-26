package Algorithms;

import java.util.Arrays;

public class AlgorithmsTest {

    public static char[] reverseArr(char[] arr){

        char[] result = new char[arr.length];

        for (int i = arr.length - 1; i >=0 ; i-- ) {
            result[arr.length - 1 - i] = arr[i];
        }

        return result;
    }
    public static void main(String[] args) {

        String s = "  hello   java   ";
        s = s.trim();
        char[] arr = s.toCharArray();

        arr = reverseArr(arr);
        System.out.println(Arrays.toString(arr));
    }
}
