// https://leetcode.com/problems/linked-list-cycle-ii/

// fast and slow pointers (Floyd's Tortoise and Hare)

class linked_list_cycle_ii {
    public ListNode detectCycle(ListNode head) {
        if(head==null || head.next==null) return null;
        ListNode slow = head;
        ListNode fast = head;
        while(fast!=null && fast.next!=null) {
            slow = slow.next;
            fast = fast.next.next;
            // cycle detected
            if(slow==fast) {
                // Reset slow to head
                // Now move both pointers at same speed
                // They will meet at the cycle's entry point
                slow = head; 
                while(slow!=fast) {
                    slow = slow.next;
                    fast = fast.next;
                }
                return slow;
            }
        }
        return null;
    }
}
