// 문제 설명 :
// n개의 원소를 지닌 배열과 탐색하기를 원하는 target 이 주어질 때, target 의 위치를 이진탐색을 이용해서 찾아보자.
// 존재하지 않은 경우 -1 출력

// 1 <= n <= 1000
// 0 <= target <= 1000
package Algorithms.BinarySearch_이진탐색;
import java.util.Scanner;

public class BinarySearch01 {
    public static final int MAX = 1000; // 원소의 최대 개수
    public static int[] arr = new int[MAX]; // 탐색할 배열
    public static int n,target;

    public static int binarySearch(int left,int right){
        while(left <= right){
            int mid = (left + right) / 2;

            if(arr[mid] == target)
                return mid; // target 과 일치하는 경우
            if(arr[mid] < target)
                left = mid + 1;
            else
                right = mid - 1;
        }
        return -1;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("원소 개수 입력: ");
        n = sc.nextInt();

        System.out.print("원소 입력: ");
        for (int i = 0; i < n ; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.print("찾으시는 값은 무엇입니까?: ");
        target = sc.nextInt();

        int result = binarySearch(0,n-1);
        if(result == -1) {
            System.out.println("찾으시는 값이 없습니다.");
            System.exit(0);
        }
        System.out.println("찾으시는 인덱스는 " + result+" 입니다.");
    }
}
