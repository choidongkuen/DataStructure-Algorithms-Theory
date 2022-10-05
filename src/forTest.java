import java.util.Arrays;

public class forTest{
    public static void main(String[] args) {
        int[][] data = {{1,2,3},{3,1,2},{1,1,100}};
        Arrays.sort(data,(x,y) -> x[2] - y[2]);
        System.out.println(Arrays.deepToString(data));
    }
}