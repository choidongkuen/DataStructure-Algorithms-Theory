// 인덱스 : 시간 , 원소 : 이동 거리
import java.util.*;

public class forTest {
    public static final int MAX = 1000000;
    public static int[] arrA = new int[MAX + 1];
    public static int[] arrB = new int[MAX + 1];

    public static void main(String[] args) {
        // Your Program Goes Here
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // arrA의 명령어 개수
        int m = sc.nextInt(); // arrB의 명령어 개수

        int aInd = 1;
        for(int i = 0; i < n; i++){
            int v = sc.nextInt(); // 시간단위 속도
            int t = sc.nextInt(); // 이동 시간

            for(int j = 0; j < t; j++){ // 주어진 시간 동안
                arrA[aInd] = arrA[aInd - 1] + v; // 원소 = 이동 거리
                aInd ++;
            }
        }

        int bInd = 1;
        for(int i = 0; i < m; i++){
            int v = sc.nextInt();
            int t = sc.nextInt();

            for(int j = 0; j < t; j++){
                arrB[bInd] = arrB[bInd - 1] + v;
                bInd++;
            }
        }
        int ans = 0; // 선두 바뀐 횟수
        int winner = (arrA[1] < arrB[1])? 1 : 0; // A 가 선두 : 0 , B 가 선두 : 1

        for(int i = 1; i <= aInd; i++){
            if(arrA[i] < arrB[i] && winner == 0){
                ans++;
                winner = 1;
            }else if(arrA[i] > arrB[i] && winner == 1){
                ans++;
                winner = 0;
            }

        }
        System.out.println(ans);
        System.out.println(aInd);
        System.out.println(bInd);
    }
}