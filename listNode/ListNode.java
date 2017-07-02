package listNode;
public class ListNode {
  
  public int val;
  public ListNode next;
  public ListNode(int x) { val = x; } 
  
  /*
   * Plus One in Linked list
   * Given a non-negative number represented as a singly linked list of digits, plus one to the number.
   * The digits are stored such that the most significant digit is at the head of the list
   * Input: 1->2->3
   * Output: 1->2->4
   * 
   */
  public ListNode plusOne(ListNode head) {
	  
	  return head;
  }
  
  /*Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.
   * For example,
   * Given 1->2->3->3->4->4->5, return 1->2->5.
   * Given 1->1->1->2->3, return 2->3.
   */
  public ListNode deleteDuplicates(ListNode head) {
	  ListNode dummy = new ListNode(0);
      dummy.next = head;
      ListNode prev = dummy;
    
      if(head==null || head.next==null) return head;
      while(prev.next!=null) {
          ListNode curr = prev.next;
          while (curr.next!=null && curr.val==curr.next.val) curr = curr.next;
          
          //needs to check if curr node changes or not. 
          // If curr node changes, it means there exists a duplicate.
          if(prev.next!=curr)
          {
              prev.next = curr.next;
          }
          // it means there's no duplicate. iterate the next node
          else
          {
              prev = prev.next;
          }
          
      }
      return dummy.next;
  }
}

