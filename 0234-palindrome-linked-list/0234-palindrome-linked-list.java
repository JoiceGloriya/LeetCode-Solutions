/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public boolean isPalindrome(ListNode head) {
        // Step 1: Find the middle node. [Tortoise and Hare algo]
        // Step 2: Reverse the second half of LL.
        // Step 3: To compare the nodes respectively in both the parts of LL.

        if(head == null || head.next == null) return true;

        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode newHead = reverse(slow);
        ListNode first = head;
        ListNode second = newHead;
        while (second != null) {
            if (first.val != second.val) {
                reverse(newHead);
                return false;
            }
            first = first.next;
            second = second.next;
        }
        reverse(newHead);
        return true;
    }

    private ListNode reverse(ListNode head) { 
        ListNode prev = null;
        ListNode temp = head;
        while (temp != null) {
            ListNode front = temp.next;
            temp.next = prev;
            prev = temp;
            temp = front;
        }
        return prev;
    }
}