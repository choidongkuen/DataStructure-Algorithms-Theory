// nums1과 nums2 두 배열이 주어질 때
// 두 배열의 공통 원소를 배열로 반환하는 프로그램을 작성하시오.
// 결과 배열의 원소에는 중복 값이 없도록 하며, 순서는 상관 없다.

// 입출력 예시
// nums1 : 1 , 2 , 2 ,1
// nums2 : 2, 2
// 출력 : 2

// nums1 : 4, 9, 5
// nums2 : 9 ,4, 9, 8, 4
// 출력 : 4, 9

package Algorithms.TwoPointer_투포인터.투포인터문제풀이;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class TwoPointerProblem02 {

    public static int[] solution01(int[] nums1, int[] nums2){ // 내가 푼 방식

        Set<Integer> set1 = Arrays.stream(nums1).boxed().collect(Collectors.toSet());
        Set<Integer> set2 = Arrays.stream(nums2).boxed().collect(Collectors.toSet()); // 각 배열의 중복을 제거하기 위해 set으로 변환

        ArrayList<Integer> result = new ArrayList<>(); // 동일한 원소가 담길 배열리스트

        for(Integer x : set1){
            if(set2.contains(x))
                result.add(x);
        } // 동일한 원소 추가

        Integer[] resultArr = result.toArray(new Integer[0]);

        int idx = 0;
        int[] getResult = new int[resultArr.length];
        for(Integer ele : resultArr)
            getResult[idx ++] = ele;

        return getResult;
    }
    public static int[] solution02(int[] nums1, int[] nums2){ // 투 포인터를 이용한 방식

        HashSet<Integer> hashSet = new HashSet<>();

        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int p1 = 0, p2 = 0; // 각 배열의 포인터

        while(p1 < nums1.length && p2 < nums2.length){

            if(nums1[p1] == nums2[p2]) {
                hashSet.add(nums1[p1]);
                p1 ++;
                p2 ++;
            }else if(nums1[p1] < nums2[p2]){
                p1 ++;
            }else{
                p2 ++;
            }
        }

        int idx = 0;
        int[] result = new int[hashSet.size()];

        for(Integer x: hashSet)
            result[idx ++] = x;

        return result;
    }
    public static void main(String[] args) {

        System.out.println(" == 내가 정한 기법 == ");

        int[] num1 = {1,2,2,1};
        int[] num2 = {2,2};
        System.out.println(Arrays.toString(solution01(num1,num2)));

        num1 = new int[]{4,9,5};
        num2 = new int[]{9,4,9,8,4};
        System.out.println(Arrays.toString(solution01(num1,num2)));

        num1 = new int[]{1,7,4,9};
        num2 = new int[]{7,9};
        System.out.println(Arrays.toString(solution01(num1,num2)));


        System.out.println(" == 투포인터 기법 == ");

        num1 = new int[]{1,2,2,1};
        num2 = new int[]{2,2};
        System.out.println(Arrays.toString(solution02(num1,num2)));

        num1 = new int[]{4,9,5};
        num2 = new int[]{9,4,9,8,4};
        System.out.println(Arrays.toString(solution02(num1,num2)));

        num1 = new int[]{1,7,4,9};
        num2 = new int[]{7,9};
        System.out.println(Arrays.toString(solution02(num1,num2)));
    }
}
