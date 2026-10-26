using System.Numerics; // Import the necessary namespace

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * public int val;
 * public ListNode next;
 * public ListNode(int val=0, ListNode next=null) {
 * this.val = val;
 * this.next = next;
 * }
 * }
 */
public class Solution {
    public ListNode AddTwoNumbers(ListNode l1, ListNode l2) {
        
        BigInteger firstNumber = BigInteger.Zero;
        BigInteger secondNumber = BigInteger.Zero;
        
        BigInteger multiplier = BigInteger.One;
        
        ListNode current1 = l1;
        while (current1 != null) {
            BigInteger digit = new BigInteger(current1.val);
            firstNumber += digit * multiplier;
            
            multiplier *= 10;
            current1 = current1.next;
        }

        multiplier = BigInteger.One;
        ListNode current2 = l2;
        while (current2 != null) {
            BigInteger digit = new BigInteger(current2.val);
            secondNumber += digit * multiplier;
            
            multiplier *= 10;
            current2 = current2.next;
        }

        BigInteger sum = firstNumber + secondNumber;

        
        if (sum.IsZero) {
            return new ListNode(0);
        }

        ListNode dummyHead = new ListNode(0);
        ListNode current = dummyHead;

        while (sum > 0) {
            int digit = (int)(sum % 10);
            
            current.next = new ListNode(digit);
            current = current.next;
            
            sum /= 10;
        }

        return dummyHead.next;
    }
}