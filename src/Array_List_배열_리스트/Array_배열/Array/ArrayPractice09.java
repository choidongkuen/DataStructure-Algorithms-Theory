// Practice09
// 2차원 배열 arr을 시계방향 90도 회전시킨 결과를 출력하세요.

// 입출력 예시:
// arr :
// 1 2 3 4 5
// 6 7 8 9 10
// 11 12 13 14 15

// 결과 :
// 11 6 1
// 12 7 2
// 13 8 3
// 14 9 4
// 15 10 5
package Array_List_배열_리스트.Array_배열.Array;

import java.util.Scanner;
public class ArrayPractice09 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("행과 열을 입력해주세요. ");
        int n = sc.nextInt();
        int m = sc.nextInt();

        int[][] arr = new int[n][m];
        int[][] newArr = new int[m][n];

        System.out.println("2차원 배열 원소를 입력해주세요. ");
        for (int i = 0; i < n ; i++) {
            for (int j = 0; j < m ; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        for (int i = 0; i < n ; i++) {
            for (int j = 0; j < m ; j++) {
                newArr[j][n - 1 - i] = arr[i][j];
            }
        }
        for(int[] subarr: newArr){
            for(int ele : subarr){
                System.out.print(ele+ " ");
            }
            System.out.println();
        }
    }
}

