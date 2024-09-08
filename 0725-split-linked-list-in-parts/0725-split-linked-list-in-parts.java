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
    public ListNode[] splitListToParts(ListNode head, int k) {
        int size=0;
        ListNode temp=head;
        ListNode[] res=new ListNode[k];
        while(temp!=null){
            size++;
            temp=temp.next;
        }
        int rem=size%k;
        int perNode=size/k;
        temp=head;
        for(int m=0;m<k;m++){
            ListNode curr=new ListNode();
            ListNode t=curr;
            for(int i=0;i<perNode;i++){
                t.next=new ListNode(temp.val);
                temp=temp.next;
                t=t.next;
            } 
            if(rem>0){
                t.next=new ListNode(temp.val);
                temp=temp.next;
                t=t.next;
                rem--;
            }
            res[m]=curr.next;
        }
        return res;
    }
}