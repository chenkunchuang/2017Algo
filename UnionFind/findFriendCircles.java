package UnionFind;

public class findFriendCircles {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Character[][] friendcircles = {{'Y','Y','N','N'}, {'Y','Y','Y','N'}, {'N','Y','Y','N'}, {'N','N','N','Y'}};
		
		UnionFind<Character> uf = new UnionFind(friendcircles, 'Y');
		
		int rows = friendcircles.length;
		int cols = friendcircles[0].length;
		
		 
		//use array to calculate neighbors and if they have the same father, it means they are connected so the island
        int[][] distance = {{1,0}, {-1,0}, {0,1}, {0,-1}};
        
		for(int i=0; i<rows; i++) {
			for(int j=0; j<cols; j++) {
				if(friendcircles[i][j]=='Y'){
					for(int[] d: distance) {
					
						int x = i+d[0];
						int y = j+d[1];
						
						if(x>=0&&x<rows&&y>=0&&y<cols&&friendcircles[x][y]=='Y') {
							int node1 = i*cols+j;
							int node2 = x*cols+y;
							uf.union(node1, node2);
						}
							
					
				}
			}
		}
		}
		System.out.println(" the friend circles "+ uf.findCounts());
	}

}
