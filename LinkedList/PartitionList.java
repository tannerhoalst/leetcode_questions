package LinkedList;

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class PartitionList {
    public ListNode partition(ListNode head, int x) {

        ListNode smallerDummy = new ListNode(0);
        ListNode greaterDummy = new ListNode(0);

        ListNode smaller = smallerDummy;
        ListNode greater = greaterDummy;

        while (head != null) {
            if (head.val < x) {
                smaller.next = head;
                smaller = smaller.next;
            } else {
                greater.next = head;
                greater = greater.next;
            }
            head = head.next;
        }

        smaller.next = greaterDummy.next;
        greater.next = null;

        return smallerDummy.next;
    }
}
