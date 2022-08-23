// 입력 형식
// 첫 번째 줄에는 n이 주어집니다.
//두 번째 줄부터 n개의 원소값이 공백을 사이에 두고 주어집니다.
//1 ≤ n ≤ 100,000
//1 ≤ 원소 값 ≤ 100,000

package SortingBasic;
import java.util.*;

public class RadixSorting {
    public static final int MAX_N = 100000; // 원소 개수
    public static final int MAX_K = 6; // 각 데이터 최대 크기(6자리)
    public static final int MAX_DIGIT = 10; // 0-9

    public static int n; // 주어지는 원소 개수
    public static int[] arr = new int[MAX_N]; // 정렬할 배열 선언

    public static void radixSort(){ // 기수정렬 함수

        int p = 1;
        for(int pos = 0; pos < MAX_K; pos++){
            ArrayList<Integer>[] arrNew = new ArrayList[MAX_DIGIT]; // 2차원 ArrayList 선언
            for(int i = 0; i < MAX_DIGIT; i++){
                arrNew[i] = new ArrayList<>();
            } // 2차원 ArrayList 초기화

            for(int i = 0; i < n; i++){
                int digit = (arr[i] / p) % 10;
                arrNew[digit].add(arr[i]);
            } // 각 인덱스에 arr 자릿값에 맞게 대입

            int index = 0;
            for(int i = 0; i < MAX_DIGIT; i++)
                for(int j = 0; j < arrNew[i].size(); j++)
                    arr[index++] = arrNew[i].get(j); // 배열 업데이트

            p*=10; // 다음 자릿수 계산을 위함
        }
    }
    public static void main(String[] args) {
        // Your Program Goes Here
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt(); // 원소 개수 입력

        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        } // 배열 원소 생성

        radixSort(); // 함수 호출

        for(int i = 0; i < n; i++){
            System.out.print(arr[i]+" ");
        } // 출력
    }
}