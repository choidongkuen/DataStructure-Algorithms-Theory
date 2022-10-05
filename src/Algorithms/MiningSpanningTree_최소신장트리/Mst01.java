// Spanning Tree : 모든 정점을 최소한의 간선으로 연결한 트리 구조
// Minimum Spanning Tree : 가중치가 존재할때, 최소한의 비용을 사용한 Spanning Tree
// 즉, 최소한의 비용을 사용해서 최소 간선으로 모든 정점을 연결하는 알고리즘

// Kruskal
// trim


// kruskal 구현해보기

package Algorithms.MiningSpanningTree_최소신장트리;

import java.util.Arrays;

public class Mst01 {
    public static int[] findUnion;

    public static int find(int a){ // 개선된 find 메소드
        if(a == findUnion[a])
            return a;

        int rootNode = find(findUnion[a]);
        findUnion[a] = rootNode;
        return rootNode;

    }

    public static void union(int a, int b){
        int aP = find(a);
        int bP = find(b);

        if(aP != bP){
            findUnion[aP] = bP;
        }

    }
    public static int kruskal(int[][] data,int v, int e){
        int weightSum = 0; // 가중치의 합

        Arrays.sort(data,(x,y) -> x[2] - y[2]); // 가중치 기준으로 오름차순 정렬
        findUnion = new int[v + 1]; // findUnion 배열 초기화

        for (int i = 1; i <= v ; i++) {
            findUnion[i] = i;
        } // findUnion 배열 초기화

        for (int i = 0; i < e ; i++) {
            if(find(data[i][0]) != find(data[i][1])){
                union(data[i][0], data[i][1]);
                weightSum += data[i][2];
            } // 연결되어 있지 않으면 연결
        }

        return weightSum;
    }

    public static void main(String[] args) {
        int v = 7;
        int e = 10;
        int[][] graph = {{1,3,1},{1,2,9},{1,6,8},{2,4,13},{2,5,2},{2,6,7},
                {3,4,12},{4,7,17},{5,6,5},{5,7,20}};

        System.out.println(kruskal(graph,v,e));
    }
}
