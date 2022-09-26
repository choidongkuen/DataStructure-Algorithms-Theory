// 거스름돈 문제
// 잔돈 : 890
// 동전 종류 : 10,50,100,500
// 거스름돈을 거슬러 줄때, 동전의 최소 갯수

package Algorithms.Greedy_그리디;


import java.util.HashMap;
import java.util.Set;

public class Greedy02 {

    public static void getChangeCoins(int receiveMoney, int price){
        final int[] coins = {500,100,50,10,5,1};

        int change = receiveMoney - price; // 거슬러줘야 할 잔돈
        int cnt = 0; // 필요한 동전의 최소 갯수
        HashMap<Integer,Integer> hashMap = new HashMap<>();

        for(int i = 0; i < coins.length; i ++){

            if(coins[i] > change)
                continue;

            int q = change / coins[i];
            hashMap.put(coins[i],q);

            change %= coins[i];
            cnt += q;
        }

        Set<Integer> keySet = hashMap.keySet();
        System.out.println("거스름돈 동전의 갯수 : " + cnt);
        for(Integer k: keySet)
            System.out.println(k +" : " +hashMap.get(k));

        System.out.println("=========== ");
    }
    public static void main(String[] args) {

        getChangeCoins(1000,100);
        getChangeCoins(1234,500);

    }
}
