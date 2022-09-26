// 분할정복
// 장점01 : 문제를 서브 문제로 나누어 어려운 문제 해결 가능
// 장점02 : 병렬 처리에 용이

// 단점 : 메모리를 많이 사용(재귀 호출)

// 분할정복 예시 : 병합정렬,퀵정렬,이진탐색

package Algorithms.DivideConquer_분할정복;

public class DivideConquer {

    public static int getMax(int[] arr, int left, int right){

        int mid = (left + right) / 2;

        if(right == left) // 더이상 분할 x
            return arr[left];

        left = getMax(arr,left,mid);
        right = getMax(arr,mid + 1,right);

        return left > right ? left : right;

    }
    public static void main(String[] args) {

        int[] arr = {3,5,10,50,25,30,1,15};
        System.out.println(getMax(arr,0,arr.length - 1));
    }
}
