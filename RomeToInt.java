
public class RomeToInt {

	public int convert(String s) {
		
		int val=0;
		
		
		for(int i=s.length()-1; i>=0; i--) {
			
			switch(s.charAt(i)) {
			
				case 'I':
					val+=val>5?-1:1;
					break;
				case 'V':
					val+=5;
					break;
				case 'X':
					val+=(val>50?-1:1)*10;
					break;
				case 'L':
					val+=50;
					break;
			}
		}
		return val;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RomeToInt sol = new RomeToInt();
		String s = "XLVII";
		System.out.println(s + " is " + sol.convert(s));
	}

}
