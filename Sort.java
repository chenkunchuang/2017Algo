import java.util.Arrays;

import listNode.*;


public class Sort {
	
	/*
	 * This funciton is to use insert sort the linked list
	 * You use one helper function sortedInsert(ListNode head, ListNode node)
	 * which will insert a new to a sorted list
	 */
	public ListNode InsertSort(ListNode head) {
		   
		ListNode dummy = new ListNode(0);
	    ListNode curr = head;
	        //dummy.next = head;
	    while(curr!=null) {
            ListNode temp = curr.next;
            //curr.next =null;
            dummy.next = sortedInsert(dummy.next, curr);
            curr = temp;
            
	    }
	    return dummy.next;	
	    
	}
	
	public ListNode sortedInsert(ListNode head, ListNode node) {
		
		 //adding dummy node to the front. So, there's no insert at the front case. 
        // all insertion will be in the middle insert. 
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode curr = dummy; 
       
        // if curr.next==null --> node will be inserted after curr. i.e., add to the end
        // this while loop is to find where to insert the node
        // 1) to the end 
        // 2) in the middle
        
        while(curr.next!=null && curr.next.val <= node.val)
        {
            curr = curr.next;
        }
           
        node.next = curr.next;
        curr.next = node;
        
        return dummy.next;
        
	}

	public void mergeSort(int[] nums) {
		
		mergeSort(nums, 0, nums.length-1);
	}
	
	public void quickSort(int[] nums) {
		
		quickSort(nums, 0, nums.length-1);
		return;
	}
	
	private void quickSort(int[] nums, int lo, int hi) {
		
		if(lo>=hi) return;
		
		int pivotIdx;
		pivotIdx = partition(nums, lo, hi);
		//System.out.println("pivot idx " + pivotIdx);
		quickSort(nums, lo, pivotIdx-1);
		quickSort(nums, pivotIdx+1, hi);
		
		return;
	}
	
	private int partition(int[] nums, int lo, int hi) {
		//assming first element is pivot
		int i=lo, j;
		int pivot =nums[lo];
		for(j=lo+1; j<=hi; j++) {
			if(nums[j]<=pivot) {
				swap(nums, i+1, j );
				i++;
			}			
		}
		
		//finish partition and swap pivot with index i
		swap(nums, i,lo);
		return i;
	}
	
	private void swap(int[] nums, int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
		
		return;
	}
	
	
 	private void mergeSort(int[] nums, int lo, int hi) {
		
		if(lo>=hi) return;
		
		int mid = (lo+hi)/2;
		
		mergeSort(nums, lo, mid);
		mergeSort(nums, mid+1, hi);
		
		int[] aux = new int[hi-lo+1];
		merge(nums, lo, mid, hi, aux);
		
	}
	
	private void merge(int[] nums, int lo, int mid, int hi, int[] aux) {
		//use two pointers to iterate two half arrays. 
		//assuming [1,3,5,7,2,4,6,8]
		// left is sorted and right is sorted. So, merge two sorted arrays. 
		
		int i=lo, j=mid+1;
		//Use Aux array to get the array values.
		for(int k=lo; k<=hi; k++) {
			
			aux[k-lo] = nums[k];
		}
		
		
		for(int k=lo; k<=hi; k++) {
			// the left half is done, merge directly the remaining right
			if(i>mid) {
				nums[k] = aux[j-lo];
				j++;
			}
			//the right half is done, merge directly the remaining left
			else if(j>hi) {
				nums[k] = aux[i-lo];
				i++;
			}
			else if(aux[i-lo]<=aux[j-lo]) {
				nums[k] = aux[i-lo];
				i++;
			}
			else {
				nums[k] = aux[j-lo];
				j++;
			}
		}
		
		return;
		
	}
	
	
	
	public static void main(String[] args) {
	
		// TODO Auto-generated method stub
		int[] arr = {7,3,5,4,6,2,1};
		ListNode head = new ListNode(0);
		ListNode curr = head;
		//generate 10 nodes for linked list
		for(int i=10; i>0; i--){
			curr.next = new ListNode(i);
			curr = curr.next;	
		}
		

		System.out.println(Arrays.toString(arr));
		Sort sort = new Sort();
		sort.mergeSort(arr);
		System.out.println(Arrays.toString(arr));
		
		head = sort.InsertSort(head);
	    curr = head;
		while(curr!=null) {
			System.out.print(" "+curr.val+" ->");
			curr = curr.next;
		}
		

	}

}
