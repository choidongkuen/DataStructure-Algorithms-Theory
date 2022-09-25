package Algorithms;

import java.util.Arrays;

public class AlgorithmsTest {
    public static void main(String[] args) {
        int[] weights = {1,2,3,4,5,6,7,8,9,10};

        int sum = Arrays.stream(weights).sum();
        int max = Arrays.stream(weights).max().getAsInt();

        System.out.println(sum);
        System.out.println(max);
    }
}
