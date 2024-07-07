package LinkedList;

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class RotateList {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) {
            return head;
        }


        ListNode current = head;
        int length = 1;
        while (current.next != null) {
            length++;
            current = current.next;
        }

        current.next = head;

        k = k % length;
        int steps = length -k -1;
        ListNode newLast = head;
        for (int i = 0; i < steps; i++) {
            newLast = newLast.next;
        }

        ListNode newHead = newLast.next;
        newLast.next = null;

        return newHead;
    }
}
