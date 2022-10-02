//https://leetcode.com/problems/reverse-linked-list

class Solution {
    ListNode newHead = null;
    public ListNode reverseList(ListNode head) {
        //return reverseByThreePointer(head);
        
        //reverseByRecursion(head);
        return reverseByRecursionII(head);
        //return newHead;
    }
    
    ListNode reverseByThreePointer(ListNode head) {
        ListNode prev = null;
        ListNode current = head;
        ListNode next = null;
        
        while(current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        
        return prev;
    }
    
    ListNode reverseByRecursion(ListNode head) {
        if(head == null || head.next == null) {
            newHead = head;
            return head;
        }
        
        ListNode current = reverseByRecursion(head.next);
        current.next = head;
        head.next = null;
        return head;
    }
    
    ListNode reverseByRecursionII(ListNode head) {
        if(head == null || head.next == null) {
            newHead = head;
            return head;
        }
        
        ListNode current = reverseByRecursionII(head.next);
        head.next.next = head;
        head.next = null;
        return current;
    }
}
