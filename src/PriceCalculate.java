import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public class PriceCalculate extends OrderHandler{
	float fin_price=0;
	public PriceCalculate() {
		
	}
	
	DatasetSingle ds_obj=DatasetSingle.getInstance(); 

	@Override
	public void processOrder(List<String> order) {
		System.out.println("Calculating Price");
		
		HashMap<String, String> item_price=ds_obj.getInstance().getItemPrice();
		//System.out.println(item_price);
		
		float price=Float.parseFloat(item_price.get(order.get(0)));
		int qty=Integer.parseInt(order.get(1));
		fin_price=fin_price+(price*qty);
		System.out.println("Final Price is"+fin_price);
		try {
			FileWriter myWriter = new FileWriter("total_price.csv");
			 myWriter.write("Final Price is"+fin_price);
			 myWriter.close();
		}
		catch (IOException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		    }
		
	}

}
