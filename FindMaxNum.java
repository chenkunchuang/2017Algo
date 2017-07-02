import java.util.*;
/*
 *  Given an array of integer, one digit per element, find the max number(combine all digits together) when
 *  you can only swap elements once. i.e., [1,7,7] ->[7,7,1]
 *  FB面經 https://instant.1point3acres.com/thread/202668
 */
public class FindMaxNum {
	
	public void findMax(int[] nums) {
		//traverse from the end to the start and record the maxVal and max index
		// if new max value is found at the start, don't update the value because
		// the max value in most significant digit should not be changed
		int maxIdx=-1, minIdx=-1, maxVal=Integer.MIN_VALUE;
		// this is to store the temp index for current maxVal index but don't update maxVal yet
		// because you only swap when the higher digit position value is smaller so don't update maxVal yet
		// like 58753 --> when move from 3->5->7->8 you only store index to temp
		// once hit last 5--> update min and max index
		// this can also deal with most significant digit has the largest val
		// 83745 --> 7->3: update min and max index and when hit 8, only update maxVal and temp index
		int temp=-1;
		for(int i=nums.length-1; i>=0; i--) {
			
			if(nums[i]>maxVal) {
				temp=i;
				maxVal=nums[i];
			}
			// only update when seeing decrease. i.e., inceaseing order will only keep track of temp index
			// and maxVal
			else {
				minIdx=i;
				maxIdx=temp;
			}
			
		}
		// if there's no min is found, just return--> meaning you CANT find any maxval by swapping.
		if(minIdx==-1)
			return;
		
		//swap index
		int tempVal = nums[minIdx];
		nums[minIdx] = nums[maxIdx];
		nums[maxIdx] = tempVal;
		
		return;
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FindMaxNum obj = new FindMaxNum();
		int[] nums = {8,7,6,5,3};
		//int[] nums = {1,7,7};
		obj.findMax(nums);
		
		System.out.println(Arrays.toString(nums));
		
		List<Integer> list = new ArrayList<>();
		
		for(int i=10; i>=0; i-=2)
			list.add(i);
		
		System.out.println("list " + list);
		
	}

}
