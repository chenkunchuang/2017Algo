package backTracking;
import java.util.*;

/*
 * Given a collection of distinct numbers, return all possible permutations.
 * For example,
 * [1,2,3] have the following permutations:
 * [[1,2,3],
 * [1,3,2],
 * [2,1,3],
 * [2,3,1],
 * [3,1,2],
 * [3,2,1]]
 */

public class Permutation {	
	/*
	 * base function to do permute
	 */
	public List<List<Integer>> permute(int[] nums) {
        
	    List<List<Integer>> combSet = new ArrayList<>();
	    List<Integer> comb = new ArrayList<>();
	    int[] visited = new int[nums.length];
	    
	    permuteDFS(nums, 0, visited, combSet, comb);
	    return combSet;
    }

	/* Helper function to do backtracking.
	 * backtracking is usually use recursive + DFS to solve the combo results
	 * level: the depth of the recursive and level will be the size of nums -> permutation
	 */
	public void permuteDFS(int[] nums, int level, int[] visited, List<List<Integer>> combSet, List<Integer>comb) {
		
		if(level==nums.length)
		{
			combSet.add(new ArrayList(comb));
			return;
		}
		
		//recursive call + DFS(using stack)
		for(int i=0; i<nums.length; i++) {
			
			//if not visisted, push to stack and marked as visited
			if(visited[i]==0) {
				visited[i]=1;
				comb.add(nums[i]);
				permuteDFS(nums, level+1, visited, combSet, comb);
				comb.remove(comb.size()-1);
				visited[i]=0;
			}
		}
		return;
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {1,2,3};
		Permutation obj = new Permutation();
		
		System.out.println("permutaion cases: " + obj.permute(arr).size());
		System.out.println(obj.permute(arr).toString());
		
		
	}

}

