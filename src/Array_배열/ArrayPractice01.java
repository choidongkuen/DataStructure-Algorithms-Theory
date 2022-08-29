package Array_배열;

import java.util.ArrayList;
import java.util.Arrays;

public class ArrayPractice01 {
    public static void main(String[] args) {

        System.out.println("== 1차원 배열 =="); // 1차원 배열
        int[] arr = {1, 2, 3, 4, 5};
        for (int element : arr) {
            System.out.println("element = " + element);
            ;
        }
        arr[1] = 100; // 데이터 수정
        System.out.println("arr = " + Arrays.toString(arr)); // 배열은 바로 출력 불가 - > 문자열로 변경후 출력

        System.out.println("== 2차원 배열 == "); // 2차원 배열
        int[][] arr2 = {{1,2,3},{4,5,6},{7,8,9}};

        for(int[] row: arr2){
            for(int ele: row){
                System.out.println("ele = " + ele);
            }
        }

        System.out.println("== ArrayList == "); // ArrayList

        ArrayList list1 = new ArrayList(Arrays.asList(1,2,3));
        System.out.println("list1 = " + list1);

        list1.add(20);
        list1.add(Math.random() * 100);

        list1.remove(2); // 기본적으로 인덱스 삭제
        list1.remove(Integer.valueOf(2)); // 원소 2 삭제

        System.out.println("list1 = " + list1);

        ArrayList list2d = new ArrayList();
        ArrayList list1d1 = new ArrayList(Arrays.asList(1,2,3));
        ArrayList list1d2 = new ArrayList(Arrays.asList(4,5,6));
        list2d.add(list1d1);list2d.add(list1d2);

        System.out.println("list2d = " + list2d);


    }
}
