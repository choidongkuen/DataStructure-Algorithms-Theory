// a,b,c,d 로 이루어진 알파벳 문자열에 대해서,
// 다음과 같은 규칙으로 문자열을 정리한 후 남은 문자열을 반환하는 프로그램을 작성하세요.
// - 규칙 -
// 양쪽의 문자를 비교한 후, 같으면 삭제하는데, 연속해서 같은 문자가 등장하면 함께 삭제한다.
// 최종적으로 남은 문자열 출력하시오.

// 입출력 예시
// 입력 : s -> "ab"
// 출력 : "ab"

// 입력 : s -> "aaabbaa"
// 출력 : null

package Algorithms.TwoPointer_투포인터.투포인터문제풀이;

public class TwoPointerProblem01 {

    public static String solution(String s){

        int left = 0;
        int right = s.length() - 1;
        char[] cArr = s.toCharArray();

        while(left < right && cArr[left] == cArr[right]){

            char c = cArr[left];

            while(cArr[left] == c && left <= right)
                left ++;
            while(cArr[right] == c && left <= right)
                right --;
        }
        s = new String(cArr);
        if(left > right)
            return null;
        return s.substring(left,right + 1);
    }
    public static void main(String[] args) {

        System.out.println(solution("ab")); // ab
        System.out.println(solution("aaabbaa")); // null
        System.out.println(solution("aabcddba")); // cdd

    }
}
