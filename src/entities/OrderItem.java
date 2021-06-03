package entities;

public class OrderItem {

	private int quantity;
	Product produto;
	
	public OrderItem(int quantidade, Product product) {
		
		this.quantity = quantidade;
		this.produto = product;
		
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	public double subTotal() {
		
		return this.quantity*produto.getPrice();
		
	}
	
	public String getName() {
		return produto.getName();
	}
	
}
