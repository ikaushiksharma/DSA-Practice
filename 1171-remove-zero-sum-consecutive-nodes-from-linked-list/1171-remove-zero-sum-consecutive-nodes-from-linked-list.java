/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode removeZeroSumSublists(ListNode head) {
        HashMap<Integer, ListNode> mp = new HashMap<>();
        int sum = 0;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        for (ListNode iter = dummy; iter != null; iter = iter.next) {
            sum += iter.val;
            if (mp.containsKey(sum)) {
                ListNode prev = mp.get(sum);
                ListNode toRemove = prev.next;
                int p = sum + (toRemove != null ? toRemove.val : 0);

                while (p != sum) {
                    mp.remove(p);
                    toRemove = toRemove.next;
                    p += (toRemove != null ? toRemove.val : 0);
                }

                prev.next = iter.next;
            } else {
                mp.put(sum, iter);
            }
        }
        return dummy.next;
    }
}