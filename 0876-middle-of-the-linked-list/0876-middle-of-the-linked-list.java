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
    public ListNode middleNode(ListNode head) {
        //Brute: TC -> O(N + N/2)
        // int ct = 0;
        // ListNode temp = head;
        // while(temp != null) {
        //     ct++;
        //     temp = temp.next;
        // }
        // int mid = (ct / 2) + 1;
        // ListNode current = head;
        // while(current != null) {
        //     mid --;
        //     if(mid == 0) {
        //         return current;
        //     }    
        //     current = current.next;
        // }
        // return head;

        //Optimal: TC -> O(N / 2)
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}