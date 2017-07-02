package UnionFind;

public class UnionFind <E> {
	
	private int[] father;
	private int count;
	// constructor and e1 and e2 will be the conditions, like 'Y' or '1' in characters 
	public UnionFind(E[][] items, E e1) {
		count=0;
		int rows = items.length;
		int cols = items[0].length;
		father = new int[rows*cols];
		
		for(int i=0; i<rows; i++) {
			for(int j=0; j<cols; j++) {
				if(items[i][j].equals(e1)) {
					//System.out.println("item " + items[i][j] + " e1 " + e1);
					father[i*cols+j] = i*cols+j;
					count++;
				}
			}
		}
		
		System.out.println("count " + count);
	}
	
	// recursively find the father of all nodes
	public int find(int node) {
		if(father[node]==node)
			return node;
		//recursively find node's father's father...
		father[node] = find(father[node]);
		
		return father[node];	
		
	}
	
	// no any optimization, like path compression and ranking
	public void union(int node1, int node2) {
		int find1 = find(node1);
		int find2 = find(node2);
		
		if(find1!=find2) {
			// just blindly link one node to another, here we link node1 to node2
			father[find1] = find2;
			System.out.println("count -- " + count);
			count--;
		}	
	}
	
	public int findCounts(){
		return this.count;
	}
	

}
