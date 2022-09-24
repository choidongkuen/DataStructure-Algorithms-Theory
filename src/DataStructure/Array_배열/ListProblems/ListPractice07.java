package DataStructure.Array_배열.ListProblems;

public class ListPractice07 {
    public static boolean checkPalindrome(LinkedList list) {
        Node cur = list.head;
        Node left = list.head;
        Node right = null;

        int cnt = 0;
        while (cur != null) {
            cnt++;
            right = cur;
            cur = cur.next;
        }

        Node prevRight = right;
        for (int i = 0; i < cnt / 2; i++) {
            if (left.data != right.data) {
                return false;
            }

            left = left.next;
            right = left;
            while (right.next != prevRight) {
                right = right.next;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        // Test code
        LinkedList linkedList = new LinkedList();
        linkedList.insertData(1);
        linkedList.insertData(3);
        linkedList.insertData(5);
        linkedList.insertData(5);
        linkedList.insertData(3);
        linkedList.insertData(1);
        System.out.println(checkPalindrome(linkedList));
/*
        LinkedList linkedList2 = new LinkedList();
        linkedList2.addData(3);
        linkedList2.addData(5);

        linkedList2.addData(5);
        linkedList2.addData(3);
        System.out.println(checkPalindrome(linkedList2));

        LinkedList linkedList3 = new LinkedList();
        linkedList3.addData(1);
        linkedList3.addData(3);
        linkedList3.addData(5);
        linkedList3.addData(1);
        System.out.println(checkPalindrome(linkedList3));

 */

    }
}
