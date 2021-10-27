package pe.edu.upc.spring.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Administrator")
public class Administrator implements Serializable{
	
	public Administrator(int idAdmin, String nameAdmin, int dNI, int phoneNumber, String email, String password) {
		super();
		IdAdmin = idAdmin;
		this.nameAdmin = nameAdmin;
		DNI = dNI;
		PhoneNumber = phoneNumber;
		Email = email;
		Password = password;
	}
	
	public Administrator() {
		super();
	}
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
		
	private int IdAdmin	;

	@Column(name="nombreAdmin",nullable=false)
	private String nameAdmin;	
	private int DNI;
	private int PhoneNumber;
	private String Email;
	private String Password;
	
	public int getIdAdmin() {
		return IdAdmin;
	}
	public void setIdAdmin(int idAdmin) {
		IdAdmin = idAdmin;
	}
	public String getNameAdmin() {
		return nameAdmin;
	}
	public void setNameAdmin(String nameAdmin) {
		this.nameAdmin = nameAdmin;
	}
	public int getDNI() {
		return DNI;
	}
	public void setDNI(int dNI) {
		DNI = dNI;
	}
	public int getPhoneNumber() {
		return PhoneNumber;
	}
	public void setPhoneNumber(int phoneNumber) {
		PhoneNumber = phoneNumber;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
}