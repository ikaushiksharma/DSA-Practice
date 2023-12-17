/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode(int x) : val(x), next(NULL) {}
 * };
 */
class Solution {
public:
    ListNode *deleteDuplicates(ListNode *head) {
        // Start typing your C/C++ solution below
        // DO NOT write int main() function
        ListNode *temp;
        while(head!=NULL){
            if(head->next!=NULL)
                *temp=head->next;
            else return NULL;
            if(head->val==temp->val){
                head->next=temp->next;
            }
            else{
                head=head->next;
            }
        }
        return NULL;
    }
};