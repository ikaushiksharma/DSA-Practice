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
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head==null || head.next==null) return head;
        ListNode dummyHead=new ListNode(0);
        dummyHead.next=head;
        ListNode prev=dummyHead;
        ListNode nex;
        int n=0;
        ListNode curr=head;
        while(curr!=null){
            curr=curr.next;
            ++n;
        }
        while(n>=k){
            curr=prev.next;
            nex=curr.next;
            for(int i=1;i<k;i++){
                curr.next=nex.next;
                nex.next=prev.next;
                prev.next=nex;
                nex=curr.next;
            }
            prev=curr;
            n-=k;
        }
        return dummyHead.next;
    }
    
}