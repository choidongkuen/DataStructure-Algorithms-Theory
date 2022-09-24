import java.util.Arrays;

public class forTest{

    public static void bubbleSort(int[] arr){

    }

    public static void InsertSort(int[] arr){

    }

    public static void SelectSort(int[] arr){

    }
    public static void main(String[] args) {

        int[] arr1 = {3,5,2,7,1,4};

        int[] arr2 = arr1.clone();
        int[] arr3 = arr1.clone(); // 깊은 복사

        arr1[0] = 1;

        System.out.println(Arrays.toString(arr1));
        System.out.println(Arrays.toString(arr2));
        System.out.println(Arrays.toString(arr3));


    }
}