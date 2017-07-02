
public class maxProduct {

	public int findMaxProduct(String[] words) {
		// Use mask to determine if there's a common letter between strings.
        // all strings are lower case, a to z which are totally 26 possibilities. 
        // use int ->32bit
        
        // Array to store letters for string
        int[] maskLetter = new int[words.length];
        
        for(int pos=0; pos<words.length; pos++)
        {
            for(int idx=0; idx<words[pos].length(); idx++)
            {
                 int leftShift = words[pos].charAt(idx)-'a';
                 maskLetter[pos]|=1<<leftShift; 
            }
        }
        
        int retMax=0;
        
        for(int iter=0; iter<maskLetter.length-1; iter++) {
            for(int pos=iter+1; pos<maskLetter.length; pos++)
            {
                if((maskLetter[iter]&maskLetter[pos])==0)
                {
                    retMax = Math.max(retMax, words[iter].length()*words[pos].length());
                }
            }
            
        }
        
        return retMax;
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] s = {"abcw","baz","foo","bar","xtfn","abcdef"};
		
		maxProduct obj = new maxProduct();
		
		System.out.println("The max product of two string "+ obj.findMaxProduct(s));
		
		

	}

}
