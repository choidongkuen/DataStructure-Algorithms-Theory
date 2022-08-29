// 배열의 삽입, 삭제 구현해보기

package Array_배열;

import java.util.Arrays;
import java.util.Scanner;

class MyArray {
    int[] arr; // 인스턴스 변수

    public MyArray(int size) {
        this.arr = new int[size]; // 0 ~ size - 1 범위
    }

    public void insertData(int index, int data) { // index 위치에 data 삽입
        if (index < 0 || index > this.arr.length) {
            System.out.println("Index Error");
            return;
        }
        int[] arrDup = this.arr.clone(); // 배열 복사본
        this.arr = new int[this.arr.length + 1]; // (기존의 arr 크기 + 1)의 새로운 배열 객체 생성

        for (int i = 0; i < index; i++) {
            this.arr[i] = arrDup[i];
        } // index 전 까지 채워 넣기
        for (int i = index + 1; i < this.arr.length; i++) {
            this.arr[i] = arrDup[i-1]; // 생각잘해보기
        } // index 후 부터 채워 넣기
        arr[index] = data; // index 자리에 data 채워넣기
    }

    public void deleteData(int data) { // 특정 data 삭제
        boolean existData = false;
        int ind = -1;
        for (int i = 0; i < this.arr.length; i++) {
            if (arr[i] == data) {
                existData = true; // 부울 변수 true
                ind = i; // 특정 data 에 인덱스 저장
                break;
            }
        }

        if (!existData) {
            System.out.println("해당데이터가 존재하지 않습니다.");
        } // 해당 데이터가 존재하지 않는 경우

        else {
            int[] arrDup = this.arr.clone(); // 배열 복사본
            this.arr = new int[this.arr.length - 1]; // (기존의 arr 크기 - 1)의 새로운 배열 객체 생성

            for (int i = 0; i < ind; i++) {
                this.arr[i] = arrDup[i];
            }
            for (int i = ind ; i < this.arr.length; i++) {
                this.arr[i] = arrDup[i + 1];
            }
        }
    }

    public void printArr(){
        System.out.println(" == 배열 출력 == ");
        for (int i = 0; i < this.arr.length ; i++) {
            System.out.print(arr[i]+" ");
        }
    }
}


public class ArrayPractice02 {
    public static void main(String[] args){
        MyArray myArray = new MyArray(10);

        for (int i = 0; i < myArray.arr.length ; i++) {
            myArray.arr[i] = i + 1;
        } // 해당 객체의 인스턴스 변수인 arr 배열 원소 초기화

        System.out.println("Arrays= " + Arrays.toString(myArray.arr));

        myArray.insertData(2,20);
        System.out.println("Arrays= " + Arrays.toString(myArray.arr));

        myArray.insertData(5,100);
        System.out.println("Arrays= " + Arrays.toString(myArray.arr));

        myArray.deleteData(100);
        System.out.println("Arrays= " + Arrays.toString(myArray.arr));

        myArray.deleteData(9999);

        System.out.println("Arrays= " + Arrays.toString(myArray.arr));
    }
}
