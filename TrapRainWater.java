/**
 * Given n non-negative integers representing an elevation map where the width of each bar is 1, 
 * compute how much water it is able to trap after raining.
 * 
For example, 
Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.

 */

/**
 * @author cchuang
 *
 */
public class TrapRainWater {

	public int trap(int[] height) {
		  
		// Use two pinters to find the position for area
        int left=0, right=height.length-1;
        
        //This areaTotal variable will be used to accumulate the total area
        int areaTotal=0;
        
        //whatever side is less, move this side toward center
        while(left<right) {
            
            //store min
            int tempMin = Math.min(height[left], height[right]);
            
            if(height[left]==tempMin)
            {
                left=left+1;
                while(left<right && height[left]<=tempMin)
                {
                    areaTotal+=(tempMin-height[left]);
                    left++;
                }          
            }
            else
            {
                right=right-1;
                while(left<right && height[right]<=tempMin)
                {
                    areaTotal+=tempMin-height[right];
                    right--;
                }
            }   
        }
        return areaTotal;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
		
		TrapRainWater obj = new TrapRainWater();
		System.out.println("The total water trap " + obj.trap(height));

	}

}
