
public class findKth {
	
	
	public int findKthinTwo(int[] nums1, int lo1, int hi1, int[] nums2, int lo2, int hi2, int k) {
		 
		 
	      int len1 = hi1-lo1+1, len2 = hi2-lo2+1;
	      
	       System.out.println("k " + k+" lo1 " + lo1 + " hi1 " + hi1 );
	       System.out.println(" lo2 " + lo2 + " hi2 " + hi2 );
	      if(len1>len2) return findKthinTwo(nums2, lo2, hi2, nums1, lo1, hi1, k);
	      
	      if(len1==0&&k>0) return nums2[lo2+k-1];
	      
	      if(len1==0) return nums2[lo2+k];
	     
	     
	      
	      if(k==1) return Math.min(nums1[lo1], nums2[lo2]);
	      
	      int p1 = k/2;//len1<=k/2?len1:k/2 ;
	      int p2 = k-p1;
	      
	      p1=p1+lo1;
	      p2=p2+lo2;
	      
	      System.out.println("p1 " + p1+ " p2 " + p2);
	     
	      if(nums1[p1-1]<=nums2[p2-1])
	        return findKthinTwo(nums1, p1, hi1, nums2, lo2, hi2, k-p1);
	      else
	        return findKthinTwo(nums1, lo1, hi1, nums2, p2, hi2, k-p2);
	        
	      
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		findKth obj = new findKth();
		int[] nums1 = {2,6};
		int[] nums2 = {1,4,5,7};
		int k = 6, i=0, j=0;
		int kth = obj.findKthinTwo(nums1, i,nums1.length-1, nums2, j,nums2.length-1, k) ;
		System.out.println(k+"th elment " +  kth);

	}

}
