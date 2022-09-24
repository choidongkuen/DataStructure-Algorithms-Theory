package DataStructure.Array_배열.ListProblems;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Test{
    public static void main(String[] args){
        int[] arr = {1,2,3,4,5};
        Integer[] IntegerArr = Arrays.stream(arr).boxed().toArray(Integer[] :: new);// primitive type 배열 - > reference type 배열


        // 바꾼 reference type 배열을 List 로 바꿔보기
        ArrayList list = new ArrayList(Arrays.asList(IntegerArr)); // Integer 타입의 원소로 이루어진 ArrayList (첫번째 방법)
        List list2 = Stream.of(IntegerArr).collect(Collectors.toList()); // (두번째 방법)

        System.out.println(list);
        System.out.println(list2);
        System.out.println(Arrays.toString(IntegerArr)); // 배열을 바로 출력

        int[] arr2 = {1,2,3,4,5};
        // reference 로 바꾸면서 동시에 List 변환
        List list3 = Arrays.stream(arr2).boxed().collect(Collectors.toList());
        System.out.println(list3);

        // Collections.reverse(list3); // 컬렉션 프레임 워크 역순
        System.out.println(list3);
    }
}