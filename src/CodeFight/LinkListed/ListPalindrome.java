package CodeFight.LinkListed;

import java.util.Stack;

public class ListPalindrome {
    /* *
        ListNode<Integer> k1 = new ListNode<Integer>(0);
        ListNode<Integer> k2 = new ListNode<Integer>(1);
        ListNode<Integer> k3 = new ListNode<Integer>(0);
        k1.next = k2;
        k2.next = k3;
        printLinkedList(isListPalindrome(k1));
    * */



    boolean isListPalindrome(ListNode<Integer> l) {
        ListNode<Integer> reverse = getReverse(l);
        if(l == null){
            return false;
        }
        while(l != null){
            if(l.value != reverse.value){
                return false;
            }
            reverse = reverse.next;
            l = l.next;
        }
        return true;
    }

    ListNode<Integer> getReverse(ListNode<Integer> l){
        Stack<ListNode<Integer>> stack = new Stack();
        ListNode reverse = new ListNode(0);
        ListNode start = reverse;
        while(l != null){
            stack.add(l);
            l = l.next;
        }
        while(!stack.isEmpty()){
            //System.out.println(reverse.value);
            reverse.next = stack.pop();
            reverse = reverse.next;
        }
        reverse.next = null;
        return  start.next;
    }

    void printLinkedList(ListNode<Integer> l){
        while(l != null) {
            System.out.println(l.value);
            l = l.next;
        }
    }


    class ListNode<T> {
        ListNode(T x) {
            value = x;
        }
        T value;
        ListNode<T> next;
    }
}
