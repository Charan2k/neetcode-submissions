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

    private ListNode reverse(ListNode node) {
        if(node == null) return node;

        ListNode temp = node;
        if(node.next != null) {
            temp = reverse(node.next);
            node.next.next = node;
        }
        node.next = null;

        return temp;
    }

    public void reorderList(ListNode head) {
        ListNode revNode = head;
        ListNode fast = head;

        while(fast.next != null && fast.next.next != null) {
            revNode = revNode.next;
            fast = fast.next.next;
        }

        ListNode second = reverse(revNode.next);
        revNode.next = null;

        ListNode first = head;
        while(second != null) {
            ListNode temp1 = first.next;
            ListNode temp2 = second.next;
            first.next = second;
            second.next = temp1;

            first = temp1;
            second = temp2;
        }

    }
}
