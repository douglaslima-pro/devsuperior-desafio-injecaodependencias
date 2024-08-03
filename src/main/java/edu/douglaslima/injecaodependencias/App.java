package edu.douglaslima.injecaodependencias;

import java.util.Locale;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import edu.douglaslima.injecaodependencias.entity.Order;
import edu.douglaslima.injecaodependencias.service.OrderService;

@SpringBootApplication
public class App implements CommandLineRunner {

	@Autowired
	private OrderService orderService;
	
	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Locale.setDefault(Locale.US);
		Scanner scanner = new Scanner(System.in);
		
		int code = scanner.nextInt();
		double basic = scanner.nextDouble();
		double discount = scanner.nextDouble();
		
		Order order = new Order();
		order.setCode(code);
		order.setBasic(basic);
		order.setDiscount(discount);
		
		double total = orderService.total(order);
		
		System.out.println(
				"""
				
				Pedido código %d
				Valor total: R$ %.2f
				""".formatted(order.getCode(), total)
				);
		
		scanner.close();
	}
	
}
