// 문제 설명 :
// 10000 개의 원소가 랜덤하게 주어질 때, 순차 탐색과 이진 탐색의 수행 속도를 출력해라
// 0 <= 값 <= 1000

package Algorithms.BinarySearch_이진탐색;

import java.util.Scanner;

public class SearchTest {
    public static final int MAX = 1000000000; // 원소의 최대 개수(10억)
    public static final int MAX_V = 10000; // 원소의 최대 값
    public static int[] arr = new int[MAX + 1];
    public static int target;

    public static void binarySearch() {

        long start = 0, end = 0; // 메서드 내의 지역변수는 초기화 필수
        int ind = 0; // 존재하는 경우의 인덱스

        start = System.currentTimeMillis();
        boolean find = false;

        int left = 0, right = MAX;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (arr[mid] == target) {
                end = System.currentTimeMillis();
                find = true;
                ind = mid;
                break;
            }
            if(arr[mid] > target){
                right = mid - 1;
            }
            else{
                left = mid + 1;
            }
        }
        if (!find) {
            System.out.println("찾으시는 원소가 없습니다.");
            System.exit(0);
        }
        System.out.println("찾으시는 값의 위치는 " + ind + " 입니다.");
        System.out.println("수행시간: " + (end - start) + " ms");
    }

    public static void sequentialSearch() {
        long start = 0, end = 0; // 메서드 내의 지역변수는 초기화 필수
        int ind = 0; // 존재하는 경우의 인덱스

        start = System.currentTimeMillis(); // 시작 시간
        boolean find = false; // 찾았는지 여부 판단

        for (int i = 0; i <= MAX; i++) {
            if (arr[i] == target) {
                end = System.currentTimeMillis();
                find = true;
                ind = i;
                break;
            }
        }
        if (!find) {
            System.out.println("찾으시는 원소가 없습니다.");

        }
        else {
            System.out.println("찾으시는 값의 위치는 " + ind + " 입니다.");
            System.out.println("수행시간: " + (end - start) + " ms");

            System.out.println("============================");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        arr[0] = 0;

        for (int i = 1; i <= MAX; i++) {
            arr[i] = arr[i - 1] + 1;
        }

        System.out.print("찾으시는 값을 입력해주세요: ");
        target = sc.nextInt(); // 찾고자 하는 목표값 입력

        sequentialSearch(); // 순차 탐색 메서드 호출
        binarySearch(); // 이진 탐색 메서드 호출
    }
}
