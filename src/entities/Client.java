package entities;

import java.time.Instant;
import java.util.Date;

public class Client {

	private String name;
	private String email;
	private Date birthDate;

	public Client(String nome, String email, String data){
		
		this.name = nome;
		this.email = email;
		this.birthDate = Date.from(Instant.parse(data));
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}
	
}
