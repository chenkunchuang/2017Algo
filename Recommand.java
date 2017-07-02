import java.util.*;
import java.lang.*;

public class Recommand {

	 public int[] determineRecommendation(String itemId, String[] purchases) {
	       
	        HashMap<String,ArrayList<String>> itemMap = new HashMap<>();
	        HashMap<String,ArrayList<String>> custMap = new HashMap<>();
	        
	        for(String s:purchases){
	            //Get customerID and item ID
	            String[] temp = s.split(":");
	            if(itemMap.get(temp[1]) ==null) {
	                itemMap.put(temp[1], new ArrayList<String>());
	                itemMap.get(temp[1]).add(temp[0]);
	            }
	            else
	            {
	                itemMap.get(temp[1]).add(temp[0]);
	            }
	            
	            if(custMap.get(temp[0]) ==null) {
	                custMap.put(temp[0], new ArrayList<String>());
	                custMap.get(temp[0]).add(temp[1]);
	            }
	            else
	            {
	                custMap.get(temp[0]).add(temp[1]);
	            }
	            //System.out.println(temp[0]);
	            //System.out.println(temp[1]);
	        }
	         
	        //System.out.println(Arrays.toString(itemMap.get("ABC").toArray()) );
	        //System.out.println(Arrays.toString(custMap.get("first").toArray()) );
	        
	        //Strong connected
	        List<String> customer = itemMap.get(itemId);
	        //System.out.println(Arrays.toString(customer.toArray()));
	        
	        List<String> strongConnect = new ArrayList<>();
	        for(String s:customer){
	            List<String> items = custMap.get(s);
	            //System.out.println(Arrays.toString( items.toArray()) );
	            for(String t:items)
	            {
	                if(!t.equals(itemId)&&!strongConnect.contains(t))
	                    strongConnect.add(t);
	            }    
	        }
	       System.out.println(Arrays.toString( strongConnect.toArray()) );
	        
	        //weakly connected
	        List<String> weaklyConnect = new ArrayList<>();
	        for(String s:strongConnect) {
	            List<String> cust = itemMap.get(s);
	            for(String t:cust) {
	                List<String> items = custMap.get(t);
	            for(String w:items) {
	            	if(!strongConnect.contains(w)&& !w.equals(itemId)&&!weaklyConnect.contains(w))
	            			weaklyConnect.add(w);
	            }  
	          }
	        
	        }
	        
	        //check all weakly connected items to see if they have any strongly connected items
	        List<String> weaklyConnect2 = new ArrayList<>();
	        for(String s:weaklyConnect) {
	        	weaklyConnect2.add(s);
	        }
	        
	        for(String s:weaklyConnect) {
	        	List<String> cust = itemMap.get(s);
	        	for(String t:cust) {
	        		List<String> i = custMap.get(t);
	        		for(String w:i) {
	        			if(!strongConnect.contains(w)&& !weaklyConnect.contains(w))
	        				weaklyConnect2.add(w);
	        		}
	        	}
	        }
	        System.out.println(Arrays.toString( weaklyConnect2.toArray()) );
	      
	        int[] ret = new int[2];
	        ret[0] = strongConnect.size();
	        ret[1] = weaklyConnect2.size();
	        return ret;
	    }
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String itemId="ABC";
		
		String[] purchases={"first:ABC","first:HIJ","sec:HIJ","sec:KLM","third:NOP","fourth:ABC","fourth:QRS",
				"first:DEF","fifth:KLM","fifth:TUV"};//,"fifth:HIJ"};
		
		Recommand obj = new Recommand();
		
		int[] a = {1,2,3};
		int[] b;
		b=a;
		
		System.out.println(Arrays.toString(b));
		int[] ret = obj.determineRecommendation(itemId,purchases);
		
		System.out.println(Arrays.toString(ret));
	}

}
