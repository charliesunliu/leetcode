import java.util.List;

class sortList {
    public ListNode sortList(ListNode head) {

        int n = 0;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        while (head != null){
            n++;
            head = head.next;
        }

        for (int i = 1; i < n; i *= 2){
            ListNode prev = dummy;
            ListNode cur = dummy.next;
            while (cur != null){
                ListNode l1 = cur;
                ListNode l2 = split(l1, i);
                cur = split(l2, i);
                prev = merge(l1,l2, prev);
            }
        }

        return dummy.next;
    }

    private ListNode split(ListNode l, int step){
        if (l == null){
            return null;
        }
        ListNode pointer = l;
        for (int i = 1; i < step && pointer!=null; i++){
            pointer = pointer.next;
        }
        ListNode result = pointer.next;
        pointer.next = null;

        return result;
    }

    private ListNode merge(ListNode l1, ListNode l2, ListNode prev) {
//        ListNode dummy = new ListNode(-1);
        ListNode pointer = prev;
        while(l1 != null && l2 != null){
            if(l1.val <= l2.val){
                pointer.next = l1;
                l1 = l1.next;
            } else{
                pointer.next = l2;
                l2 = l2.next;
            }
            pointer = pointer.next;
        }

        if(l1 != null){
            pointer.next = l1;
            //l1 = l1.next;
        }
        if(l2 != null){
            pointer.next = l2;
            //l2 = l2.next;
        }
        while (pointer.next != null){
            pointer = pointer.next;
        }
        return pointer;
    }
}