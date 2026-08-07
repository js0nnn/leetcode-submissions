/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
  public boolean hasCycle(ListNode head) {

    ListNode sPtr = head;
    ListNode fPtr = head;

    while (fPtr != null && fPtr.next != null) {
      sPtr = sPtr.next;
      fPtr = fPtr.next.next;

      if (sPtr == fPtr)
        return true;
    }

    return false;
  }
}