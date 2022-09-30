// N-Queens 문제 구현해보기
// n = 4

package Algorithms.BackTracking_백트랙킹;

public class NQueens {

    static int n = 4;
    static int[] board = new int[n]; // 원소는 i번째 행의 퀸이 놓이게 될 열의 번호
    static int cnt;

    public static boolean isPromising(int row){

        for (int i = 0; i < row ; i++) {
            if(board[row] == board[i] || row - i == Math.abs(board[row] - board[i]))
                return false;
        } // 같은 열에 놓이거나, 대각선위치에 놓이게 되면 false

        return true;
    }
    public static int nQueen(int row){

        if(row == n){
            cnt ++; // 끝까지 도달한 경우 경우의 수 증가
            for(int i = 0; i < n; i ++) {
                System.out.print(board[i] + " ");
            }
            System.out.println();
            return cnt;
        }
        for (int i = 0; i < n ; i++) {
            board[row] = i;

            // promising(유망) 검사
            if(isPromising(row))
                nQueen(row + 1); // 다음 행에 놓일 퀸 구하는 함수 재귀적 호출
        }

        return cnt;
    }

    public static void main(String[] args) {
        System.out.println("경우의 수 : " + nQueen(0)); // 2
    }
}
