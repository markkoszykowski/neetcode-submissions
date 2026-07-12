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
    public boolean hasCycle(final ListNode head) {
        ListNode slow = head;
        ListNode fast = head == null || head.next == null ? null : head.next.next;
        while (slow != fast) {
            if (slow == null) {
                return false;
            } else {
                slow = slow.next;
            }
            if (fast == null || fast.next == null) {
                return false;
            } else {
                fast = fast.next.next;
            }
        }
        return slow != null && fast != null;
    }
}
