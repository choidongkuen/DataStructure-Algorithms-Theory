// 정수형 nums 배열이 주어진다.
// 각 원소의 값은 해당 위치에서 오른쪽으로 이동 가능한 최대 값이다.
// 첫 번째 위치에서 시작해서 가장 끝까지 이동이 가능한지 판별하는 프로그램을 작성하시오.
// 이동이 가능하면 true, 불가능하면 false 출력

// 입출력 예시
// nums : 2,3,0,1,4
// 출력 : true

// nums : 3,2,1,0,4
// 출력 : false

// nuns : 3,0,0,1,1
// 출력 : true

// 아이디어 :
// i번째 위치에서 도달 할 수 있는 지점 : i + nums[i]
// i번째 위치에 있다고 할 때, 갈 수 있는 거리 => i + nums[i]
// 만약 i번째 도달 못한다면 false

package Algorithms.Greedy_그리디.그리디알고리즘문제풀이;

public class GreedyProblem01 {

    public static boolean solution(int[] nums){

        int maxPos = 0;
        for (int i = 0; i < nums.length ; i++) {

            if(i > maxPos) { // i번째 위치까지 도달 할 수 없다.
                return false;
            }else if(maxPos >= nums.length - 1) { // 이전의 존재했던 원소들로는 i번째 까지 도달 할 수 없다.
                return true;
            }
            maxPos = Math.max(maxPos, nums[i] + i); // 갈 수 있는 최대위치 업데이트
        }
        return false;
    }
    public static void main(String[] args) {

        int[] nums = {2,3,0,1,4};
        System.out.println(solution(nums)); // true

        nums = new int[]{3,0,0,1,1};
        System.out.println(solution(nums)); // true

        nums = new int[]{3,2,1,0,4};
        System.out.println(solution(nums)); // false
    }
}
