/*
 * This is indeed 5/31電面
 */
import java.util.*;
public class MergeKArrays {
	
	// This class node is used for record location of the element
	// because you will need index to traverse the array, it's not like sorted linkedlist
	public class Node {
		private int val, row, col;
		public Node(int val, int row, int col) {
			this.val = val;
			this.row = row;
			this.col = col;
		}
	}
	
	public int[] merge(int[][] arrs) {
		
		//int[] ret = new int[arrs.length*arrs[0].length];
		int totalLen =0;
		for(int i=0; i<arrs.length; i++) {
			totalLen+=arrs[i].length;
		}
		// given each array might have different length
		int[] ret = new int[totalLen];
		
		int idx=0;
		PriorityQueue<Node> pq = new PriorityQueue<>(arrs.length, new Comparator<Node>(){
			public int compare(Node n1, Node n2) {
				return n1.val-n2.val;
			}
		});
		
		//init queue to k elements. enqueue first element from each array
		for(int i=0; i<arrs.length; i++) {
			pq.offer(new Node(arrs[i][0], i, 0));
		}
		
		while(pq.isEmpty()==false) {
			Node node = pq.poll();
			ret[idx++] = node.val;
			// Don't use arrs[0].length because the array column length might not be the same
			if(node.col+1<arrs[node.row].length)
				pq.offer(new Node(arrs[node.row][node.col+1], node.row, node.col+1));
			 
				
		}
		
		return ret;
	}
	
	
	public static void main(String[] args) {
		
		MergeKArrays sol = new MergeKArrays();
		
		int[][] arrs = {{2,4,6}, {1,5,10},{3,7,11}, {8,9}};
		
		System.out.println("merged Array: "+ Arrays.toString(sol.merge(arrs)));
		
		// TODO Auto-generated method stub

	}

}
