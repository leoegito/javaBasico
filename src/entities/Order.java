package entities;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import entities.enums.OrderStatus;

public class Order {
	
	private String moment = new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime());
	private OrderStatus status;
	private ArrayList<OrderItem> OrderItens = new ArrayList <OrderItem>();
	private Client client;
	
	
	public Order(String moment, OrderStatus status) {
		this.moment = moment;
		this.status = status;
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
		retorno.append("ORDER SUMARY:\n");
		retorno.append("Order moment: " +this.moment+"\n");
		retorno.append("Order status: " +this.status+"\n");
		retorno.append("Client: " +this.client.getName()+ "("+this.client.getBirthDate()+")"+" - " +this.client.getEmail()+"\n");
		retorno.append("Order items:\n");
		for(OrderItem item : OrderItens) {
			retorno.append(item.produto.getName()+", ");
			retorno.append("Quantity: " +item.getQuantity()+", ");
			retorno.append("Subtotal: " +item.subTotal() +"\n");
		}
		retorno.append("Total price: $" +this.total());
		
		return retorno.toString();
	}

}
