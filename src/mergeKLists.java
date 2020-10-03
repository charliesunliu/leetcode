import java.util.List;
import java.util.PriorityQueue;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class mergeKLists {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0){
            return null;
        }
        
        PriorityQueue<ListNode> pq = new PriorityQueue<ListNode>(lists.length, (n1, n2) -> n1.val - n2.val);
        for (ListNode n : lists){
            pq.add(n);
        }
        ListNode head = new ListNode(0);
        ListNode pointer = head;
        while (!pq.isEmpty()){
            ListNode next = pq.poll();
            pointer.next = next;
            pointer = pointer.next;
            if (next.next != null){
                pq.add(next.next);
            }
        }

        return head.next;
    }
}