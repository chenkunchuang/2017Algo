import java.util.*;

/*
 *  This class is for indeed 面經
 *  https://instant.1point3acres.com/thread/267448
 */
public class SeparateList {
    //use treeMap and comparator to sorted the value
	private HashMap<Character, Integer> map;
	private int occu;
	private char key;
	
	public SeparateList(){
		map = new HashMap<>();
		occu = Integer.MIN_VALUE;
	}
	
	public int count(String s) {
		char[] chars = s.toCharArray();
		for(char c: chars) {
			map.put(c, map.getOrDefault(c, 0)+1);
		}
		//find the most occurance of char
		for(Map.Entry<Character, Integer> entry: map.entrySet()) {
			if(entry.getValue()>occu) {
				occu= entry.getValue();
				key = entry.getKey();
			}
		}
		return occu;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SeparateList obj = new SeparateList();
		String s = "aabbefghb";
		
		int occu = obj.count(s);
		List<List<Character>> lists = new ArrayList<>();
		//ArrayList<Character>[] list = new ArrayList<Character>[occu];
		
		//really dump method
		for(int j=0; j<obj.map.get(obj.key);j++){
			List<Character> list = new ArrayList<>();
			list.add(obj.key);
			lists.add(list);
		}
		
		obj.map.remove(obj.key);
		
		int i=0;
		for(Map.Entry<Character, Integer> entry: obj.map.entrySet()) {
			int j = entry.getValue();
			char c = entry.getKey();
			while(j-->0) {
				lists.get(i).add(c);
				i=(i+1)%occu;
			}	
		}
		
		for(int j=0; j<lists.size(); j++) {
			System.out.println(lists.get(j));
		}
		
		return;
		
	}

}
