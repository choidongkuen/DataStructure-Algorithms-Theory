// 정수형 배열 weights 와 정수 days가 주어진다.
// weights 에는 각 상품의 무게들의 정보가 들어있고, days는 운송 납기일이다.
// 상품들은 weights 에 적혀있는 순서대로 실어서 운송해야 하는데,
// days 이내에 운송을 하기 위한 차량의 '최소한의 차량의 적재량'을 계산하는 프로그램을 작성하세요.

// 입출력 예시01
// weights = 1,2,3,4,5,6,7,8,9,10
// days = 5
// 출력 : 15

// 입출력 예시02
// weights = 3,2,2,4,1,4
// days = 3
// 출력 : 6

// 아이디어 :
// 납기일만 지키면서 최소한의 적재량으로 납품하면 된다.
// 예를 들어 입출력 예시01 에서 하나 단위에 제품중 최대값인 10 적재량으로 배송하는 경우는 5일 이상이 걸린다.
// 반면 모든 합입 55의 적재량으로 한번에 실어나르면 1일만에 운송 가능하다. 하지만 이것은 최소한의 차량의 적재량이 아니다.
// 이진 탐색

// -> 특정 적재량이라고 가정했을때, 보낼 수 있으며 정해진 납기일보다 작다면 적재량을 줄여서 다시 test 해보자!

package Algorithms.BinarySearch_이진탐색.이진탐색기본문제풀이;

import java.sql.Array;
import java.util.Arrays;

public class BinarySearchProblem02 {

    public static int solution(int[] weights, int days){

        int left = Arrays.stream(weights).max().getAsInt(); // 배열내 최대값
        int right = Arrays.stream(weights).sum(); // 배열 원소의 총합


        while(left <= right){
            int mid = (left + right) / 2; // mid 적재량이라고 가정
            int countedDays = 1; // mid 적재량이라고 가정했을때, 걸리는 배송일
            int cur = 0; // 현재 무게

            for(int w: weights){
                if(cur + w > mid){ // 가정한 mid 적재량을 벗어난 경우
                    countedDays += 1;
                    cur = 0; // 현재 무게를 0으로
                }
                cur += w;
            }

            if(countedDays > days){
                left = mid + 1; // 더 큰 적재량으로 설정
            }else{
                right = mid - 1; // 더 작은 적재량으로 설정
            }
        }

        return left;
    }
    public static void main(String[] args) {

        int[] weights = {1,2,3,4,5,6,7,8,9,10};
        System.out.println(solution(weights,5)); // 15

        weights = new int[]{3,2,2,4,1,4};
        System.out.println(solution(weights,3)); // 6
    }
}
