/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k == 1) return head;

        // Dummy node to handle edge cases
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prevGroupEnd = dummy;

        while (true) {
            // Step 1: Find the k-th node
            ListNode kth = getKthNode(prevGroupEnd, k);
            if (kth == null) break; // Not enough nodes left

            ListNode groupStart = prevGroupEnd.next;
            ListNode nextGroupStart = kth.next;

            // Step 2: Reverse the k nodes
            reverse(groupStart, kth);

            // Step 3: Reconnect pointers
            prevGroupEnd.next = kth;
            groupStart.next = nextGroupStart;

            // Move prevGroupEnd forward
            prevGroupEnd = groupStart;
        }

        return dummy.next;
    }

    // Helper to get the k-th node from current node
    private ListNode getKthNode(ListNode curr, int k) {
        while (curr != null && k > 0) {
            curr = curr.next;
            k--;
        }
        return curr;
    }

    // Helper to reverse a sublist (inclusive)
    private void reverse(ListNode start, ListNode end) {
        ListNode prev = null;
        ListNode curr = start;
        ListNode stop = end.next;

        while (curr != stop) {
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
    }
}

