package LinkedList;

class ListNode {
    int val;
    ListNode next;
    ListNode(int val) { this.val = val; }
}

public class ReverseNodesInKGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k == 1) return head;

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        ListNode curr = head;
        ListNode next = null;

        int count = 0;
        while (curr != null) {
            count++;
            curr = curr.next;
        }

        while (count >= k) {
            curr = prev.next;
            next = curr.next;
            for (int i = 1; i < k; i++) {
                curr.next = next.next;
                next.next = prev.next;
                prev.next = next;
                next = curr.next;
            }
            prev = curr;
            count -= k;
        }

        return dummy.next;
    }
}
