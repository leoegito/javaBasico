package program;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import entities.enums.OrderStatus;

public class MainProgram {

	public static void main(String[] args) throws ParseException {
		// TODO Auto-generated method stub
		Locale.setDefault(Locale.US);
		
		Scanner sc = new Scanner(System.in);
		Date dataNascimento;
		
		String nome;
		String email;
		String orderStatus;
		String nomeProd;
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		int qtd;
		int qtdProduto;
		
		double precoProd;
		
		
		System.out.println("Enter client data:");
		System.out.print("Name: ");
		nome = sc.nextLine();
		System.out.print("Email: ");
		email = sc.next();
		System.out.print("Birth date DD/MM/YYYY: ");
		dataNascimento = sdf.parse(sc.next());
		Client meuCliente = new Client(nome, email, dataNascimento);
		
		
		System.out.println("Enter order data: ");
		System.out.print("Status: ");
		orderStatus = sc.next();
		Order meuPedido = new Order(OrderStatus.valueOf(orderStatus), meuCliente);
		System.out.print("How many items to this order? ");
		qtd = sc.nextInt();
		
		for(int i=1;i<=qtd;i++) {
			System.out.printf("Enter #%1d item data: \n", i);
			System.out.print("Product name: ");
			nomeProd = sc.next();
			System.out.print("Product price: ");
			precoProd = sc.nextDouble();
			Product prodTemp = new Product(nomeProd, precoProd);
			System.out.print("Quantity: ");
			qtdProduto = sc.nextInt();
			OrderItem itemCarrinho = new OrderItem(qtdProduto, prodTemp);
			meuPedido.addItem(itemCarrinho);
		}
		
		System.out.println(meuPedido);
		
		sc.close();

	}

}
