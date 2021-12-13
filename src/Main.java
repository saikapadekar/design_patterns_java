
import java.io.*;
import java.util.*;

//import jdk.internal.org.jline.reader.impl.DefaultParser.Bracket;

public class Main {

	public static void main(String[] args) throws FileNotFoundException, IOException{
		
		String filePath="Dataset - Sheet1.csv";
		String ipfile="Input - Sheet1.csv";
		
        
        DatasetSingle ds_obj=DatasetSingle.getInstance(filePath);  
        ConcAggregateIP process_input = new ConcAggregateIP(ipfile);
        Iterator it = process_input.createIterator();
        
        PriceCalculate price_Calculate = new PriceCalculate();
        ValidateMaxQty validate_MaxQty=new ValidateMaxQty(price_Calculate);
        ValidateStock validate_stock=new ValidateStock(validate_MaxQty);
        
       
       
        List<String> order;
        while((order = it.nextOrder()) != null) {
        	System.out.println(order);
        	validate_stock.processOrder(order);
        }
        System.out.println("\nStored Cards are as follows:");
        System.out.println(ds_obj.getCards());
		
}
}
