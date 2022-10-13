// 날짜 : 2022/10/02
// 문제 : 앞에서부터 삭제하기2

// 문제 설명 :
// N개의 정수들이 있습니다. "이 중 정확히 앞에서부터 K개를 삭제하고 난 후", 남아있는 정수 중 가장 작은 숫자 하나를 제외한 평균을 구한다 했을 때
// 이 평균값이 최대가 될 때의 값을 구하는 프로그램을 작성해보세요. 단, K는 1이상 N - 2 이하까지만 고려하도록 합니다.

// 입력 예시 01 :
// 5
// 3 1 9 2 7

// 출력 예시 01 :
// 8.00


// 아이디어 :
// 이 문제는 k개를 선택하는 것이 까다롭다.
// 일반적인 2중 loop를 통해 k를 선택해서 값을 구하려 한다면 시간복잡도가 O(n^2) 가 되며 이는 100초가 걸린다.
// 따라서 뒤에서부터 값을 선택해주자. -- > ( 뒤에 값부터 우선순위 큐에 넣어주면 큐의 값을 유지할 수 있다.)
// 시간복잡도 : O(NlogN) # 값을 하나씩 추가 할때마다 O(logN) X O(N)

package DataStructure.PriortyQueue_힙.힙문제풀이;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class HeapProblem09 {

    public static final int MAX_N = 100000;
    public static int n;
    public static PriorityQueue<Integer> pq = new PriorityQueue<>();
    public static int[] arr = new int[MAX_N];
    public static double maxAvg = Double.MIN_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        for (int i = 0; i < n ; i++) {
            arr[i] = sc.nextInt();
        }

        pq.add(arr[n - 1]);
        int sumVal = arr[n - 1];

        for (int i = n -2 ; i >= 1 ; i --) {
            pq.add(arr[i]);
            sumVal += arr[i];

            double avg = (double)(sumVal - pq.peek()) / (pq.size() - 1);
            maxAvg = Math.max(maxAvg,avg);
        }

        System.out.printf("%.2f",maxAvg);
    }
}