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
        if(head == null || k ==1){
            return head;
        }
        ListNode dumy = new ListNode(0);
        dumy.next = head;
        ListNode prevGroupEnd = dumy;

        while(true){
          // Find the Kth Node
            ListNode kth = findK(prevGroupEnd, k);
            if(kth == null)break;

            ListNode groupStart = prevGroupEnd.next;
            ListNode nextGroupStart = kth.next;

           //Reverse the List
            reverse(groupStart, kth);

           // Reconnect the Node
            prevGroupEnd.next = kth;
            groupStart.next = nextGroupStart;
          
          // Move prevGroupEnd forward
            prevGroupEnd = groupStart;
        
        }
       return dumy.next;

    }
    private ListNode findK(ListNode curr, int k){

        while(curr != null && k>0){
            curr = curr.next;
            k--;
        }
        return curr;
    }

   //Reverse the List
    private void reverse(ListNode start, ListNode end){
        ListNode prev = null;
        ListNode curr = start;
        ListNode stop = end.next;

        while(curr != stop){
            ListNode agla = curr.next;
            curr.next = prev;
            prev = curr;
            curr = agla;
        }
     
    }
}
