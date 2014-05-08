package samples.camel.proxy;

import java.util.Date;

import org.apache.camel.CamelContext;
import org.apache.camel.builder.ProxyBuilder;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;

public class CamelProxy {

	public static void main(String[] args) throws Exception {

		CamelContext context = new DefaultCamelContext();

		OrderService service = new ProxyBuilder(context).endpoint(
				"direct:order").build(OrderService.class);

		// add our route to the CamelContext
		context.addRoutes(new RouteBuilder() {
			@Override
			public void configure() {
				from("direct:order").bean(new OrderProcessor());
			}
		});

		context.start();

		// send an order to the Camel route
		Order order = new Order(new Date(), 99.90);
		String reply = service.sendOrder(order);
		
		// print the result (produced by bean OrderProcessor)
		System.out.println(reply);

		context.stop();

	}

}
