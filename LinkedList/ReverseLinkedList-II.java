//https://leetcode.com/problems/reverse-linked-list-ii

/*
    left = 2, right = 4
    1 --> 2 --> 3 --> 4 --> 5 --> 6
    
    0 --> 1 --> 2 --> 3 --> 4 --> 5 --> 6
    ^
    |
    pre
    
    After left=2 iterations (Line 30)
    
    0 --> 1 --> 2 --> 3 --> 4 --> 5 --> 6
          ^     ^     ^
          |     |     |
         pre   tail  cur
         
    Second while loop (Line 50)
    
    Pass 1
    0 --> 1 --> 3 --> 2 --> 4 --> 5 --> 6
          ^           ^     ^
          |           |     |
         pre         tail   cur
         
    Pass 2
    0 --> 1 --> 4 --> 3 --> 2 --> 5 --> 6
          ^                 ^     ^
          |                 |     |
         pre               tail  cur

*/
class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        return reverseBy3Pointers(head, left, right);
    }
    
    ListNode reverseBy3Pointers(ListNode head, int left, int right) {
        if(head == null || head.next == null || left == right) {
            return head;
        }
        
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        head = dummy;
        
        int i=1;
        ListNode pre = dummy, current, tail;
        while(i < left) {
            pre = pre.next;
            i++;
        }
        
        tail = pre.next;
        current = tail.next;
        
        while(i < right) {
            tail.next = current.next;
            current.next = pre.next;
            pre.next = current;
            current = tail.next;
            i++;
        } 
        
        return dummy.next;
        
    }
}
