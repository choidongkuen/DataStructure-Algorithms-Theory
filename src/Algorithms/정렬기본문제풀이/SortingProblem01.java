// nums 배열에 3가지 색으로 구분되는 데이터들이 있다.
// 0은 흰색, 1은 파랑, 2는 빨강이라고 할때
// 주어진 nums 배열에서 흰색부터 빨강순으로 인접하게 정렬한 후 출력하는 프로그램을 작성하세요.

// 입출력 예시
// 입력 : 2,0,2,1,1,0
// 출력 : 0,0,1,1,2,2

package Algorithms.정렬기본문제풀이;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

class Solution01{

    public static void solution(int[] arr){ // 계수정렬로 정렬화

        if(arr == null || arr.length == 0){
            return;
        } // 예외 처리

        HashMap<Integer,Integer> hashMap = new HashMap<Integer, Integer>();

        for (int i = 0; i < arr.length ; i++) {
            hashMap.put(arr[i],hashMap.getOrDefault(arr[i],0) + 1);
        } // 해당 색깔의 갯수를 증가

        ArrayList<Integer> arrList = new ArrayList<>(hashMap.keySet());
        Collections.sort(arrList); // 정렬

        int idx = 0;
        for(int i = 0; i < arrList.size(); i ++){

            int cnt = hashMap.get(arrList.get(i));
            while(cnt -- > 0) {
                arr[idx ++] = arrList.get(i);
            }
        }
    }
}

public class SortingProblem01 {
    public static void main(String[] args) {

        Solution01 s = new Solution01();

        int[] arr = {2,0,2,1,1,0};
        s.solution(arr);
        System.out.println(Arrays.toString(arr));

        arr = new int[]{2,0,1};
        s.solution(arr);
        System.out.println(Arrays.toString(arr));
    }
}
