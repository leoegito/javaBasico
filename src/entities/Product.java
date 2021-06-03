package entities;

public class Product {
	
	private String name;
	private double price;
	

	public Product(String nome, double preco) {
		
		this.name = nome;
		this.price = preco;
		
	}
	
	//Getters e Setters
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

}
