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
    public boolean isPalindrome(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while(fast!= null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode pre = null;
        ListNode curr = slow;
        while(curr != null){
            ListNode next = curr.next;
            curr.next = pre ; 
            pre = curr;
            curr = next;
        }

        ListNode f = head;
        ListNode s = pre;
        while(s != null){
            if(f.val != s.val){
                return false;
            }
            f = f.next;
            s = s.next;
        }
        return true;
    }
}