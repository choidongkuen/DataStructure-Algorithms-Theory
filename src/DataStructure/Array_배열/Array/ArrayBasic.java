package DataStructure.Array_배열.Array;
import java.util.*;


public class ArrayBasic {
    public static void main(String[] args) {
        String str = "Hapxy";
        LinkedList<Character> ll = new LinkedList<>();
        for (int i = 0; i < str.length(); i++) {
            ll.add(str.charAt(i));
        }
        ListIterator<Character> it = ll.listIterator();
        it.next();
        it.next();
        /*
        System.out.println(it.next());
        System.out.println(it.previous());
        */
        it.remove();

        it = ll.listIterator();
        while (it.hasNext())
            System.out.println(it.next() + " ");

    }
}

