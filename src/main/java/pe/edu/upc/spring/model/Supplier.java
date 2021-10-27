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

	
	private static final long serialVersionUID = 1L;
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idSupplier;
	
	@Column(name="nombreProveedor", length=60,nullable=false)
	private String nameSupplier;
	

	@Column(name="celularProveedor", length=100,nullable=false)
	private int phoneSupplier;
	
	@Column(name="direccionProveedor", length=100,nullable=false)
	private String addressSupplier;

	public Supplier() {
		super();
		
	}

	public Supplier(int idSupplier, String nameSupplier, int phoneSupplier, String addressSupplier) {
		super();
		this.idSupplier = idSupplier;
		this.nameSupplier = nameSupplier;
		this.phoneSupplier = phoneSupplier;
		this.addressSupplier = addressSupplier;
	}

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

	public int getPhoneSupplier() {
		return phoneSupplier;
	}

	public void setPhoneSupplier(int phoneSupplier) {
		this.phoneSupplier = phoneSupplier;
	}

	public String getAddressSupplier() {
		return addressSupplier;
	}

	public void setAddressSupplier(String addressSupplier) {
		this.addressSupplier = addressSupplier;
	}

	
}
