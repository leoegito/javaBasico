package entities;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import entities.enums.OrderStatus;

public class Order {
	
	private String moment;
	private OrderStatus status;
	private ArrayList<OrderItem> OrderItens = new ArrayList <OrderItem>();
	private Client client;
	
	
	public Order(OrderStatus status, Client cliente) {
		this.moment = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());
		this.status = status;
		this.client = cliente;
	}
	
	
	//Metodos
	public void addItem(OrderItem item) {
		
		OrderItens.add(item);
		
	}
	
	public void removeItem(OrderItem item) {
		
		OrderItens.remove(item);
		
	}
	
	public double total() {
		double total = 0.00;
		for(OrderItem item : OrderItens) {
			total += item.subTotal();
		}
		return total;
	}
	
	//Getters e setters
	public String getMoment() {
		return this.moment;
	}
	
	public OrderStatus getStatus() {
		return this.status;
	}
	
	public void setStatus(OrderStatus novoStatus) {
		this.status = novoStatus;
	}
	
	public void setClient(Client cliente) {
		this.client = cliente;
	}
	
	public String toString() {
		StringBuilder retorno = new StringBuilder();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		retorno.append("ORDER SUMARY:\n");
		retorno.append("Order moment: " +this.moment+"\n");
		retorno.append("Order status: " +this.status+"\n");
		String data = sdf.format(this.client.getBirthDate());
		retorno.append("Client: " +this.client.getName()+ " (" +data +")"+" - " +this.client.getEmail()+"\n");
		retorno.append("Order items:\n");
		for(OrderItem item : OrderItens) {
			retorno.append(item.produto.getName() +", ");
			retorno.append(String.format("$ %.2f, ",item.produto.getPrice()));
			retorno.append("Quantity: " +item.getQuantity()+", ");
			retorno.append(String.format("Subtotal: $ %.2f\n", item.subTotal()));
		}
		retorno.append(String.format("Total price: $ %.2f", this.total()));
		
		return retorno.toString();
	}

}
