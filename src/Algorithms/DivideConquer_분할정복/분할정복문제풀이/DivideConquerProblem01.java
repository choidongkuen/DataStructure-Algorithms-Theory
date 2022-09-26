// 정수형 배열 nums가 주어진다.
// '연속된 부분 배열의 합' 중 가장 큰 값을 출력하세요.

// 입출력 예시
// nums : -5,0,-3,4,-1,3,1,-5,8
// 출력 : 10

// nums : 5 4 0 7 8
// 출력 : 24

// 아이디어 :
// 투포인터 ? - > 조건문이 너무 복잡
//

package Algorithms.DivideConquer_분할정복.분할정복문제풀이;

public class DivideConquerProblem01 {

    public static int solution(int[] nums){
        if(nums == null || nums.length < 1)
            return 0;

        return divide(nums,0,nums.length - 1);

    }

    public static int divide(int[] nums, int left, int right){
        if(left == right)
            return nums[left];

        int mid = left + (right - left) / 2; // overflow 방지
        int maxLeft = divide(nums, left, mid);
        int maxRight = divide(nums, mid + 1,right);
        // divide 완료

        int maxArr = getMaxSubArray(nums,left,mid,right); // conquer

        return Math.max(maxLeft,Math.max(maxRight,maxArr));
    }

    public static int getMaxSubArray(int[] nums, int left, int mid, int right){

        int sumLeft = 0;
        int maxLeft = Integer.MIN_VALUE;

        for (int i = mid; i >= left ; i--) {
            sumLeft += nums[i];
            maxLeft = Math.max(maxLeft,sumLeft);
        } // 좌측에서의 부분 배열의 합의 max 값

        int sumRight = 0;
        int maxRight = Integer.MIN_VALUE;

        for(int i = mid + 1; i <= right; i++){
            sumRight += nums[i];
            maxRight = Math.max(maxRight,sumRight);
        } // 우측에서의 부분 배열의 합의 max 값

        return maxLeft + maxRight;
    }

    public static void main(String[] args) {
        int[] nums = {-5,0,-3,4,-1,3,1,-5,8};
        System.out.println(solution(nums));

        nums = new int[]{5,4,0,7,8};
        System.out.println(solution(nums));

    }
}
