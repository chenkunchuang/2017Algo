
public class RemoveWhiteSpace {
	
	public void remove(String so) {
		String s = so.trim();
		
		int wp=0;
		char[] chars = s.toCharArray();
		for(int i=0; i<chars.length; i++) {
			if(chars[i]!=' ') {
				chars[wp] = chars[i];
				wp++;
			}
		}
		//once i hits the end, null the strings. 
		System.out.println(String.valueOf(chars).substring(0, wp));
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RemoveWhiteSpace sol = new RemoveWhiteSpace();
		
		sol.remove("  ad   gg   hh       ");
		sol.remove("  a   d d ee  dd   we");
	}

}
