/**
 * Definition for singly-linked list.
 * class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) {
 * val = x;
 * next = null;
 * }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        // BRUTE [hashing]: TC -> O(N*2) SC -> O(N)
        Set<ListNode> set = new HashSet<>();
        ListNode temp = head;

        while (temp != null) {
            if (set.contains(temp))
                return true;
            set.add(temp);
            temp = temp.next;
        }
        return false;

        // Optimal[tortoise and hare] : TC -> O(N) SC -> O(1)

        // ListNode fast = head;
        // ListNode slow = head;
        // while (fast != null && fast.next != null) {
        //     slow = slow.next;
        //     fast = fast.next.next;
        //     if (slow == fast)
        //         return true;
        // }
        // return false;

        //Intuition:
        // if the diff b/w fast and slow is 'd' and w.k.t the net-reduction b/w fast and slow
        // will always be '1'[cuz, fast moves ahead of slow by jus 1 step (net reduction = 1 for 1st iteration)] and d will eventually become d - d = 0, cuz "d % 1 == 0" is true :)
    }
}