import java.util.Arrays;
import java.util.*;

public class RearrangeMinMax {
	
	public void rearrange(int[] nums) {
		
		Arrays.sort(nums);
		/* merge sort method. time: O(NlogN) space O(N)
		int[] temp = Arrays.copyOf(nums, nums.length);
		int left=0, right=((nums.length+1)/2);
		
		for(int i=0; i<nums.length; i++) {
			if(i%2==0)
				nums[i] = temp[left++];
			else
				nums[i] = temp[right++];
		}
		//List<Integer> list = Arrays.asList(nums);

		 */
		// use median way --> find median and num>median put in even idx; otherwise odd index
		
		
		
		for(int num: nums) {
			System.out.print(" " + num);
		}
		return;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {2,3,1,5,6,4,8,7,10,15};
		RearrangeMinMax obj = new RearrangeMinMax();
		
		obj.rearrange(nums);
		
		return;
	}

}
