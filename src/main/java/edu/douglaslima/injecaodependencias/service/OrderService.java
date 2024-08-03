package edu.douglaslima.injecaodependencias.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.douglaslima.injecaodependencias.entity.Order;

@Service
public class OrderService {

	@Autowired
	private ShippingService shippingService;

	/**
	 * <p>
	 * Calculates the order total value, based on the following formula:
	 * </p>
	 * <code>
	 * total = basic * (1 - (discount / 100)) + shipment
	 * </code>
	 * @param order an object of type {@code Order}
	 * @return the order total value including the discount and shipment
	 */
	public double total(Order order) {
		return order.getBasic() * (1 - (order.getDiscount() / 100)) + shippingService.shipment(order);
	}

}
