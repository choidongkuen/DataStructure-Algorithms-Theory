// 입력 형식
// 첫 번째 줄에는 n이 주어집니다.
//두 번째 줄부터 n개의 원소값이 공백을 사이에 두고 주어집니다.
//1 ≤ n ≤ 100,000
//1 ≤ 원소 값 ≤ 100,000

package SortingAdvanced;

import java.util.Scanner;

public class QuickSorting {
    public static final int MAX_N = 100000; // 원소 최대 개수

    public static int n; // 원소 개수
    public static int[] arr = new int[MAX_N]; // 배열 선언
    public static int[] mergedArr = new int[MAX_N]; // mergedArr 배열 선언

    public static int partition(int low, int high) {
        int pivot = arr[high];              // pivot을 고름
        int i = low - 1;                    // 파란색 화살표 위치를 정해줌
        // 파란색 화살표는 pivot 보다 같거나 큰
        // 원소를 가리키고 있다.
        for(int j = low; j < high; j++)     // 빨간색 화살표를 움직인다.
            if(arr[j] < pivot) {            // 빨간색 화살표가 가리키는 원소가
                i++;                        // pivot 보다 작다면, 왼쪽으로 가야하므로
                int temp = arr[i];          // 두 원소의 위치를 바꿔준다.
                arr[i] = arr[j];
                arr[j] = temp;
            }

        int temp = arr[i + 1];              // 최종적으로 pivot 을
        arr[i + 1] = arr[high];             // 경계에 있는 원소와 교환해준다.
        arr[high] = temp;                   // 이때 경계는 마지막 파란색 화살표 위치에
        // 1을 더한 위치입니다.
        return i + 1;                       // pivot 의 최종 위치를 반환해준다.
    }

    public static void quickSort(int low, int high) {
        if(low < high) {                    // 원소의 개수가 2개 이상인 경우에만 진행
            int pos = partition(low, high); // pivot 기준으로 좌우로 분할 한 후
            // 해당 pivot의 위치를 pos에 넣어준다.
            quickSort(low, pos - 1);        // pivot의 왼쪽 구간에 있는 원소들을 정렬한다.
            quickSort(pos + 1, high);       // pivot의 오른쪽 구간에 있는 원소들을 정렬한다.
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 입력
        n = sc.nextInt();
        for(int i = 0; i < n; i++)
            arr[i] = sc.nextInt();

        quickSort(0, n - 1);

        for(int i = 0; i < n; i++)
            System.out.print(arr[i] + " ");
    }
}