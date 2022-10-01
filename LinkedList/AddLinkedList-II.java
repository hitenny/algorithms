//https://leetcode.com/problems/add-two-numbers-ii
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        //return sumByStack(l1, l2);
        
        int len1 = lengthOfList(l1);
        int len2 = lengthOfList(l2);
        ListNode l1New = l1;
        ListNode l2New = l2;
        
        if(len1 > len2) {
            l2New = padZeros(l2, len1-len2);    
        }
        else {
            l1New = padZeros(l1, len2-len1);
        }
        
        ListNode result = sumByRecursion(l1New, l2New);
        return result.val == 0 ?  result.next : result;
    }
    
    
    ListNode sumByStack(ListNode l1, ListNode l2) {
        Stack<Integer> l1Stack = new Stack<>();
        Stack<Integer> l2Stack = new Stack<>();
        
        while(l1 != null) {
            //System.out.println("Adding " + l1.val);
            l1Stack.push(l1.val);
            l1 = l1.next;
        }
        
        while(l2 != null) {
            //System.out.println("Adding " + l2.val);
            l2Stack.push(l2.val);
            l2 = l2.next;
        }
        
        int carry = 0;
        ListNode nextNode = null;
        while(!l1Stack.isEmpty() && !l2Stack.isEmpty()) {
            //System.out.println("Adding " + l1Stack.peek() + " + " + l2Stack.peek());
            int sum = l1Stack.pop() + l2Stack.pop() + carry;
            carry = sum/10;
            ListNode n = new ListNode();
            n.val = sum%10;
            n.next = nextNode;
            nextNode = n;
        }
        
        while(!l1Stack.isEmpty()) {
            int sum = l1Stack.pop() + carry;
            carry = sum/10;
            ListNode n = new ListNode();
            n.val = sum%10;
            n.next = nextNode;
            nextNode = n;
        }
        
        while(!l2Stack.isEmpty()) {
            int sum = l2Stack.pop() + carry;
            carry = sum/10;
            ListNode n = new ListNode();
            n.val = sum%10;
            n.next = nextNode;
            nextNode = n;
        }
        
        if(carry > 0) {
            ListNode n = new ListNode();
            n.val = carry;
            n.next = nextNode;
            nextNode = n;
        }
        return nextNode;
    }
    
    ListNode padZeros(ListNode l, int n) {
        for(int i=0; i<n; i++) {
            ListNode node = new ListNode(0);
            node.next = l;
            l = node;
        }
        
        return l;
    }
    
    int lengthOfList(ListNode l) {
        int len = 0;
        while(l != null) {
            len++;
            l = l.next;
        }
        
        return len;
    }
    
    ListNode sumByRecursion(ListNode l1, ListNode l2) {
        if(l1 == null) {
            return new ListNode(0);
        }
        
        ListNode carry = sumByRecursion(l1.next, l2.next);
        
        ListNode n = new ListNode();
        //System.out.println("Setting sum as " + l1.val + " + " + l2.val + " + " + carry.val);
        int sum = l1.val + l2.val + carry.val;
        carry.val = sum%10;
        n.val = sum/10;
        n.next = carry;
        
        return n;
    }
}
