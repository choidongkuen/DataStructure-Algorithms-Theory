import java.util.Arrays;
import java.util.Collections;

public class forTest {

    public static void main(String[] args) {
        String str = "pplea";
        char[] arr = str.toCharArray();
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
        String str2 = String.valueOf(arr);
        System.out.println(str2);


    }

}