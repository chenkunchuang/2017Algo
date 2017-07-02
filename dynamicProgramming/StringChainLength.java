package dynamicProgramming;
import java.util.*;
/*
 *  You are given a library with n words(w[0], w[1], ..., w[n-1]), you choose a word from it and in each step, remove one letter
 *  from this word only if doing so yields another word in library. What is th longest possible chain of these removal steps?
 *  For example, you are given "a", "b", "ba", "bca", "bda", "bdca"
 *  the length of chain is 4 "bdcd"-->"bca"-->"ba"-->"a". For a better answer to exist, the length of the selected first word
 *  should be greater than 4. In our test case, such a word does not exist. 
 */

public class StringChainLength {

	private int[] dp;
	
	//private String s;
	
	// This is compared in descending order 
	/*class lengthCompare implements Comparator<String>
	{
		
	@Override
    public int compare(String s1, String s2) {
		if(s1.length()>s2.length())
			return s2.length()-s1.length();
		else if(s1.length()<s2.length())
			return s2.length()-s1.length();
		else
			return 0;
	}
	} */
	
	
	public int solution(String[] library) {
		//init length
		int len=1;
		dp = new int[library.length+1];
		Arrays.fill(dp, 1);
		
		//Arrays.sort(library, new lengthCompare());
		
		Arrays.sort(library, new Comparator<String>() {
			@Override
		    public int compare(String s1, String s2) {
				if(s1.length()>s2.length())
					return s2.length()-s1.length();
				else if(s1.length()<s2.length())
					return s2.length()-s1.length();
				else
					return 0;
			}
			
			
		});// the right bracket is for sort() <--- this side on the right
		
		for(String s: library)
			System.out.println(s);
		
		// use dictionary for quick look-up to determine if removed-letter string exists. 
		HashSet<String> dict = new HashSet<>();
		
		for(String s: library)
			dict.add(s);
		
		for(int i=0; i<library.length-1; i++) {
			// dp[i] = dp[i-1] + 1(if current string can be reached from previous by removing one letter)
			len = Math.max(pathfind(dp, library, i, i+1), len);
			
			
			
		}
		return len;
		
	}
	// do dynamic programming for each given string to see how far it can go. 
	
	public int pathfind(int[] dp, String[] library, int curr, int next ) {
		   
		   // need to consider neightbor string has the same length --> condition <= 1
		   while(next<library.length&&library[curr].length()-library[next].length()<=1) {
			   if(isConnected(library[curr], library[next])==true&&!library[curr].equals(library[next])) 
				   dp[next] = Math.max(dp[next], dp[curr]+1);
			  // System.out.println("dp["+Integer.toString(next)+"] " + dp[next]);
			   next++;
		   }
		   //System.out.println("dp["+Integer.toString(next-1)+"] " + dp[next-1]);
		   return dp[next-1];
		
	}
	
	//recursive 
	/*
	public int DFS(int[] dp, String[] library, int currentIdx, int nextIdx, int locallen ) {
		
		System.out.println("s1 " + library[currentIdx] + " s2 " + library[nextIdx]);
		if(locallen==library[0].length() || nextIdx==library.length || 
				library[currentIdx].length()-library[nextIdx].length() >1)
			return locallen;
		
		// skip the same length
		if(library[currentIdx].length()-library[nextIdx].length()==0 && nextIdx+1<library.length)
			nextIdx++;
			
			
		
		char[] c1 = library[currentIdx].toCharArray();
		Arrays.sort(c1);
		
		char[] c2 = library[nextIdx].toCharArray();
		Arrays.sort(c2);
		if(isConnected(String.valueOf(c1), String.valueOf(c2)) ) {
			dp[nextIdx]+=1;
			locallen = DFS(dp, library, nextIdx, nextIdx+1, locallen+1);
		}
		
		return locallen;
	}
	*/
	// Assume s1 length is larger then s2 and only move idx2 when there's a match. 
	public boolean isConnected(String s1, String s2) {
		
		//StringBuilder sb1 = new StringBuilder(s1);
		
		for(int i=0; i<s1.length(); i++) {
			StringBuilder sb1 = new StringBuilder(s1);
			if(sb1.deleteCharAt(i).toString().equals(s2)==true)
				return true;
		}
		return false;
		
		
		/*
		//boolean ret = false;
		int idx2=0;
		// store how many letters are removed and early return if remove>1
		int remove=0;
		for(int idx1=0; idx2<s2.length()&&idx1<s1.length()&&remove<=1; idx1++) {
			if(s1.charAt(idx1)==s2.charAt(idx2))
			{
				idx2++;
			}
			else {
				remove++;
			}
		}
		//System.out.println("s1 " + s1 + " s2 " + s2+" idx2 " + idx2);
		
		return idx2==s2.length()?true:false;
		*/
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StringChainLength obj = new StringChainLength();
		String[] library = {"a", "b", "ba", "bca", "bda", "bdca", "bdcae", "bdce", "abdcae"};
			//{"a", "b", "ba", "bca", "bda", "bdca"};
			//{"a", "b", "ba", "bca", "bda", "bdca", "bdcae", "bdce", "abdcae"};
		long startTime = System.nanoTime();
		System.out.println("the longest len "+obj.solution(library));
		long endTime = System.nanoTime();
		System.out.println("processing " + Long.toString(endTime-startTime));
	}

}
