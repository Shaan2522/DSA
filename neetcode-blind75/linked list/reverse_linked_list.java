// https://leetcode.com/problems/reverse-linked-list/

class reverse_linked_list {
    public ListNode reverseList(ListNode head) {
        if(head==null || head.next==null) return head;
        ListNode prev = null;
        ListNode curr = head;
        while(head!=null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}
