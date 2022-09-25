// 정수형 배열 nums 와 정수 m 이 주어진다.
// nums 에는 양의 정수 값들이 들어 있고, m 은 배열을 부분 배열로 분리 할 수 있는 수이다.
// nums 배열을 m개의 부분 배열로 분리할 때,
// 각 부분 배열의 합중 가장 큰 값이 최소가 되도록 분리했을 때의 합을 출력하세요.

// 입출력 예시 :
// nums : 7,2,5,10,8
// m : 2
// 출력 : 18

// nums : 1,2,3,4,5
// m : 2
// 출력 : 9

// 합중 최대 값의 최소의 범위는 각각 원소의 최대값 ~ 원소의 총합
// Problem02와 비슷하다.


package Algorithms.BinarySearch_이진탐색.이진탐색기본문제풀이;

import java.util.Arrays;

public class BinarySearchProblem05 {

    public static int solution(int[] nums, int m){

        int left = Arrays.stream(nums).max().getAsInt(); // 원소중 최대값
        int right = Arrays.stream(nums).sum(); // 원소의 총합

        if(m == 1)
            return right;

        while(left <= right){

            int mid = left + (right - left) / 2;
            int cnt = 1; // mid 라고 최대합을 설정했을 때, 몇개로 나눠지는 지 카운팅 하는 변수
            int total = 0; // 합

            for(int element : nums) {
                total += element;
                if (total > mid) {
                    total = element;
                    cnt++;
                }
            }
            if(cnt <= m){ // m보다 같거나 더 적은 배열로 쪼개지는 경우
                right = mid - 1;
            }else{
                left = mid + 1;
            } // m보다 더 많은 배열로 쪼개지는 경우(최대 합의 범위를 증가시키면 ok)
        }
        return left;
    }

    public static void main(String[] args) {

        int[] nums = {7,2,5,10,8};
        System.out.println(solution(nums,2)); // 18

        nums = new int[]{1,2,3,4,5};
        System.out.println(solution(nums,2)); // 9

        nums = new int[]{1,4,4};
        System.out.println(solution(nums,3)); // 4
    }
}
