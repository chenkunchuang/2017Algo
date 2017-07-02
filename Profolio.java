import java.io.*;
import java.util.*;
import java.nio.file.*;

/*
 * Addepar phone interview question
 */
public class Profolio {
	
	private static final String FILENAME = "C:\\Users\\cchuang\\workspace\\Algorithm\\transactions.txt";
	
	private HashMap<String, Integer> dataMap;
	//constructor
	public Profolio(List<String> hold){
		dataMap = new HashMap<>();
		
		for(int i=2; i<hold.size()-1; i+=2)
			dataMap.put(hold.get(i), Integer.parseInt(hold.get(i+1)));
		/*
		for(Map.Entry<String, Integer> entry: dataMap.entrySet()) {
			System.out.println(entry.getKey() + " " + entry.getValue());
		}
		*/
	}
	
	public void transaction(String stock, String action, String s, String m) {
		
		int share = Integer.parseInt(s);
		int money = Integer.parseInt(m);
		
		//buy stock
		if(action.equals("BY")) {
			dataMap.put(stock, dataMap.get(stock)+share);
			dataMap.put("CASH", dataMap.get("CASH")-money);
		}
		
		else if(action.equals("SL")) {
			dataMap.put(stock, dataMap.get(stock) - share);
			dataMap.put("CASH", dataMap.get("CASH")+money);
			
		}
		
		return;
	}
	/*
	public void holdings(String field, int amount) {
		
	}
	*/
	public void checker(String field, String a) {
		int amount = Integer.parseInt(a);
		
		if(dataMap.get(field)!=amount)
			System.out.println(field + " " + (amount - dataMap.get(field)));
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		String[] s = {"D0-POS APPL 100 GOOGL 200 CASH 10", "D1-TRN APPL SL 50 30000 GOOGL BY 200 10000", 
				"D1-POS APPL 50 GOOGL 400 CASH 20010", "D2-TRN APPL SL 50 30000 GOOGL SL 200 10000",
				"D2-POS APPL 10 GOOGL 400 CASH 20000"};
		*/
		List<List<String>> lists = new ArrayList<>();
		
		
		
		try(BufferedReader in = new BufferedReader(new FileReader(FILENAME)) )
		{	
			String next;
			String line ="";
			while((next = in.readLine())!=null) {
				System.out.println("next " + next);
				if(next.trim().isEmpty()==false) {
					line+=next;
				}
				else {
					System.out.println("line " + line);
					lists.add(new ArrayList(Arrays.asList(line.split(" |-"))));
					//reset line
					line="";
				}
			}
			//add last line here
			lists.add(new ArrayList(Arrays.asList(line.split(" |-"))));
			//reset line
			line="";
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		
		for(int i=0; i<lists.size(); i++)
			System.out.println(lists.get(i));
		 
		/*
		for(String sb: s) {
			String[] data = sb.split(" |-");
			lists.add(new ArrayList(Arrays.asList(data)));
			System.out.println(lists.get(lists.size()-1));
			
			for(String t: data)
			 System.out.print(" " + t);
			System.out.println();
			
			
			
		} 
		*/
		//update your initial holdings
		Profolio obj = new Profolio(lists.get(0));
		
		
		for(int i=1; i<lists.size(); i++) {
			List<String> list = lists.get(i);
			
			if(list.get(1).equals("TRN")) {
				for(int j=2; j<list.size()-3; j+=4) {
					obj.transaction(list.get(j), list.get(j+1), list.get(j+2), list.get(j+3));
				}
					
			}
			else if(list.get(1).equals("POS"))
				for(int j=2; j<list.size()-1; j+=2)
					obj.checker(list.get(j), list.get(j+1));
		}
		
		
		
		
		
	}

}
