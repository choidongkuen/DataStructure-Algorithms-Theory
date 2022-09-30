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

    public static final int DIR_NUM = 4; // 상하좌우
    public static int[] dx = {1,-1,0,0};
    public static int[] dy = {0,0,-1,1}; // dxdy 기법

    public static int n,m; // 행과 열
    public static int cnt; // 하나가 보드에서 떨어지는 최소 이동 횟수

    static class Coin{
        int x;
        int y;

        public Coin(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    public static boolean checkRange(int x, int y) {
        return x >= 0 && x < n && y >= 0 && y < m;
    }

    public static void backTracking(char[][] board,Coin c1,Coin c2,int moveCnt){ // moveCnt는 현재 움직인 횟수
        // backTracking을 통해 해당 방향으로 갈 수 있다면, 재귀적으로 계속 들어가보면서 cnt(최소 횟수) 업데이트

        if(moveCnt >= 10){
            return; // 해당 backTracking이 10번째라면
        }

        int x1 = c1.x;
        int y1 = c1.y;

        int x2 = c2.x;
        int y2 = c2.y;


        for (int d = 0; d < DIR_NUM ; d++) { // 두개의 동전을 같은 방향으로 상하좌우 이동
            int nextX1 = x1 + dx[d];
            int nextY1 = y1 + dy[d];

            int nextX2 = x2 + dx[d];
            int nextY2 = y2 + dy[d]; // 다음 칸으로 이동

            int dropCnt = 0; // 떨어진 동전의 횟수

            if(!checkRange(nextX1,nextY1)) {
                dropCnt ++;
            } // 범위가 벗어난다면 떨어진 것

            if(!checkRange(nextX2,nextY2)) {
                dropCnt ++;
            }

            if(dropCnt == 2)
                continue;
            // 둘다 떨어지면 그 방향으로 갈 필요 x

            if(dropCnt == 1){
                cnt = Math.min(cnt,moveCnt + 1);
                return; // backTracking 종료
            } // 동전 하나만 떨어진다면 해당 이동횟수(moveCnt) 에서 하나가 떨어진 것

            if(board[nextX1][nextY1] == '#' || board[nextX2][nextY2] == '#'){
                continue;
            } // 하나라도 벽이 있다면 그 방향으로 이동 불가

            Coin nextCoin1 = new Coin(nextX1, nextY1);
            Coin nextCoin2 = new Coin(nextX2, nextY2);

            backTracking(board,nextCoin1,nextCoin2,moveCnt + 1);
        }
    }

    public static void solution(char[][] board){

        if(board == null || board.length == 0 || board[0].length == 0)
            return;


        n = board.length;
        m = board[0].length;
        // board 배열로 부터 두 동전의 위치를 얻어내야 함
        ArrayList<Coin> coins = new ArrayList<>();

        for (int i = 0; i < n ; i++) {
            for (int j = 0; j < m ; j++) {
                if(board[i][j] == 'o')
                    coins.add(new Coin(i,j));
            }
        }

        Coin c1 = coins.get(0);
        Coin c2 = coins.get(1);
        cnt = Integer.MAX_VALUE;

        backTracking(board,c1,c2,0);
        System.out.println(cnt == Integer.MAX_VALUE ? -1 : cnt);

    }

    public static void main(String[] args) {

        char[][] board = {{'.', '#'}, {'.', '#'}, {'.', '#'}, {'o', '#'}, {'o', '#'}, {'#', '#'}};
        n = board.length; // 보드판의 행
        m = board[0].length; // 보드판의 열
        solution(board);
    }
}
