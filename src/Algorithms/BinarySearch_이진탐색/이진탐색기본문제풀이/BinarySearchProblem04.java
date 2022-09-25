// 2 차원 배열에서 이진 탐색으로 데이터 찾기
// row X col 행렬 데이터가 주어질 때, target 을 이진 탐색으로 찾는 프로그램을 작성하세요.
// 각 행의 데이터는 오름차순으로 정렬 상태

// 입출력 예시
// 입력 {{1,3,7,8},{10,11,15,20},{21,30,35,60}}

// target : 3
// 출력 : true

// target : 13
// 출력 : false

package Algorithms.BinarySearch_이진탐색.이진탐색기본문제풀이;

public class BinarySearchProblem04 {
    public static boolean solution01(int[][] matrix, int target){ // 내가 푼 방식

        int left = 0;
        int right = matrix.length - 1;

        while(left <= right){

            int mid = left + (right - left) / 2;

            if(target >= matrix[mid][0] && target <= matrix[mid][matrix[mid].length - 1]){
                for(int i = 0; i < matrix[mid].length; i ++){
                    if(target == matrix[mid][i])
                        return true;
                }
                return false;
            }else if(target < matrix[mid][0]) {
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }
        return false;
    }

    public static boolean solution02(int[][] matrix, int target){ // 강의용 풀이

        int row = matrix.length;
        int col = matrix[0].length;
        int left = 0;
        int right = row * col - 1;

        while(left <= right){

            int mid = left + (right - left) % 2;
            if(matrix[mid / col][mid % col] == target) {
                return true;
            }else if(matrix[mid / col][mid % col] < target){
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }
        return false;
    }
    public static void main(String[] args) {

        int[][] matrix = {{1,3,7,8},{10,11,15,20},{21,30,35,60}};

        System.out.println(" == 내가 푼 방식 == ");
        System.out.println(solution01(matrix,3)); // true
        System.out.println(solution01(matrix,13)); // false
        System.out.println(solution01(matrix,35)); // true

        System.out.println(" == 강의용 방식 == ");
        System.out.println(solution02(matrix,3)); // true
        System.out.println(solution02(matrix,13)); // false
        System.out.println(solution02(matrix,35)); // true




    }
}
