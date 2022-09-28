// 주어진 nums 배열에서 3 개의 합이 0이 되는 모든 숫자들을 출력하세요.
// 중복된 숫자 set은 제외하고 출력

// 입출력 얘시
// nums : {-1,0,1,2,-1,-4};
// 출력 : [[-1,-1,2],[-1,0,1]]

// nums : {1,-7,6,3,5,2}
// 출력 : [[-7,1,6],[-7,2,5]]

package Algorithms.TwoPointer_투포인터.투포인터문제풀이;
import java.util.ArrayList;
import java.util.Arrays;

public class TwoPointerProblem04 {

    public static ArrayList<ArrayList<Integer>> solution(int[] nums) {

        if (nums == null || nums.length < 3)
            return null;

        Arrays.sort(nums); // 오름 차순 정렬

        int length = nums.length;
        ArrayList<ArrayList<Integer>> arrList = new ArrayList<>();

        for (int i = 0; i < length - 2; i++) {
            if (i == 0 || i > 0 && nums[i] != nums[i - 1]) {

                int p1 = i + 1;
                int p2 = length - 1;
                int value = 0 - nums[i];

                while (p1 < p2) {
                    if (nums[p1] + nums[p2] == value) {
                        arrList.add(new ArrayList<>(Arrays.asList(nums[i],nums[p1],nums[p2])));

                        while (p1 < p2 && nums[p1] == nums[p1 + 1]) {
                            p1++;
                        }

                        while (p1 < p2 && nums[p2] == nums[p2 - 1]) {
                            p2--;
                        }

                        p1++;
                        p2--;
                    } else if (nums[p1] + nums[p2] < value) {
                        p1++;
                    } else {
                        p2--;
                    }
                }
            }
        }
        return arrList;
    }

    public static void main(String[] args) {

        int[] nums = {-1,0,1,2,-1,4};
        System.out.println(solution(nums));

        nums = new int[]{1,-7,6,3,5,2};
        System.out.println(solution(nums));

        nums = new int[]{0,0,0,0,0};
        System.out.println(solution(nums));
    }
}
