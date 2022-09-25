// 이진 탐색 추가 구현
// target 값이 arr내에 있으면 해당 인덱스 반환
// 없으면 해당 값이 있을 경우의 위치에 -1 을 곱하고 1을 뺀 값을 반환

// 입출력 예시
// 입력 arr : 1,2,5,10,20,30,40,50,60

// target : 30
// 5

// target : 3
// 출력 : -3 ( 실제 있다면 2인덱스 자리에 있었을 것임)


package Algorithms.BinarySearch_이진탐색.이진탐색기본문제풀이;

import java.util.Arrays;

public class BinarySearchProblem01 {
    public static int solution(int[] arr, int target) {

        if (arr == null || arr.length == 0)
            return -1;
        // 예외 처리

        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {

            int mid = (left + right) / 2;
            if (arr[mid] == target)
                return mid;
            else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -left - 1;
    }

    public static void main(String[] args) {

        int[] arr = {1, 2, 5, 10, 20, 30, 40, 50, 60};
        System.out.println(solution(arr, 30));
        System.out.println(solution(arr, 3));
    }
}