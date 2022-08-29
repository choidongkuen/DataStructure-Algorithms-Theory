import java.util.Arrays;

public class Test {
    public static void func(int[] arr){
        for (int i = 0; i < arr.length ; i++) {
            arr[i] += 100;
        }
    }
    public static void main(String[] args){
       int[] arr = {1,2,3,4};
       func(arr);
        System.out.println(Arrays.toString(arr));
    }
}
