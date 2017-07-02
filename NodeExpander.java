import java.util.*;

/*
 * This is for rescale project. 
 * Slurm exports a node list string that indicates the nodes a job runs on. 
 * This string can contain bracketed sections which indicate a numeric range or multiple options. 
 * Ranges are denoted by â€œ-â€�, options are denoted by â€œ,â€�.  
 * For example, â€œnode[1-3]â€� indicates nodes named â€œnode1â€�, â€œnode2â€�, and â€œnode3â€�, while â€œnode[1,5]â€� indicates nodes named â€œnode1â€� and â€œnode5â€�. 
 * Ranges and options can be combined in the same bracket, so, for example, â€œc[1,3-5]â€� indicates nodes named â€œc1â€�, â€œc3â€�, â€œc4â€�, and â€œc5â€�.  
 * There can be any number of bracketed sections in a node list string, but they wonâ€™t be nested. 
 * That means you can get a string like "node[1-2]node[4-5]" which should expand to "node1node4", "node1node5", "node2node4", "node2node5".
 */
public class NodeExpander {
	// This is to store each node's valid job id
	private List<List<String>> jobID;
	
	public NodeExpander() {
		jobID = new ArrayList<>();
	}
	
	private void parser(String s) {
		char[] chars = s.toCharArray();
		List<String> node = new ArrayList<>();
		// index for node string name
		int start =0;
		for(int i=0; i<chars.length; i++) {
			// found the left bracket
			if(chars[i]=='[') {
				String jobName = s.substring(start, i);
			   
				int rangeIdx = i+1;
				//get range
				while(i<chars.length&&chars[i]!=']') 
					i++;
				// only if bracket has range and has jobName
				if(rangeIdx!=i&&jobName.length()>0) {
				
				String[] nums = s.substring(rangeIdx, i).split(",");
				for(int j=0; j<nums.length; j++) {
					String[] num = nums[j].split("-");
					if(num.length==1) {
						node.add(jobName+num[0].trim());
						
					}
					else {

						for(int val=Integer.parseInt(num[0].trim()); val<=Integer.parseInt(num[1].trim()); val++ ) {
							node.add(jobName+val);
						}
					}
				}
				jobID.add(new ArrayList<String>(node));
				}
				//after getting range, move start to next node
				start = i+1;
				
				node.clear();
			}
		
		}
		return;
	}
	
	/*
	 * This method is to expand the node jobs
	 */
	public void expander(List<String> ret, String job, int level, int currIdx) {
		if(level==jobID.size()) {
			ret.add(new String(job));
			return;
		}
		for(int i=currIdx; i<jobID.get(level).size(); i++) {
			expander(ret, job+jobID.get(level).get(i), level+1, 0);
			
		}
		
		return;
		
	}
	
	
	public List<String> output(String s) {
		List<String> ret = new ArrayList<>();
		parser(s);
		//System.out.println("jobID size " + jobID.size());
	    expander(ret, "", 0, 0);
		//System.out.println(ret);
		
		jobID.clear();
		return ret;
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		NodeExpander sol = new NodeExpander();
		Scanner sc = new Scanner(System.in);
		System.out.print("enter s1:");
		String s1 = sc.next();
		System.out.print("enter s2:");
		String s2 = sc.next();
		
		//String s1 = new String("Hello"); //s2="Hello";
		//String s2 = new String("Hello");
		//s1="Hello";
		//String s2=s1;
		
		if(s1==s2)
			System.out.println("equals");
		else
			System.out.println("not equals");
		
		String job1 = "node[100-105,107,108]";
		String job2 = "c[12]node[100-105,107,108]d[]";
		String job3 = "node[1-2]list[6]c[7-8,9, 10]";
		String job4 = "[]node[23]t[][]list[22-24][]";
		System.out.println("job1: " + sol.output(job1));

		System.out.println("job2: " + sol.output(job2));
		System.out.println("job3: " + sol.output(job3));
		
		System.out.println("job4: " + sol.output(job4));
		
	}

}
