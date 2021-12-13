import java.io.*;
import java.util.*;

public class DatasetSingle {

	private static DatasetSingle Dataset_instance = null;
	
	private DatasetSingle() {
		
	}
	
	HashMap<String, String> item_cat = new HashMap<>();
	HashMap<String, String> item_qty = new HashMap<>();
	HashMap<String, String> item_price = new HashMap<>();
	HashMap<String, Integer> order_items = new HashMap<>();
	 HashSet<String> cards = new HashSet<String>();
	private DatasetSingle(String filepath) throws FileNotFoundException, IOException{
		
		
		
		BufferedReader br = new BufferedReader(new FileReader(filepath));
		String sCurrentLine;
		while ((sCurrentLine = br.readLine()) != null) 
	    {
			String line_str[]=sCurrentLine.split(",");
			List<String> ds_list=Arrays.asList(line_str);
			item_cat.put(ds_list.get(1), ds_list.get(0));
			item_qty.put(ds_list.get(1), ds_list.get(2));
			item_price.put(ds_list.get(1), ds_list.get(3));
	    }
		BufferedReader br2 = new BufferedReader(new FileReader("Cards - Sheet1.csv"));
		String line=br2.readLine();
	
		while ((line = br2.readLine()) != null) {
			cards.add(line);
		}
		br.close();
		br2.close();
	}
	
	public static DatasetSingle getInstance(String filepath)  throws FileNotFoundException, IOException  {
		if(Dataset_instance==null) {
			Dataset_instance=new DatasetSingle(filepath);
		}
		
	
	return Dataset_instance;
	}
	
	public static DatasetSingle getInstance(){
		if(Dataset_instance==null) {
			Dataset_instance=new DatasetSingle();
		}
		return Dataset_instance;
	}
	
	public HashMap<String, String> getItemCat(){
		return this.item_cat; 
	}
	public HashMap<String, String> getItemQty(){
		return this.item_qty; 
	}
	public HashMap<String, String> getItemPrice(){
		return this.item_price; 
	}
	public HashMap<String, Integer> getOrderItems(){
		return this.order_items; 
	}
	public HashSet<String> getCards(){
		return this.cards; 
	}

    
}
