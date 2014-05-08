package samples.camel.proxy;

public class OrderProcessor {

	public String processOrder(Order order) {
		System.out.println(String.format("Processing order: %s", order));
		return "Order successfully processed";
	}
	
}
