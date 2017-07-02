package backTracking;
import java.util.*;

/*
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
For example, given n = 3, a solution set is:
[
  "((()))",
  "(()())",
  "(())()",
  "()(())",
  "()()()"
]
 
 */

public class GenerateParenthesis {
	public List<String> generate(int n) {
		List<String> comb = new ArrayList<>();
		genF(n, n, "", comb);
		return comb;
	}
	
	public void genF(int left, int right, String s, List<String> comb) {
		 if(left> right)
	            return;
	        
	        if(left==0&&right==0)
	        {
	            comb.add(new String(s));
	            return;
	        }    
	        
	        //adding left
	        if(left>0) {
	            genF(left-1, right, s+"(", comb);
	            //s.deleteCharAt(s.length()-1);
	        }
	        //adding right
	        if(right>0) {
	            //s.append(")");
	            genF(left, right-1, s+")", comb);
	            //s.deleteCharAt(s.length()-1);
	        }
	        return;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GenerateParenthesis obj = new GenerateParenthesis();
		System.out.println(obj.generate(3).toString());

	}

}
