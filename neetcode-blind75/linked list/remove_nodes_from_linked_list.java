// https://leetcode.com/problems/remove-nodes-from-linked-list

/* create a decresing ordered linkedlist basically
 * best way is to use a monotonic stack (decreasing, obviously) */

// import ListNode;
import java.util.Stack;

public class remove_nodes_from_linked_list {
    public ListNode removeNodes(ListNode head) {
        if(head.next == null) return head;
        Stack<ListNode> stack = new Stack<>();
        ListNode current = head;
        while(current!=null) {
            while(!stack.isEmpty() && stack.peek().val < current.val) {
                stack.pop();
            }
            stack.push(current);
            current = current.next;
        }
        ListNode result = null;
        // create the reversed linkedlist from this stack 
        while(!stack.isEmpty()) {
            current = stack.pop();
            current.next = result;
            result = current;
        }
        return result;
    }
}
