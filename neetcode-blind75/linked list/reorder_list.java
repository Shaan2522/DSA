// https://leetcode.com/problems/reorder-list/

/* keep the first half same as it is
 * reverse the second half of the list
 * now append second half nodes into first half alternatively */

class Main {
    public void reorder_list(ListNode head) {
        if(head.next==null) return;
        // find middle
        ListNode slow = head;
        ListNode fast = head;
        while(fast!=null && fast.next!=null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        // slow is the last node of first half
        ListNode secondHalf = slow.next; // Head of the second half
        slow.next = null; // Split the list
        // reverse the second half
        ListNode prev = null;
        ListNode curr = secondHalf;
        while(curr!=null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        // now, prev is the head of the reversed second half
        // merge both halves
        ListNode first = head;
        ListNode second = prev;
        while(second!=null) {
            ListNode temp1 = first.next; // remember next node to the first
            ListNode temp2 = second.next; // remember next node to the second
            first.next = second; // link first node to second node
            second.next = temp1; // link second node to rest of first list
            // move pointers forward for next iteration
            first = temp1;
            second = temp2;
        }
    }
}
