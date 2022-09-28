// 2 차원 배열 board 가 주어진다.
// 해당 배열 데이터에는 'o','#','.' 의 정보가 기입되어 있다.

// 'o' : 동전을 의미
// '#' : 벽을 의미
// '.' : 빈칸을 의미

// 동전은 항상 2개가 주어진다.
// 두 동전이 함께 이동하다가 하나가 보드에서 떨어지는 최소 이동 횟수를 출력하는 프로그램을 작성하세요.
// 단, 이동 규칙은 다음과 같다.

    // 동전은 좌,우,위,아래로 이동 가능하며 같은 방향으로 함께 이동
    // 빈칸이나 동전이 있는 곳으로 이동 가능
    // 벽일 때는 이동 불가
    // 이동 횟수가 10번을 넘으면 중지하고 -1 반환

// 입출력 예시
// board : {{'.','#'}, {'.','#'}, {'.','#'} ,{'o','#'} ,{'o','#'} ,{'#','#'}}
// 결과 : 4


package Algorithms.BackTracking_백트랙킹.백트랙킹문제풀이;

import java.util.ArrayList;

public class BackTrackingProblem04 {

    static class Coin{
        int x;
        int y;

        public Coin(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    public static final int DIR_NUM = 4; // 동서남북

    public static int[] dx = {1,-1,0,0};
    public static int[] dy = {0,0,-1,0}; // 상하좌우
    public static int cnt; // 최소 이동 횟수
    public static int n,m; // 행렬 크기

    public static boolean checkRange(int row, int col){
        return row >= 0 && row < n && col >= 0 && col < m;
    }

    public static void backTracking(char[][] board, int x1, int y1, int x2, int y2, int moveCnt){
        if(moveCnt >= 10){
            return;

        } // 이동 횟수가 10번 이상인 경우
        for(int i = 0; i < DIR_NUM; i ++){
            int nextX1 = x1 + dx[i];
            int nextY1 = y1 + dy[i];

            int nextX2 = x2 + dx[i];
            int nextY2 = y2 + dy[i]; // 다음 위치로 이동

            int dropCnt = 0;

            dropCnt = checkRange(nextX1,nextY1)? dropCnt : dropCnt + 1;
            dropCnt = checkRange(nextX2,nextY2)? dropCnt : dropCnt + 1;

            if(dropCnt == 2){
                continue;
            } // 동시에 떨어지는 경우

            if(dropCnt == 1){
                cnt = Math.min(cnt,moveCnt + 1);
                return;
            } // 해당 위치에서 떨어지면 더이상 backTracking 할 필요 x

            if(board[nextX1][nextY1] == '#'){
                nextX1 = x1;
                nextY1 = y1;
            }
            if(board[nextX2][nextY2] == '#'){
                nextX2 = x2;
                nextY2 = y2;
            }

            backTracking(board,nextX1,nextY1,nextX2,nextY2,moveCnt + 1);
        }
    }

    public static void solution(char[][] board){

        if(board == null || board.length == 0 || board[0].length == 0) {
            return;
        }

        int row = board.length;
        int col = board[0].length;
        cnt = Integer.MAX_VALUE;

        ArrayList<Coin> coins = new ArrayList<>();

        for (int i = 0; i < board.length ; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if(board[i][j] == 'o'){
                    coins.add(new Coin(i,j));
                }
            }
        }

        Coin c1 = coins.get(0);
        Coin c2 = coins.get(1);

        backTracking(board,c1.x,c1.y,c2.x,c2.y,0);
        System.out.println(cnt == Integer.MAX_VALUE? -1 : cnt);
    }

    public static void main(String[] args) {

        char[][] board = {{'.','#'}, {'.','#'}, {'.','#'} ,{'o','#'} ,{'o','#'} ,{'#','#'}};
        n = board.length;
        m = board[0].length;
        solution(board);

    }
}
