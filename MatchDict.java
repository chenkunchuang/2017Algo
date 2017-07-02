import java.util.*;

/* Yahoo 6/7 phone screen
 * Q2: If the whitelist contain multiple words in one line? (like, “hello world”)
 * Key
=========
hello world
hi
maybe tomorrow afternoon
=========
String
could you say hello to everybody -> false
could you say hello world to everybody -> true
could you say hello abc world to everybody -> false

 */
public class MatchDict {
	
	HashMap<String, String> map;
	
	//constructor
	public MatchDict(String[] keys) {
		map = new HashMap<>();
		
		for(String s: keys) {
			System.out.println("key " + s);
			int i=0;
			while(i<s.length()&&s.charAt(i)!=' ')
				i++;
			map.put(s.substring(0,i), s);
			
		}
	}
	
	public boolean matchKey(String s) {
		int i=0;
		while(i<s.length()) {
			int start = i;
			//need to check i<s.length() because you might reach to last word and no white space at the end
			while(i<s.length()&&s.charAt(i)!=' ')
				i++;
			String key = s.substring(start, i);
			if(map.containsKey(key) )
			{
				String value = map.get(key);
				if(s.substring(start, start + value.length()).equals(value))
					return true;
					
			}
			i++;
		}
		return false;
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String[] keys ={"hello world", "hi", "maybe tomorrow afternoon"};
		MatchDict sol = new MatchDict(keys);
		System.out.println("test1 " + sol.matchKey("could you say hello to everybody"));
		System.out.println("test2 " + sol.matchKey("could you say hello world to everybody"));
		System.out.println("test3 " + sol.matchKey("could you say hello abc world to everybody"));
		System.out.println("test4 " + sol.matchKey("could you say hi abc world to everybody"));
	}

}
