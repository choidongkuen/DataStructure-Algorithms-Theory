import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class Test {
    public static void func(String s, String t){
        char[] sArray = s.toCharArray();
        char[] tArray = t.toCharArray();
        Arrays.sort(sArray);
        Arrays.sort(tArray);
        boolean is = true;
//        System.out.println(Arrays.toString(sArray));
//        System.out.println(Arrays.toString(tArray));

        for(int i = 0; i < sArray.length; i++){
            if (sArray[i] != tArray[i]){
                is = false;
                break;
            }
        }
        System.out.println(is);
    }
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        String t = sc.next();
        func(s,t);
    }
}
