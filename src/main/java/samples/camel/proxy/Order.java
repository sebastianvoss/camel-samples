package samples.camel.proxy;

import java.util.Date;

public class Order {

	public final Date date;
	public final double total;

	public Order(Date date, double total) {
		this.date = date;
		this.total = total;
	}

	@Override
	public String toString() {
		return "Order [date=" + date + ", total=" + total + "]";
	}

}
