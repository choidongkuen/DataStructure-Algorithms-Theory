// 원형 루트 상에 n개의 주유소가 있다.
// 각 주유소의 가스 보유량은 gas 배열에 주어지고,
// 해당 주유소에서 다음 주유소로의 이동 비용은 cost 배열에 주어진다.

// 어떤 위치에서 차량이 가스를 채워 출발하면, '모든 주유소를 방문하고 원래의 위치로 돌아올 수 있는지'
// 계산하는 프로그램을 작성하세요.

// 입출력 예시
// gas : 1,2, 3, 4 ,5
// cost : 3,4,5, 1 ,2
// 출력 : 3

// gas : 2 , 3 , 4
// cost : 3 ,4, 3
// 출력 : -1

// 아이디어 :
// 비용이라는 것은 드는 gas량이다
// 예를 들어 특정 위치에서 가스 보유량이 3이고, 다음 주유소까지 이동 비용이 4라면 이동 못함.
// 만약 가능한 위치를 잡고, 이동했을 때, 총 가스량이 음수이면 순회 불가
// 특정 위치에서 이동 가능하면서 전체 순회 가능해야 한다.

package Algorithms.Greedy_그리디.그리디알고리즘문제풀이;

public class GreedyProblem04 {

    public static int solution(int[] gas, int[] cost) {

        if(gas == null || cost == null)
            return -1;

        if(gas.length != cost.length)
            return -1;

        int curGas = 0; // 현재 가스량
        int totalGas = 0; // 총 가스량
        int startPos = 0; // 시작 위치

        for (int i = 0; i < gas.length; i++) {
            curGas = gas[i] - cost[i]; // 해당 위치에서의 존재하는 가스량(이동비용 처리 포함)
            totalGas += gas[i] - cost[i]; // 총 소모되는 가스량

            if(curGas < 0){
                startPos = i + 1;
            } // 해당 위치에서는 출발 불가
        }
        return totalGas >= 0 ? startPos : -1; // 0보다 크다는 것은 순회 가능하다는 뜻
    }

    public static void main(String[] args) {

        int[] gas = {1,2,3,4,5};
        int[] cost = {3,4,5,1,2};
        System.out.println(solution(gas,cost));

        gas = new int[]{2,3,4};
        cost = new int[]{3,4,3};
        System.out.println(solution(gas,cost));
    }
}
