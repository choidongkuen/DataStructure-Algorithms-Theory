// 문자열 s 를 거꾸로 출력하는 프로그램을 작성하세요.
// 단, 각 단어의 알파벳 순서는 그대로 출력합니다.
// 문장에 공백이 여러개일 시, 단어와 단어 사이 하나의 공백을 제외한 나머지 공백은 제거하세요.

// 입출력 예시
// 문자열 s : "the sky is blue"
// 출력 : "blue is sky the"

// 문자열 s : "  hello     java    "
// 출력 : "java hello"

package Algorithms.TwoPointer_투포인터.투포인터문제풀이;

public class TwoPointerProblem03{

    public static void reverseWords(char[] arr){ // 문자열 뒤집어주는 메소드

        int left = 0;
        int right = 0;
        int length = arr.length;

        while(right < length){

            while(right < length && arr[right] != ' '){
                right ++;
            }

            reverseString(arr,left,right - 1);

            if(right != arr.length){
                right ++;
                left = right;
            }
        }
    }

    public static void reverseString(char[] arr,int start, int end){ // start ~ end 문자열 뒤집어주는 메소드

        int left = start;
        int right = end;

        while(left < right){
            char tmp = arr[left];
            arr[left ++] = arr[right];
            arr[right --] = tmp;
        }
    }

    public static String removeSpace(char[] arr){ // 공백 제거해주는 메소드
        int p1 = 0;
        int p2 = 0;
        int length = arr.length;

        while(p2 < length){

            while(p2 < length && arr[p2] == ' '){
                p2 ++;
            } // 공백일 때, p2 ++;

            while(p2 < length && arr[p2] != ' '){
                arr[p1 ++] = arr[p2 ++];
            } // 공백이 아닐 때
            while(p2 < length && arr[p2] == ' '){
                p2++;
            } // 공백일 때

            if(p2 != length)
                arr[p1 ++] = ' ';
        }

        return new String(arr).substring(0,p1);
    }

    public static String solution(String s){

        s = removeSpace(s.toCharArray()); // 공백 제거

        char[] cArr = s.toCharArray();
        reverseString(cArr,0,cArr.length - 1); // 전체 문자열 뒤집기
        reverseWords(cArr); // 부분 문자열 뒤깁기

        return new String(cArr);
    }
    public static void main(String[] args) {

        System.out.println(solution("the sky is blue"));
        System.out.println(solution("  hello      java    "));

    }
}
