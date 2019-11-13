package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import enum_entities.OrderStatus;

public class Program {

	public static void main(String[] args) throws ParseException {

			Locale.setDefault(Locale.US);
			Scanner sc = new Scanner(System.in);
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			
			System.out.println("Enter client data: ");
			System.out.println("Name: ");
			String name = sc.nextLine();
			System.out.println("E-mail: ");
			String email = sc.next();
			System.out.println("Birth Date: ");
			Date birthDate = sdf.parse(sc.next());
			
			Client client=new Client(name, email, birthDate);
			
			System.out.println("Enter order data: ");
			System.out.println("Status: ");
			OrderStatus status = OrderStatus.valueOf(sc.next());
			
			Order order = new Order(new Date(), status, client);
			
			System.out.println("How many items to order: ");
			Integer nitems = sc.nextInt();			

			for (int i=0;i<nitems;i++) {
				System.out.println("Enter item #"+i+" data: ");
				System.out.println("Product name: ");
				sc.nextLine();
				String pname = sc.nextLine();
				System.out.println("Product price: ");
				Double price = sc.nextDouble();
				Product product=new Product(pname, price);
				System.out.println("Quantity: ");
				Integer quantity = sc.nextInt();
				OrderItem orderItem = new OrderItem(quantity, price, product);
				order.addItems(orderItem);
			}
			
			System.out.println();
			System.out.println("ORDER SUMMARY:");
			System.out.println(order);
				
				
				
			
			sc.close();
			
		
	}

}
