package dynamicProgramming;
/*
*
*There is a fence with n posts, each post can be painted with one of the k colors.
You have to paint all the posts such that no more than two adjacent fence posts have the same color.
Return the total number of ways you can paint the fence.
*
*/

public class PaintFence {

	public int numWays(int n, int k) {
        // Write your code here
        
        if(n==0) return 0;
        
        //init the previous adjacent different color to k colors
        // Assuming no post and the 1st post will be k different colors.
        int waysPrev=k;
        int[] waysTotal = new int[n+1];
        
        //init value for dynamic programming array
        waysTotal[0]=0;
        
        //total ways of colors for 1st post
        waysTotal[1]=k;
        
        //starting ways from 2nd post to n
        for(int iter=2; iter<=n; iter++) {
            //total ways can be divided into two cases
            // 1. adjacent color is different -> (previous post total ways) * (k-1) <-- minus 1 from previious color since k colors
            // 2. adjacent color is same -> This equals to previous post with different adjacent colors since you can only have at most 2 same adjacent colors.
            
            int waysSame = waysPrev;
            waysPrev = waysTotal[iter-1]*(k-1);
            waysTotal[iter] = waysSame + waysPrev;
        }
        
        return waysTotal[n];
        
        
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		PaintFence obj = new PaintFence();
		System.out.println("Total number of ways to paint fence " + obj.numWays(5, 3));

	}
	
}
