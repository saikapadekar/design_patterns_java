import java.io.IOException;
import java.util.*;
import java.nio.file.*;
import java.nio.charset.StandardCharsets;
public class ValidateMaxQty extends OrderHandler{

	private final static int MAX_LUX=3;
	private final static int MAX_ESS=5;
	private final static int MAX_MISC=6;
	
	HashMap<String, Integer> max_val = new HashMap<>();
	
	
	
	public ValidateMaxQty() {
		super();
	}
	public ValidateMaxQty(OrderHandler order_Handler) {
		super(order_Handler);
		// TODO Auto-generated constructor stub
	}
	DatasetSingle ds_obj=DatasetSingle.getInstance(); 

	@Override
	public void processOrder(List<String> order) {
		max_val.put("Essential", MAX_ESS);
		max_val.put("Luxury", MAX_LUX);
		max_val.put("Misc", MAX_MISC);
		
		System.out.println("Validating order against MAX_QTY");
		
		HashMap<String, String> category_mp=ds_obj.getInstance().getItemCat();
		HashMap<String, Integer> item_freq=ds_obj.getInstance().getOrderItems();
		
		String category = category_mp.get(order.get(0));
		
		int pre_qty = 0;
		if(item_freq.containsKey(category_mp.get(order.get(0)))) {
			pre_qty=(item_freq.get(category_mp.get(order.get(0))));
		}
		int fin_qty=pre_qty+Integer.parseInt(order.get(1));
		item_freq.put(category, fin_qty);
		
		if(item_freq.containsKey(order.get(0))  && item_freq.get(order.get(0))>max_val.get(order.get(0))) 
		{
			try {
				String content="Please correct quantities for:" +order.get(0) +"\nPermissible value is:" +max_val.get(order.get(0));
				
				System.out.println("Please correct quantities for:" +order.get(0) +"\nPermissible value is:" +max_val.get(order.get(0)));
				Files.write(Paths.get("output.txt"), content.getBytes(),StandardOpenOption.APPEND);
			}
			catch (IOException e) {
			      System.out.println("An error occurred.");
			      e.printStackTrace();
			    }
			return;
		}
		//System.out.println("Printing final");
		//System.out.println(item_freq);
		if(order_Handler!=null) {
			order_Handler.processOrder(order);
		}
	}

}
