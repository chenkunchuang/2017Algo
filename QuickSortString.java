
public class QuickSortString {
	
public void quickSort(String[] nums) {
		
		quickSort(nums, 0, nums.length-1);
		return;
	}
	
	private void quickSort(String[] nums, int lo, int hi) {
		
		if(lo>=hi) return;
		
		int pivotIdx;
		pivotIdx = partition(nums, lo, hi);
		//System.out.println("pivot idx " + pivotIdx);
		quickSort(nums, lo, pivotIdx-1);
		quickSort(nums, pivotIdx+1, hi);
		
		return;
	}
	
	private int partition(String[] nums, int lo, int hi) {
		//assming first element is pivot
		int i=lo, j;
		String pivot =nums[lo];
		for(j=lo+1; j<=hi; j++) {
			if(nums[j].length()< pivot.length()) {
				swap(nums, i+1, j );
				i++;
			}
			else if(nums[j].length()== pivot.length()) {
					if(nums[j].compareTo(pivot)<0)
					{
						swap(nums, i+1, j);
						i++;
					}
				
			}
		}
		
		//finish partition and swap pivot with index i
		swap(nums, i,lo);
		return i;
	}
	
	private void swap(String[] nums, int i, int j) {
		String temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
		
		return;
	}
		
  
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] s = {"abc", "a", "b", "ade", "ad"};
		QuickSortString obj = new QuickSortString();
		
		obj.quickSort(s);
		for(String temp: s) {
			System.out.println(temp);
		}
		
	}

}
