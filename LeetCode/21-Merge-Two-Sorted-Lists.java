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
using System.Collections.Generic;
using System.Linq;

public class Solution {
    public ListNode MergeTwoLists(ListNode list1, ListNode list2) {
        // create a list of all numbers:
        List<int> list = new List<int>();
        ListNode current = list1;
        ListNode next = list1;
        while (next != null) {
            current = next;
            list.Add(current.val);
            next = current.next;
        }

        current = list2;
        next = list2;
        while (next != null) {
            current = next;
            list.Add(current.val);
            next = current.next;
        }

        // sort the list in an inverse order (Descending):
        List<int> ordered = list.OrderByDescending(x => x).ToList();
        
        // make a new linked List:
        if (ordered.Count == 0) return null; // Handle case where both lists were null
        
        ListNode head = new ListNode(ordered[ordered.Count - 1]);
        ListNode prev = head;
        ListNode newNode; 
        
        for (int i = ordered.Count - 2; i >= 0; --i) {
            newNode = new ListNode(ordered[i]);
            prev.next = newNode;
            prev = newNode;
        }

        // return the head of the list (largest number):
        return head;
    }
}