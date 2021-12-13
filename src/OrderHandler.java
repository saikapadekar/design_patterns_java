import java.util.*;
public abstract class OrderHandler {
	
	public OrderHandler order_Handler;
	
	public OrderHandler() {}
	
	public OrderHandler (OrderHandler order_Handler) {
		this.order_Handler=order_Handler;
	}
   
	public abstract void processOrder(List<String> order);
}
