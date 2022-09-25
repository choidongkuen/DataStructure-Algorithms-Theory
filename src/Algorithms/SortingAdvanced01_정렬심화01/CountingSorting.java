// 숫자 끼리 비교하지 않고 카운트를 세서 정렬하는 방식
// 카운팅을 위한 메모리 필요 -> in-place x
// O(n + k)

package Algorithms.SortingAdvanced01_정렬심화01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

public class CountingSorting{

    public static void countingSorting02(int[] arr){

        int max = Arrays.stream(arr).max().getAsInt();
        HashMap<Integer,Integer> map = new HashMap<>();

        for (int i = 0; i < arr.length ; i++) {
            map.put(arr[i],map.getOrDefault(arr[i],0) + 1);
        } // 해시맵에 기록

        ArrayList<Integer> arrList = new ArrayList<>(map.keySet()); // keyset으로 배열리스트 생성
        Collections.sort(arrList); // set으로 배열리스트를 생성했기 때문

        int idx = 0;
        for(Integer ele : arrList){
            int cnt = map.get(ele);

            while(cnt > 0){
                arr[idx++] = ele;
                cnt --;
            }
        }
    }

    public static void countingSorting01(int[] arr){

        int max = Arrays.stream(arr).max().getAsInt(); // 배열에서 최대값
        int[] cntArr = new int[max + 1];

        for(int i = 0; i < arr.length; i ++)
            cntArr[arr[i]] ++;

        int idx = 0;
        for(int i = 0; i < cntArr.length; i++){
            while(cntArr[i] > 0){
                arr[idx ++] = i;
                cntArr[i] -= 1;
            }
        }
    }
    // countingSorting01에서의 문제점 : 배열의 원소 갯수에 비해 최대값이 월등히 커지면 비효율적
    public static void main(String[] args) {
        int[] arr1 = {10,32,10,27,32,17,99,56};
        int[] arr2 = arr1.clone();

        System.out.println(" == 계수 정렬 == ");
        countingSorting01(arr1);
        System.out.println(Arrays.toString(arr1));

        countingSorting02(arr2);
        System.out.println(Arrays.toString(arr2));

    }
}
