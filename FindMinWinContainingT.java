/***
 * LC 76
 * Given a set T of characters and a string S, 
 * find the minimum window in S which will contain all the characters in T in complexity O(n).
 eg,
 S = “ADOBECODEBANC”
 T = “ABC”

Minimum window is “BANC”.

 * @author cchuang
 *
 */

public class FindMinWinContainingT {
	
	public String findMinWin(String s, String T) {
		 
		 //String ret = "";
		 // to store occurances of each charater in T
		 int[] needFind = new int[256];
		 // to store occurance of characters so far in s
		 int[] hasFound = new int[256];
		 // two pointers to find the window
		 int start =0, end=0;
		 
		 int WinStart=0, WinEnd=0;
		 
		 // the count to record the length of string --> if count==T.length(), found all characters in T
		 int count=0;
		 
		 // to record min length
		 int minLen=s.length();
		 
		 // find charaters in T
		 for(int i=0; i<T.length(); i++) {
			 needFind[T.charAt(i)]++;
		 }
		 
		 for(end=0;end<s.length();end++) {
			 // if character is not in T, skip it
			// if(needFind[s.charAt(end)]==0)
			//	 continue;
			 hasFound[s.charAt(end)]++;
			 
			 // find desired character from T in S 
			 // because we are finding min window so only count length if hasFound is less
			 // than needFind
			 if( hasFound[s.charAt(end)]<=needFind[s.charAt(end)]) 
				 count++;
			 
			 // check if the window is met
			 if(count==T.length()) {
				 // only advance start pointer when hasFound has more characters than needFind
				 // it could be either characters are not needed or more characters than required in T
				
				 //while(needFind[s.charAt(start)]==0 || mnm.lslsl  
				 while(hasFound[s.charAt(start)]>needFind[s.charAt(start)]) {
					 //if(hasFound[s.charAt(start)]>needFind[s.charAt(start)])
					    hasFound[s.charAt(start)]--;
					 start++;
				 }
				 WinStart = start;
				 WinEnd = end;
			 }
				 			
			
	     }
		 System.out.println("WinStart " + WinStart+" WinEnd " + WinEnd);
		return count==T.length()?s.substring(WinStart, WinEnd+1):"";
	}	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FindMinWinContainingT obj = new FindMinWinContainingT();
		System.out.println(obj.findMinWin("ADOBECODEBANC", "ABC"));
	}

}
