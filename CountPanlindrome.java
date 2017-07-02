/***
 *  Count total panlindromatic substring of a string.
 *  1) each letter can be a panlindrome string
 *  2) elle as usually substring
 * @author cchuang
 *
 */

public class CountPanlindrome {
    // check if substring is palindrome
	public boolean isPalindrome(String s, int left, int right) {
    	
    	while(left<right) {
    		if(s.charAt(left)!=s.charAt(right))
    			return false;
    		left++;
    		right--;
    	}
    	return true;
    }
	
	public int solution(String s) {
		
		if(s.length()==0)
			return 0;
		// number of palindrome
		int count = s.length();
		// two loops to traverse all possible cases
		for(int i=0; i<s.length()-1; i++) {
			for(int j=s.length()-1; j>i; j--) {
				if(isPalindrome(s, i, j))
					count++;
			}
		}
		return count;
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CountPanlindrome obj = new CountPanlindrome();
		
		System.out.println("total number of palindrome " + obj.solution(""));

	}

}
