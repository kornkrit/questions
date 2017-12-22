import java.io.CharConversionException;
import java.lang.reflect.Array;
import java.util.*;

public class Main {
    public static void main(String[] args){
        ListNode<Integer> k1 = new ListNode<Integer>(0);
        ListNode<Integer> k2 = new ListNode<Integer>(1);
        ListNode<Integer> k3 = new ListNode<Integer>(2);

        k1.next = k2;
        k2.next = k3;
        //getReverse(k1);

        int[] a = {1, 1000000000, -1000000000, -1000000000, 1000000000, 1};

        ListNode<Integer> x  = getList(a);

        System.out.println(isListPalindrome(x));
    }

    static ListNode<Integer> getList(int[] arr){
        ListNode<Integer> l = new ListNode<Integer>(0);
        ListNode<Integer> s = l;

        for(int i = 0; i < arr.length; i++){
            ListNode<Integer> tmp = new ListNode<Integer>(arr[i]);
            l.next = tmp;
            l = l.next;
        }
        return s.next;
    }

    boolean isListPalindrome(ListNode<Integer> l) {
        ListNode<Integer> start = l;
        Stack<Integer> a = new Stack<Integer>();
        printLinkedList(l);
        while(l != null){
            a.add(l.value);
            l = l.next;
        }
        Stack<Integer> b = new Stack<Integer>();
        ListNode<Integer> reverse = getReverse(start);
        printLinkedList(reverse);
        while(reverse != null){
           b.add(reverse.value);
           reverse = reverse.next;
        }

        while (!a.isEmpty()){
            System.out.println(a.pop() != b.pop());
        }
    return true;
    }

    ListNode<Integer> getReverse(ListNode<Integer> l){
        Stack<ListNode<Integer>> stack = new Stack();
        ListNode reverse = new ListNode(0);
        ListNode a = l;
        ListNode start = reverse;
        while(a != null){
            stack.add(a);
            a = a.next;
        }
        while(!stack.isEmpty()){
            //System.out.println(reverse.value);
            reverse.next = stack.pop();
            reverse = reverse.next;
        }
        reverse.next = null;
        l = start.next;
        return  start.next;
    }

    static void printLinkedList(ListNode<Integer> l){
        while(l != null) {
            System.out.println(l.value);
            l = l.next;
        }
    }


    static class ListNode<T> {
        ListNode(T x) {
            value = x;
        }
        T value;
        ListNode<T> next;
    }
}
