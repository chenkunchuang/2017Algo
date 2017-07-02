
public class ShortestDistance {
	/**
	 *  Shortest Word Distance I
	 *  Given a list of words and two words word1 and word2, return the shortest distance between these two words in the list.

      For example, Assume that words = ["practice", "makes", "perfect", "coding", "makes"].

      Given word1 = “coding”, word2 = “practice”, return 3. Given word1 = "makes", word2 = "coding", return 1.

      Note: You may assume that word1 does not equal to word2, and word1 and word2 are both in the list.
	 * @param args
	 */
	
	 public int solution1(String[] words, String word1, String word2) {
		 // use two integer to store the index of word1 and word2.
		 int idx1=0, idx2=0;
		 //shortest distance
		 int ret=Integer.MAX_VALUE;
		 
		 for(int i=0; i<words.length; i++) {
			 if(words[i].equals(word1))
				 idx1=i;
			 if(words[i].equals(word2))
				 idx2=i;
			 if(idx1-idx2!=0)
			     ret = Math.min(ret, Math.abs(idx1-idx2));
			 
		 }
		 
		 return ret;
	 }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] words = {"practice", "makes", "perfect", "coding", "makes"};
		
		ShortestDistance obj = new ShortestDistance();
		
		System.out.println(obj.solution1(words, "practice", "makes"));

	}

}
