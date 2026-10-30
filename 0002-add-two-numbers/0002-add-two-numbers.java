/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *
 *     ListNode() {}
 *
 *     ListNode(int val) {
 *         this.val = val;
 *     }
 *
 *     ListNode(int val, ListNode next) {
 *         this.val = val;
 *         this.next = next;
 *     }
 * }
 */

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        // a dummy to mark the beginning of our result.
        ListNode dummy = new ListNode(0);

        // Current points to the last node in our result.
        ListNode current = dummy;

        // Stores the carry from addition.
        int carry = 0;

        // Continue while either list has nodes or a carry remains.
        while (l1 != null || l2 != null || carry != 0) {

            // Get the values of the current nodes.
            // If a list has ended, use 0.
            int val1 = (l1 != null) ? l1.val : 0;
            int val2 = (l2 != null) ? l2.val : 0;

            // Add both values and the previous carry.
            int sum = val1 + val2 + carry;

            // Extract the digit to store in the result.
            int digit = sum % 10;

            // Calculate the carry for the next iteration.
            carry = sum / 10;

            // Create a new node containing the result digit.
            current.next = new ListNode(digit);

            // Move current to the newly created node.
            current = current.next;

            // Move to the next nodes in the original lists.
            if (l1 != null) {
                l1 = l1.next;
            }

            if (l2 != null) {
                l2 = l2.next;
            }
        }

        // Return the actual result, excluding the dummy node.
        return dummy.next;
    }
}