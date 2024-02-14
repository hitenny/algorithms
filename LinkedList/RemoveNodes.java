//https://leetcode.com/problems/remove-nodes-from-linked-list
class Solution {
    public ListNode removeNodes(ListNode head) {
        return recurse(head);
    }

    private ListNode recurse(ListNode head) {
        if(head == null) {
            return head;
        }

        ListNode node = recurse(head.next);
        if(node == null) {
            return head;
        }
        if(head.val < node.val) {
            return node;
        }
        else {
            head.next = node;
            return head;
        }
    }
}
