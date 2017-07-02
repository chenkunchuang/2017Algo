package dynamicProgramming;

public class PaintHouse {

	public int minCost(int[][] costs) {{
        // Write your code here
        
        if(costs.length==0) return 0;
        
        int[][] ret = new int[costs.length+1][costs[0].length];
        int retMinCostPaint = Integer.MAX_VALUE;
        //System.out.println("num of rows " + costs.length);
        //System.out.println("num of columns " + costs[0].length);
        
        for(int i=0; i<costs[0].length; i++ )
            ret[0][i]=0;
            
        for(int i=0; i<costs[0].length; i++)
        {
            ret[1][i] = costs[0][i];
            //System.out.println("cost "+costs[0][i]);
        }
        
        //calculate
        for(int i=2; i<=costs.length; i++)
        {
        	int minCostPaint = Integer.MAX_VALUE;
        	for(int j=0; j<costs[0].length; j++) {
        		for(int k=0; k<costs[0].length; k++) {
        			if(k!=j && ret[i-1][k]<minCostPaint)
        				minCostPaint = ret[i-1][k];
        			
        		}
        		ret[i][j] = costs[i-1][j] + minCostPaint;
        		
        	}
        	
            
        }
        
        for(int j=1; j<costs[0].length; j++)
        {    
            if(retMinCostPaint>ret[costs.length][j])
            	retMinCostPaint = ret[costs.length][j];
        }
        
        
        return retMinCostPaint;
       
    }}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PaintHouse obj = new PaintHouse();
		int[][] costs = {{14,2,11},{11,14,5},{14,3,10}};
		System.out.println("min cost " + obj.minCost(costs));
		
		

	}

}
