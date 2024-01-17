/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if (head == null) {
            return head;
        }
        Node curr = head;
        while (curr != null) {
            Node n = new Node(curr.val);
            n.next = curr.next;
            curr.next = n;
            curr = curr.next.next;
        }
        curr = head;
        while (curr != null) {
            if (curr.random == null) {
                curr.next.random = null;
            } else {
                curr.next.random = curr.random.next;
            }
            curr = curr.next.next;
        }

        curr = head;
        Node curr1 = head.next;
        Node h = curr1;
        while (curr != null) {
            curr.next = curr.next.next;
            if (curr1.next != null) {
                curr1.next = curr1.next.next;
            }
            curr = curr.next;
            curr1 = curr1.next;
        }
        return h;
    }
}