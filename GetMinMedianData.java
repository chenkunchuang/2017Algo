import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class GetMinMedianData {
	
	//private TreeMap<Integer, Integer> map;
	private int sum;
	private int size;
	private int[] map;
	public GetMinMedianData() {
		//map = new TreeMap<>();
		sum = 0;
		size=0;
		map = new int[1000];
	}
	
	public void insert(int num) {
		size+=1;
		sum+=num;
		map[num]++;
		//map.put(num, map.getOrDefault(num, 0)+1);
		
		return;
	}
	
	public int getMean() {
		return sum/size;
		
	}
	
	public int getMedian() {
		int median=0;
		//even
		if(size%2==0) {
			int num1 = size/2;
			
			for(int i=0; i<1000; i++) {
				num1-=map[i];
				if(num1<0) {
					median = i;
					break;
				}
				else if(num1==0) {
					int temp1 = i;
					//i++;
					while(i<1000) {
						if(map[++i]>0)
							break;
					}
					median = (temp1+i)/2;
					break;
				}
			}
			
			/*
			for(Map.Entry<Integer, Integer> entry: map.entrySet()) {
				num1 -=entry.getValue();
				if(num1)
			}*/
		}
		else {
			int num1 = size/2+1;
			for(int i=0; i<1000; i++) {
				num1-=map[i];
				if(num1<=0) {
					median = i;
					break;
				}
				
			}
		}
		return median;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GetMinMedianData obj = new GetMinMedianData();
		obj.insert(109);
		obj.insert(5);
		obj.insert(190);
		
		System.out.print("mean " + obj.getMean()+ " median " + obj.getMedian());
	}

}
