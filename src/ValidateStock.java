import java.util.*;
import java.io.*;
import java.io.FileWriter; 
public class ValidateStock extends OrderHandler {
	
	public ValidateStock() {
		super();
	}

	public ValidateStock(OrderHandler order_Handler) {
		super(order_Handler);
		// TODO Auto-generated constructor stub
	}
	
	DatasetSingle ds_obj=DatasetSingle.getInstance(); 
	@Override
	public void processOrder(List<String> order) {
		System.out.println("Validating order against stock");
		
		HashMap<String, String> price=ds_obj.getInstance().getItemPrice();
		ds_obj.getInstance().getCards().add(order.get(2));
		if(Float.parseFloat(order.get(1))>Float.parseFloat(price.get(order.get(0)))) {
			try {
			FileWriter myWriter = new FileWriter("output.txt");
			 myWriter.write("Please correct quantities of: "+order.get(0));
			System.out.println("Please correct quantities of: "+order.get(0));
			}
			 catch (IOException e) {
			      System.out.println("An error occurred.");
			      e.printStackTrace();
			    }
			return;
		}
		
		if(order_Handler!=null) {
			order_Handler.processOrder(order);
		}
	}
	

}
