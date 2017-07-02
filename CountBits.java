/* This is using dynamic programming concept
 *  
 */

import java.util.*;

public class CountBits {
	
	public int[] count(int num) {
		
		int[] ret = new int[num+1];
		
		for(int i=1; i<=num; i++) {
			
			if((i&(i-1))==0)
				ret[i] =1;
			else {
				
				ret[i] = ret[i&(i-1)] +1;
				
			}
				
		}
		return ret;
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub                    
		
		CountBits obj = new CountBits();
		
		System.out.println(Arrays.toString(obj.count(14)));
		
		

	}

}
