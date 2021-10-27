package pe.edu.upc.spring.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Proveedor")
public class Supplier implements Serializable {

	public Supplier(int idSupplier, String nameSupplier, int phonenumber, String address) {
		super();
		this.idSupplier = idSupplier;
		this.nameSupplier = nameSupplier;
		this.phonenumber = phonenumber;
		Address = address;
	}
	private static final long serialVersionUID = 1L;
	
	public Supplier() {
		super();
		
	}
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idSupplier;
	
	@Column(name="NombreProveedor", length=60,nullable=false)
	private String nameSupplier;
	

	private int phonenumber;
	
	@Column(name="NombreDireccion", length=100,nullable=false)
	private String Address;

	public int getIdSupplier() {
		return idSupplier;
	}
	public void setIdSupplier(int idSupplier) {
		this.idSupplier = idSupplier;
	}

	public String getNameSupplier() {
		return nameSupplier;
	}
	public void setNameSupplier(String nameSupplier) {
		this.nameSupplier = nameSupplier;
	}
	public int getPhonenumber() {
		return phonenumber;
	}
	public void setPhonenumber(int phonenumber) {
		this.phonenumber = phonenumber;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
	
	
	
}
