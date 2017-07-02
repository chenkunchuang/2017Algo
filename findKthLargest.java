import java.util.*;


public class findKthLargest {
	
	   public findKthLargest(){
		   
	   }
	
	   public int findKth(int[] nums, int k) {
		   int i=0, j=nums.length-1, pivotIdx;
		   
		   for(;;) {
			   pivotIdx = partition(nums, i, j);
			   if(pivotIdx < nums.length-k)
				   	i = pivotIdx+1;
			   else if(pivotIdx > nums.length-k)
				    j = pivotIdx-1;
			   else
				   	break;
		   }
		   return nums[pivotIdx];
		   
	   }
	   
	   private int partition(int[] nums, int lo, int hi) {
		   
		   int i=lo, j, pivot=nums[lo];
		   
		   for(j=lo+1; j<=hi; j++) {
			   
			   if(nums[j]<=pivot) {
				   swap(nums, i+1, j);
				   i++;
			   }
		   }
		   swap(nums, i, lo);
		   return i;
		   
	   }
	   
	   private void swap(int[] nums, int i, int j) {
		   int temp = nums[i];
		   nums[i] = nums[j];
		   nums[j] = temp;
		   return ;
	   }
	
	
	public static void main(String[] args) {
	
	int[] arr = {7,3,5,4,6,2,1,8};
	int k=5;
		
	findKthLargest obj = new findKthLargest();
	System.out.println(k+"th largest element is " + obj.findKth(arr, k));
	
	
	
	
}
	
}

 