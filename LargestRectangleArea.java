import java.util.*;

public class LargestRectangleArea {
	
	public int findMax(int[] heights){
		
		// Use stack to store index of the array and this stack only stores monotonic idx
	     Stack<Integer> stack = new Stack<>();
	     
	     //Have a array of the heights +1 which is 0. In this way, we know where is the last element to stop.
	     int[] h = new int[heights.length+1];
	     h = Arrays.copyOf(heights, heights.length+1);
	     
	     int areaMax=0;
	     int iter=0;
	     
	     while(iter<h.length) {
	         
	         if(stack.isEmpty() || h[stack.peek()]<=h[iter])
	            stack.push(iter++);
	            
	         else
	         {
	             int idx = stack.pop();
	             areaMax = Math.max(areaMax, h[idx]*(stack.isEmpty()?iter:iter-stack.peek()-1) );
	         }
	         
	     }
	     
	        return areaMax;
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {2,1,5,6,2,3};
		LargestRectangleArea obj = new LargestRectangleArea();
		
		System.out.println("the max rectangle area " + obj.findMax(arr));
		
	}

}
