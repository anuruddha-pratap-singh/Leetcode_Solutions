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
    public ListNode sortList(ListNode head) {
        return mergeSort(head);
    }
    public ListNode mergeSort(ListNode h1){
        if(h1 == null || h1.next == null){
            return h1;
        }
        ListNode m = mid(h1);
        ListNode h2 = m.next;
        m.next = null;
        h1 = mergeSort(h1);
        h2 = mergeSort(h2);

        return mergetwosortedlist(h1,h2);
    }
    public ListNode mergetwosortedlist(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(-1);

        ListNode temp = dummy;
        ListNode p1 = list1;
        ListNode p2 = list2;

        while(p1 != null && p2 !=null){
            if(p1.val < p2.val){
                temp.next = p1;
                p1 = p1.next;
                temp = temp.next;
            }else{
                temp.next = p2;
                p2 = p2.next;
                temp = temp.next;
            }
        }
        if(p1 != null) temp.next = p1;
        if(p2 != null) temp.next = p2;

        return dummy.next;
    }
    public ListNode mid(ListNode l){
        if(l == null || l.next == null){
            return l;
        }
        ListNode temp = l;
        ListNode slow = l;
        while(temp.next != null && temp.next.next != null){
            slow = slow.next;
            temp = temp.next.next;
        }
        return slow;
    }
}