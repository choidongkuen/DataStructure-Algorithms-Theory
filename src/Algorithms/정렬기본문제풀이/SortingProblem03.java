// intervals 라는 구간으로 이루어진 배열이 주어질때,
// 오버랩이 되는 구간을 합치는 프로그램을 작성하시오.
// 합친 구간은 오름차순 출력

// 입출력 예시
// 입력 : [2,6],[1,3],[15,18],[8,10]
// 출력 : [1,6],[8,10],[15,18]


package Algorithms.정렬기본문제풀이;

import java.util.ArrayList;
import java.util.Arrays;

class Solution03{
    public static void swap(int[][] arr, int i, int j){
        int[] temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static int partition(int[][] arr,int left, int right){
        int pivot = arr[left][0]; // 맨 왼쪽 값 pivot
        int i = left;
        int j = right;

        while(i < j){
            while(arr[j][0] > pivot && i < j)
                j --;
            while(arr[i][0] <= pivot && i < j)
                i ++;

            swap(arr,i,j);
        }
        swap(arr,left,i);

        return i;
    }
    public static void quickSort(int[][] arr,int left, int right){

        if(left < right){
            int pos = partition(arr,left,right);
            quickSort(arr,left,pos - 1);
            quickSort(arr,pos + 1, right);
        }
    }
    public static void sort(int[][] arr){
        quickSort(arr,0,arr.length - 1);
    }

    public ArrayList<int[]> solution(int[][] intervals){

        if(intervals == null || intervals.length < 2)
            return null; // 예외 처리

        sort(intervals);
        ArrayList<int[]> result = new ArrayList<>();
        int[] curInterval = intervals[0];
        result.add(curInterval);

        for (int i = 1; i < intervals.length; i++) {
            if(curInterval[1] >= intervals[i][0]){
                curInterval[1] = intervals[i][1];
            }else{
                curInterval = intervals[i];
                result.add(curInterval);
            }
        }
        return result;
    }
}

public class SortingProblem03 {
    public static void main(String[] args) {
        int[][] intervals = {{2,6},{1,3},{15,18},{8,10}};
        Solution03 s = new Solution03();

        for(int[] item : s.solution(intervals)) // 컬렉션과 배열이 섞여있는 경우는 반복문으로 출력하자
            System.out.print(Arrays.toString(item) + " ");
        System.out.println();
    }
}

