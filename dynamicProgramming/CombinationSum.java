package dynamicProgramming;
/*
 * This is to find out all possible combination for a given target value 
 * This type of questions, like to find out a list of return values, 
 * DFS will be your good friend 
 * 
 */

import java.util.*;

public class CombinationSum {

public List<List<Integer>> combinationSum(int[] candidates, int target) {
        
        List<List<Integer>> combSum = new ArrayList<>();
        ArrayList<Integer> sum = new ArrayList<>();
        
        dfsSum(0, target, candidates, combSum, sum);
        
        return combSum;
        
    }

/*
 * Given an integer array with all positive numbers and no duplicates, 
 * find the number of possible combinations that add up to a positive integer target.
 * 
 * This method is for dyanmic programming to calculate sum combination 4. 
 * Assuming i is target, DP[i] += DP[i-num] (Sum of all counts)
 * 
 */

public int combinationSum4(int[] nums, int target) {
	//Sort array first so we can break if i<num
	Arrays.sort(nums);
	
	//define a DP array.
	int[] dp = new int[target+1];
	//init i=0 the count is 1 meaning empty combo
	dp[0] =1;
	
	//Calculate from i=1 to target
	for(int i=1; i<=target; i++) {
		
		//loop thru all possible combinations for each i
		for(int num: nums)
		{
			if(i<num)
				break;
			else
			{
				dp[i]+= dp[i-num];
			}
		}
	}
	return dp[target];
}

/*
 * This function is to do DFS for Sum combination
 * based on the recursive start index passed, we can determine 
 * if the elements can be used only once or unlimited
 */

public void dfsSum(int start, int target, int[] arr, List<List<Integer>> combSum, ArrayList<Integer> sum) {
    if(target<0)
        return;
    else if(target == 0)
    {
    	//only add to the list if there's None for this combination
        if(!combSum.contains(sum))
            combSum.add(new ArrayList<>(sum));
        return;
    }
    else
    {
        for(int i=start; i<arr.length; i++)
        {
            sum.add(arr[i]);
            dfsSum(i, target-arr[i], arr, combSum, sum); // the start index will be i+1 if no element can be used twice
            sum.remove(sum.size()-1);
        }
    }
    
    return;
}
    /*
     * This is to find the sum given one element can be used once
     * and there's no duplicate combination
     */
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> combSum = new ArrayList<>();
        ArrayList<Integer> sum = new ArrayList<>();
        Arrays.sort(candidates);
        dfsSum(0, target, candidates, combSum, sum);
             
        return combSum;
        
        
    }
    
    
   
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {10,1,2,7,6,1,5};
		int target = 8;
		CombinationSum obj = new CombinationSum();
		System.out.println(obj.combinationSum2(arr, target).toString());
		System.out.println("DP Sum4 counts "+obj.combinationSum4(arr, 4));
		
		

	}

}

