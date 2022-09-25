// 문자열 배열 str이 주어질때, 애너그램 으로 묶어서 출력하는 프로그램을 작성하세요.
// 애너그램이란 철자 순서를 바꾸면 같아지는 문자를 의미한다.

// 입출력 예시
// 입력 : "eat" , "tea" , "tan", "ate" , "nat" , "bat"
// 출력 : [[eat,tea,ate],[bat],[tan,nat]]

package Algorithms.SortingBasic_정렬기본.정렬기본문제풀이;

import java.util.ArrayList;
import java.util.HashMap;

class Solution02{
    public static void sorting(char[] arr){

        for(int i = 1; i < arr.length; i ++){
            for(int j = i ; j > 0; j--){
                if(arr[j] < arr[j - 1]){
                    char temp = arr[j - 1];
                    arr[j - 1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }

    public static ArrayList<ArrayList<String>> solution(String[] arr){

        if(arr == null || arr.length == 0)
            return null;

        HashMap<String,ArrayList<String>> hashMap = new HashMap<>(); // !!

        for(String s : arr){
            char[] charArr = s.toCharArray(); // 문자 배열로 변경
            // sort
            sorting(charArr);
            String key = String.valueOf(charArr); // key가 되는 정렬된 s 문자열
            // String key = new String(charArr); //


            if(!hashMap.containsKey(key)){ // 해시맵에 존재하지 않는 다면
                hashMap.put(key,new ArrayList<>());
            }
            hashMap.get(key).add(s);
        }
        return new ArrayList<>(hashMap.values());
    }
}

public class SortingProblem02 {
    public static void main(String[] args) {

        Solution02 s = new Solution02();
        String[] arr1 = {"eat", "tea","tan","ate","nat","bat"};
        System.out.println(s.solution(arr1));


        arr1 = new String[]{"abc","bac","bca","xyz","zyx","aaa"};
        System.out.println(s.solution(arr1));

    }
}
