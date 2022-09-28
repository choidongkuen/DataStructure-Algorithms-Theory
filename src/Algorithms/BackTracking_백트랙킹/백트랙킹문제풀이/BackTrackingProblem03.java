// 'sols 배열'에 5지 선다 문제의 정답들이 적혀있다.
// 3번 연속 해서 같은 정답이 있는 경우가 없다는 것을 알아낸 후,
// 문제를 찍어서 푼다고 할 때, 5점 이상을 받을 경우의 수는?

// 문제는 총 10문제 이며, 각 문제당 1점이다.
// 입출력 예시

// sols : {1,2,3,4,5,1,2,3,4,5};
// 결과 : 261622

// 아이디어 :
// 3문제가 연속으로 같은 값인 경우는 없는 경우임으로, 3번 연속해서 같은 답으로 찍는 경우는 prunning
// 5점 이상을 받아야 함으로, 현재 점수에 대한 변수를 준비해서 업데이트 해준다.


package Algorithms.BackTracking_백트랙킹.백트랙킹문제풀이;

public class BackTrackingProblem03 {

    public static final int numOfProblems = 10; // 총 10문제
    public static int cnt; // 경우의 수

    public static void solution(int[] sols){

        if(sols == null || sols.length != numOfProblems)
            return;

        cnt = 0;
        int[] submit = new int[numOfProblems]; // 내가 찍은 번호를 기록할 배열
        // backTracking
        backTracking(sols,submit,0,0);
        System.out.println(cnt);
    }
    public static void backTracking(int[] sols, int[] submit, int correctCnt, int idx){

        // sols : 정답지 , submit : 내가 표기한 정답 정보가 있는 배열, corretCnt : 얻은 점수, idx : 지금까지 푼 문제
        if(numOfProblems - idx + correctCnt < 5)
            return; // 남은 문제 -> numOfProblems - idx 이다. 그러나 이것을 다 맞춰도 5점이 안되는 경우 return;

        if (idx == numOfProblems){ // 10문제 다 푼 경우
            if(correctCnt >= 5) {
                cnt++;
            }
        }else{ // 10문제 다 못 푼 경우
            int twoInRow = 0;
            if(idx >= 2){
                if(submit[idx - 1] == submit[idx - 2]){
                    twoInRow = submit[idx - 1]; // 기록
                }
            }
            for (int i = 1; i <= 5; i++) {
                if (i == twoInRow) { // 3문제 연속 찍은 경우
                    continue;
                }

                submit[idx] = i; // idx 번 문제를 i번으로 찍기
                if(sols[idx] == i){ // 만약 정답이라면
                    backTracking(sols,submit,correctCnt + 1,idx + 1);
                }else{ // 정답이 아니라면
                    backTracking(sols,submit,correctCnt,idx + 1);
                }
                submit[idx] = 0;
            }
        }
    }

    public static void main(String[] args) {
        int[] sols = {1,2,3,4,5,1,2,3,4,5};
        solution(sols);

        sols = new int[]{1,1,2,2,3,3,4,4,5,5};
        solution(sols);
    }
}
