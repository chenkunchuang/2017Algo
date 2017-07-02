package backTracking;

import java.util.*;
import java.util.List;

public class LargestNumber {
	private int globalMax;
	
	public int findLargest(int[] nums) {
		
	 int localMax =0 ; 
	 //int globalMax=0;
	 this.globalMax=0;
	 List<Integer> list = new ArrayList<>();
	 boolean[] visited = new boolean[nums.length];
		
	  findRecursive(nums, 0, list, visited, localMax);
	  //System.out.println("list size " + list.size());
	  for(int n: list)
		  System.out.print(" " + n);
	  
	  return globalMax;
		
	}
	
	public void findRecursive(int[] nums, int level, List<Integer> list, boolean[] visited, int localMax) {
		
		if(level == nums.length )
		{
			list.add(localMax);
			if(localMax>globalMax)
				globalMax=localMax;
			return;
		}
		
		
		for(int i=0; i<nums.length; i++) {
			if(visited[i]==false) {
				visited[i] = true;
				double digit=0.0;
				int temp=nums[i];
				while(temp>0) {
					digit++;
					temp/=10;
				}
				//System.out.println("digit " + digit);
				localMax = ((int)(localMax*Math.pow(10.0, digit)) + nums[i]);
				findRecursive(nums, level+1, list, visited, localMax);
				localMax = (localMax-nums[i])/((int)Math.pow(10.0, digit));
				visited[i] = false;
			}
		}
		
		
		return;
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] nums = {3, 30, 34, 5, 9};
		LargestNumber obj = new LargestNumber();
		//obj.findLargest(nums);
		
		System.out.println(" the largest permutation number " + obj.findLargest(nums));

	}

}
