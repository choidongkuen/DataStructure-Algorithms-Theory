// 구간합이 m이 되는 구간을 출력하는 프로그램을 작성하세요.

// 단순 반복문(완전 탐색) : O(N^2)
// 투포인터 : O(2*N) -> O(N)

package Algorithms.TwoPointer_투포인터;


import java.util.Arrays;

public class TwoPointer01 {

    public static int[] solution01(int[] arr, int target){

        if(arr == null || arr.length == 0)
            return new int[]{-1,-1};

        for (int i = 0; i < arr.length ; i++) {
            int partSum = arr[i];

            for (int j = i + 1; j < arr.length ; j++) {
                partSum += arr[j];
                if (partSum == target) {
                    return new int[]{i, j};
                }
            }
        }

        return new int[]{-1,-1}; // 못찾은 경우
    }
    public static int[] solution02(int[] arr, int target){

        int[] result = {-1,-1};

        if(arr == null || arr.length == 0)
            return result;

        int left = 0;
        int right = 0;
        int partSum = 0;

        while(true) {

            if (partSum > target) {
                partSum -= arr[left ++];
            } else if (right == arr.length) {
                break;
            } else { // partSum < target
                partSum += arr[right ++];
            }

            if (partSum == target) {
                result[0] = left;
                result[1] = right - 1;
                break;
            }
        }
        return result;
    }
    public static void main(String[] args) {

        int[] arr = {1,2,5,3,7,2,4,3,2};

        System.out.println(" == for loop == ");
        System.out.println(Arrays.toString(solution01(arr,9)));
        System.out.println(Arrays.toString(solution01(arr,14)));
        System.out.println();

        System.out.println(Arrays.toString(solution02(arr,9)));
        System.out.println(Arrays.toString(solution02(arr,14)));
    }
}
