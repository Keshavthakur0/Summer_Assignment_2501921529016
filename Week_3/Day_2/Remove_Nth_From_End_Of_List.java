class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode blank = new ListNode(0);
        blank.next = head;
        
        ListNode fast =blank;
        ListNode slow =blank;

        for (int i = 0; i <= n; i++) {
            fast = fast.next;
        }
        
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }

        slow.next = slow.next.next;
        return blank.next;
    }
}