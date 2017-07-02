/*
 * Given an integer array of size n, find all elements that appear more than ⌊ n/3 ⌋ times. 
 * The algorithm should run in linear time and in O(1) space.
 */
import java.util.*;
public class majorityElement {
	
	public List<Integer> findMajorities(int[] nums){
		  List<Integer> ret = new ArrayList<>();
	        //if(nums.length==0) return ret;
	        int count0=0, count1=0;
	        //using random number and make sure both are different
	        int max0=0, max1=1;
	        
	        for(int num: nums)
	        {
	            if(num==max0)
	            {
	                count0++;
	            }
	            else if(num==max1)
	            {
	                count1++;
	            }
	            else if (count0==0)
	            {
	                max0=num;
	                count0=1;
	            }
	            else if(count1==0)
	            {    
	                max1=num;
	                count1=1;
	            }
	            else 
	            {
	                count0--;
	                count1--;
	            }
	            
	            //System.out.println("max0 " + max0 + " max1 " + max1 + " count0 " + count0 + " count1 " + count1);
	        }
	        
	        
	        count0=0;
	        count1=0;
	        
	        
	        for(int num:nums)
	        {
	          if(num==max0)
	            count0++;
	          else if(num==max1)
	            count1++;
	        }
	        //System.out.println("count0 " + count0 + " count1 " + count1);
	        
	        if(count0>nums.length/3)
	            ret.add(max0);
	        if(count1>nums.length/3)
	            ret.add(max1);
	        
	        return ret;    
		
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr ={8,8,7,7,7,4,8,5,8,7};
		
		majorityElement obj = new majorityElement();
		
		System.out.println(obj.findMajorities(arr).toString());
		

	}

}
