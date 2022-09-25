// 정수 배열 nums 가 주어졌을 때
// 오름차순으로 정렬하기 위해 배열 내에서 정렬이 필요한 구간의 길이를 출력하는 프로그램을 작성하세요

// 입출력 예시
// 입력 : 2,6,4,8,5,3,9,10
// 출력 : 5

// 입력 : 1,3,1
// 출력 : 2

package Algorithms.정렬기본문제풀이;


class Solution04{
    public static int solution(int[] arr){

        if(arr == null || arr.length < 2){
            return 0;
        }

        int firstIndex = 0;
        int min = Integer.MAX_VALUE;

        for(int i = arr.length - 1; i >= 0; i --){
            min = Math.min(arr[i], min);

            if(arr[i] > min){
                firstIndex = i; // 최소값 기준 좌측 인덱스의 값중 최소값보다 큰 값이 있다면 firstIndex 업데이트
            }
        }

        int lastIndex = -1;
        int max = Integer.MIN_VALUE;

        for(int i = 0; i < arr.length ; i ++){
            max = Math.max(arr[i] , max);

            if(arr[i] < max)
                lastIndex = i;
        }

        return lastIndex - firstIndex + 1;
    }
}
public class SortingProblem04 {
    public static void main(String[] args) {

        Solution04 s = new Solution04();
        int[] nums = {2,6,4,8,5,3,9,10};
        System.out.println(s.solution(nums));

        nums = new int[]{1,3,1};
        System.out.println(s.solution(nums));
    }
}
