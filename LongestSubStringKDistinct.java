/*
 * 
 * [LeetCode] Longest Substring with At Most K Distinct Characters
 
Given a string, find the length of the longest substring T that contains at most k distinct characters.

For example, Given s = “eceba” and k = 2, T is "ece" which its length is 3.
 * @author cchuang
 *
 */
import java.util.*;
public class LongestSubStringKDistinct {

	public int helper(String s, int k) {
		// Use hashMap to store the number of occurance of each letter.
		// Then, traverse the string and check if hash map size > k which means you have more than k 
		// distinct letter so you need to remove one by moving the left pointer. 
		
		int left=0, maxLen=0;
		HashMap<Character, Integer> map = new HashMap<>();
		
		for(int i=0; i< s.length(); i++) {
			char c = s.charAt(i);
			map.put(c, map.getOrDefault(c, 0)+1);
            //System.out.println("char " +c + " num " + map.get(c));
			//check if more than k elements are in hash map
			while(map.size()>k) {
				int count = map.get(s.charAt(left));
				//System.out.println("while loop " + s.charAt(left)+" count " + count);
				if(count-1==0) map.remove(s.charAt(left));
				else {
					map.put(s.charAt(left), count-1);
					//left++;
				}
				left++;
			}
			System.out.println("i " +i +" left " + left + " maxLen " + maxLen);
			maxLen = Math.max(maxLen, i-left+1);
			//System.out.println("key set " + map.keySet().toString());
		}
		
		return maxLen;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LongestSubStringKDistinct obj = new LongestSubStringKDistinct();
		
		System.out.println(" The longest length "+obj.helper("ecebabbbdbba", 3));
	}

}
