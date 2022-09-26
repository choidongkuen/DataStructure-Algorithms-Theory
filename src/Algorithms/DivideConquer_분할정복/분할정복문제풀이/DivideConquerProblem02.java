// 2차원 정수형 배열 list가 주어진다.
// list[i] 에는 각 링크드 리스트의 원소 정보가 들어 있고,
// 원소들은 오름차순으로 정렬된 상태이다.
// 모든 링크드 리스트를 하나의 정렬된 링크드 리스트로 합병하세요.

// list = {{2,3,9}, {1,5,7}, {3,6,7,11}}
// 순사 : 1 -> 2 -> 3 -> 3 -> 5 -> 6 -> 7 -> 7 -> 9 -> 11

package Algorithms.DivideConquer_분할정복.분할정복문제풀이;


class Node{
    int val; // 해당 노드의 값
    Node next; // 다음 노드

    Node(int val){
        this.val = val;
        this.next = null;
    }
}

public class DivideConquerProblem02 {
    public static Node solution(Node[] nodeList){
        if(nodeList == null || nodeList.length == 0)
            return null;

        return divide(nodeList,0,nodeList.length - 1);

    }
    public static Node divide(Node[] nodeList,int left, int right){

        if(left == right)
            return nodeList[left];

        int mid = left + (right - left) / 2;
        Node node1 = divide(nodeList,left, mid);
        Node node2 = divide(nodeList,mid + 1,right);
        Node mergedNode = merge(node1,node2);

        return mergedNode;
        // 분할 완료
    }

    public static Node merge(Node node1, Node node2){
        if(node1 == null)
            return node2;
        if(node2 == null)
            return node1;

        Node head = new Node(0);
        Node curNode = head;

        while(node1 != null && node2 != null){
            if(node1.val > node2.val){
                curNode.next = node2;
                node2 = node2.next;
            }else{
                curNode.next = node1;
                node1 = node1.next;
            }
            curNode = curNode.next;
        }

        if(node1 != null)
            curNode.next = node1;
        if(node2 != null)
            curNode.next = node2;

        return head.next;

    }
    public static void setUpLinkedList(Node[] node, int[][] list){
        // 2차원 배열의 데이터 정보를 1차원 노드 인스턴스 배열로 변경

        for (int i = 0; i < list.length; i++) {
            node[i] = new Node(list[i][0]);
        } // 각 연결리스트의 첫번째 원소를 각 node에 헤드로 저장

        for (int i = 0; i < list.length; i++) {
            Node cur = node[i];
            for (int j = 1; j < list[i].length ; j++) {
                cur.next = new Node(list[i][j]);
                cur = cur.next;
            }
        } // 그 후 각 연결리스트의 첫번째 원소를 기준으로 연결
    }

    public static void printList(Node node){
        Node cur = node;
        while(cur.next != null){
            System.out.print(cur.val +" -> ");
            cur = cur.next;
        }
        System.out.println(cur.val); // 마지막 노드 출력
    }
    public static void main(String[] args) {

        int[][] list = {{2,3,9}, {1,5,7}, {3,6,7,11}};
        Node[] node = new Node[list.length]; // Node 인스턴스를 담을 인스턴스 배열
        setUpLinkedList(node,list); // setting
        Node combinedNode = solution(node); // 하나로 연결
        printList(combinedNode);
    }
}
