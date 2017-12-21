package CodeFight.LinkListed;

public class RemoveKFromList {
    /*

    ## Example of request


    ListNode<Integer> k1 = new ListNode<Integer>(123);
    ListNode<Integer> k2 = new ListNode<Integer>(456);
    ListNode<Integer> k3 = new ListNode<Integer>(789);
    ListNode<Integer> k4 = new ListNode<Integer>(0);

    k1.next = k2;
    k2.next = k3;
    k3.next = k4;

    removeKFromList(k1,0);
    */

    ListNode<Integer> removeKFromList(ListNode<Integer> l, int k) {
        if(l != null) {
            ListNode<Integer> pivot = l;
            ListNode<Integer> r = new ListNode<Integer>(0);
            ListNode<Integer> s = r;
            do {
                if (r == null && pivot.value != k) {
                    r = pivot;
                } else {
                    if (pivot.value != k) {
                        r.next = pivot;
                        r = r.next;
                    }
                }

                if (pivot.next != null) {
                    pivot = pivot.next;
                } else {
                    if(r.next != null && r.next.value == k)
                    { r.next = null;}
                    break;
                }
            } while (true);
            return s.next;
        }else{
            return null;
        }
    }   
}

class ListNode<T> {
    ListNode(T x) {
        value = x;
    }
    T value;
    ListNode<T> next;
}
