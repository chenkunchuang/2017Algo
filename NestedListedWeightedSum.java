import java.util.*;

/*
 * Given a nested list of integers, return the sum of all integers in the list weighted by their depth.

Each element is either an integer, or a list -- whose elements may also be integers or other lists.

Example 1:
Given the list [[1,1],2,[1,1]], return 10. (four 1's at depth 2, one 2 at depth 1)

Example 2:
Given the list [1,[4,[6]]], return 27. (one 1 at depth 1, one 4 at depth 2, and one 6 at depth 3; 1 + 4*2 + 6*3 = 27)
 */


public class NestedListedWeightedSum {
    /*
  	class NestedList {
		private List<Integer> nestedList;
		
		public NestedList(List<Integer> nestedList) {
			this.nestedList = new ArrayList<>();
		}
		
	}
	*/
	
	public int weightedSum(List<List<Integer>> nestedList) {
		
		return helper(nestedList, 1);
		
	}
	
	public int helper(List<List<Integer>> nestedList, int depth) {
		
		 int sum=0;
		 
		 int size = nestedList.size();
		 System.out.println("nestedSize " + size);
		 for(int i=0; i<size; i++){
		  	 
		 List<Integer> list = nestedList.get(i);
		 if(list.size()==1)
			 sum+=list.get(0)*depth;
		 else {
			 int listSize = list.size();
			 //sum+=helper(list, depth+1);
			 for(int j=0; j<listSize; j++)
				 sum+=list.get(j)*depth;
		  }
		  depth++;
		 }
		 
		return sum;
	}
	
	
	 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		NestedListedWeightedSum obj = new NestedListedWeightedSum();
		List<List<Integer>> nestedList = new ArrayList<>();
		List<Integer> list = new ArrayList<>();
		//adding test cases
		//list.add(1);
		list.add(1);
		nestedList.add(list);
		list.clear();
		list.add(2);
		nestedList.add(0,list);
		
		//list.clear();
		//list.add(2);
		//nestedList.add(0,new ArrayList<Integer>(list));
		
		//list.clear();
		//list.add(1);
		//list.add(1);
		//nestedList.add(new ArrayList<Integer>(list));
		
		for(List<Integer> e: nestedList) {
			System.out.println("nestedList " + e.subList(0,e.size()));
		}
		
		System.out.println("sum = " + obj.weightedSum(nestedList));
		
		
	}

}
