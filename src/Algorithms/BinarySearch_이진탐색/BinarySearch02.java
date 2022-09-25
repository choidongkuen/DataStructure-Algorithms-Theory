package Algorithms.BinarySearch_이진탐색;

import java.util.Arrays;

class Solution{

    public int binarySearch01(int[] arr, int target){

        int left = 0;
        int right = arr.length - 1;

        while(left <= right){
            int mid = (left + right) / 2;

            if(arr[mid] == target)
                return mid;
            else if(arr[mid] < target){
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }
        return -1;

    } // 반복문으로 구현

    public int binarySearch02(int[] arr, int target,int left, int right){

        if(left > right){
            return - 1; // 값이 존재하지 않는 것
        }

        int mid = (left + right) / 2;

        if(target == arr[mid]) {
            return mid;
        }else if(target < arr[mid]){
            return binarySearch02(arr,target,left,mid - 1);
        }else{ // target > arr[mid]
            return binarySearch02(arr,target,mid + 1,right);
        }
    } // 재귀적 구현
}


public class BinarySearch02 {
    public static void main(String[] args) {

        int[] arr = {1,2,5,10,20,30,40,50,60}; // 정렬된 상태
        Solution s = new Solution();

        System.out.println(" == 반복문 == ");
        System.out.println(s.binarySearch01(arr,30));

        System.out.println(" == 재귀 호출 == ");
        System.out.println(s.binarySearch02(arr,30,0,arr.length - 1));

        System.out.println(" == 자바의 Arrays.binarySearch == ");
        System.out.println(Arrays.binarySearch(arr,30));
        System.out.println(Arrays.binarySearch(arr,3));
        System.out.println(Arrays.binarySearch(arr,11));
        // Arrays.binarySearch 할때, 만약 존재하지 않는다면, - ( 있어야 할 위치 + 1 ) 로 반환

    }
}
