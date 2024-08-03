package edu.douglaslima.injecaodependencias.service;

import org.springframework.stereotype.Service;

import edu.douglaslima.injecaodependencias.entity.Order;

@Service
public class ShippingService {

	public double shipment(Order order) {
		if (order.getBasic() < 100) {
			return 20.0;
		} else if (order.getBasic() < 200) {
			return 12.0;
		} else {
			return 0.0;
		}
	}
	
}
