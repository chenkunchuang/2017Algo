
public class CubicRoot {

	public int find(int n) {
		
		if(n==0)
			return 0;
		
		int left = n<0?n:1;
		int right = n<0?-1:n;
		int mid = left+(right-left)/2;
		while(true) {
			mid = left+(right-left)/2;
			if(mid*mid*mid>n)
				right = mid-1;
			else {
				if((mid+1)*(mid+1)*(mid+1)>n)
					return mid;
				left=mid+1;
			}
		}
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CubicRoot sol = new CubicRoot();
		System.out.println("sol1 " + sol.find(8));
		System.out.println("sol2 " + sol.find(-9));
		System.out.println("sol3 " + sol.find(-39));
		
	}	

}
