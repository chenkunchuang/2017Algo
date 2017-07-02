import java.util.*;

public class FindSumPair {

	public void findPair(List<Integer> list) {
		System.out.println("enter findpair ");
		HashMap<Integer, List<List<Integer>>> map = new HashMap<>();
		
		List<Integer> pair = new ArrayList<>();
		
		for(int i=0; i<list.size()-1; i++) {
			//for(int j=i+1; j<list.size(); j++) 
			{
				if(list.get(i)!=list.get(i+1)) {
				int sum = list.get(i) + list.get(i+1);
				
				//System.out.println("sum " + sum + " i " + list.get(i) + " j " + list.get(i+1));
				//List<List<Integer>> pairs = map.getOrDefault(sum, new ArrayList<>()); 
				pair.add(list.get(i));
				pair.add(list.get(i+1));
				/*
				if(map.containsKey(sum)!=true) {
					// This is wrong since you actually create a list, not a list of list
					//map.put(sum, new ArrayList(pair));
					
					//map.put(sum, new ArrayList().add(pair));
					
				}
				
				//else
				{
					List<List<Integer>> pairs = map.get(sum);
					if(pairs.contains(pair)!=true)
						pairs.add(new ArrayList(pair));
					map.put(sum, pairs);
				}
				*/
				List<List<Integer>> alist = map.getOrDefault(sum, new ArrayList<>());
				if(alist.contains(pair)!=true)
					alist.add(new ArrayList(pair));
				
				map.put(sum, alist);
				
				pair.clear();
			}
			}
			
		}
		
		System.out.println("map size " + map.size());
		
		for(Map.Entry<Integer, List<List<Integer>>> entry: map.entrySet()) {
			//System.out.println("sum " + entry.getKey() + " value" + entry.getValue()+ " size " + entry.getValue().size());
			
			if(entry.getValue().size()>1) {
				System.out.print(entry.getKey() + " :");
			for(List<Integer> pairlist: entry.getValue())
				System.out.print("("+pairlist.get(0) + "," + pairlist.get(1)+") ");
			
			System.out.println();
			}
			
		}
 		
		return;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] ar = {1,7,4,6,2,3,5,6};
		//Arrays.sort(ar);
		List<Integer> list = new ArrayList<>();
		for(int n: ar)
			list.add(n);
		
		FindSumPair obj = new FindSumPair();
		
		obj.findPair(list);

	}

}
