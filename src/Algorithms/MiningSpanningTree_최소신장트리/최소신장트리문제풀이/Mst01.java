// Practice 01
// 날짜 : 2022/10/05
// 문제 설명 :
// 2250년, 인류는 지구 뿐 아니라 여러 행성을 다니며 살고 있다.
// 이 행성 간을 빨리 오가기 위해 새롭게 터널을 구축하려고 한다.

// 행성은 (x,y,z) 좌표로 주어진다.
// 행성1 : (x1,y1,z1), 행성2 : (x2,y2,z2)
// 이 때 행성간 터널 연결 비용은 min(|x1 -x2|,|y1 - y2|,|z1 - z2|) 로 계산한다.
// -> 셋 중 최솟값

// n 개의 행성 사이를 n-1 개의 터널로 연결하는데 드는 최소 비용을 구하는 프로그램을 작성하시오.
// -> MST

// 입출력 예시
// 입력 :
// data = {{11,-15,-15},{14,-5,-15},{-1,-1,-5},{10,-4,-1},{19,-4,19}}
// 출력 : 4

package Algorithms.MiningSpanningTree_최소신장트리.최소신장트리문제풀이;

import java.util.ArrayList;
import java.util.Collections;

public class Mst01 {

    public static ArrayList<Edge> edge;
    public static ArrayList<Space> space;
    public static int[] uf;

    static class Space{
        int idx;
        int x;
        int y;
        int z;

        Space(int idx, int x, int y, int z){
            this.idx = idx;
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }

    static class Edge implements Comparable<Edge>{

        int from;
        int to;
        int weight;

        Edge(int from, int to, int weight){
            this.from = from;
            this.to = to;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge o) {
            return this.weight - o.weight;
        } // 가중치 기준 오름차순으로 정렬
    }
    public static int find(int a){

        if(a == uf[a])
            return a;
        int rootNode = find(uf[a]);
        uf[a] = rootNode;
        return rootNode;
    }

    public static void union(int a, int b){
        int aP = find(a);
        int bP = find(b);
        uf[aP] = bP;
    }

    public static int kruskal(int v){
        uf = new int[v + 1];
        int weightSum = 0;


        for (int i = 1; i <= v ; i++) {
            uf[i] = i;
        }

        for (int i = 0; i < edge.size() ; i++) {
            Edge cur = edge.get(i);
            if (find(cur.to) != find(cur.from)) {
                weightSum += cur.weight;
                union(cur.to,cur.from);
            }
        }
        return weightSum;
    }

    public static int solution(int[][] graph){

        int v = graph.length; // 행성의 개수
        space = new ArrayList<>();
        edge = new ArrayList<>();

        for (int i = 0; i < v ; i++) {
            space.add(new Space(i, graph[i][0], graph[i][1],graph[i][2]));
        } // 인스턴스 배열 원소 채우기

        // x축 기준 간선 추가
        Collections.sort(space, (s1, s2) -> s1.x - s2.x);
        // 오름차순을 해야 최소 비용이 보장

        for (int i = 0; i < v - 1 ; i++) {
            int weight = Math.abs(space.get(i).x - space.get(i + 1).x);
            edge.add(new Edge(space.get(i).idx,space.get(i + 1).idx,weight));
        }
        // y축 기준 간선 추가
        Collections.sort(space, (s1,s2) -> s1.y - s2.y);

        for (int i = 0; i < v - 1 ; i++) {
            int weight = Math.abs(space.get(i).y - space.get(i + 1).y);
            edge.add(new Edge(space.get(i).idx,space.get(i + 1).idx,weight));
        }
        // z축 기준 간선 추가

        Collections.sort(space, (s1,s2) -> s1.z - s2.z);
        for (int i = 0; i < v - 1 ; i++) {
            int weight = Math.abs(space.get(i).z - space.get(i + 1).z);
            edge.add(new Edge(space.get(i).idx,space.get(i + 1).idx,weight));
        }

        Collections.sort(edge);
        return kruskal(v);
    }
    public static void main(String[] args) {

        int[][] data = {{11,-15,-15},{14,-5,-15},{-1,-1,-5},{10,-4,-1},{19,-4,19}};
        System.out.println(solution(data));

    }
}
