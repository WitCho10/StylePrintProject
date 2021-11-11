package pe.edu.upc.spring.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="Cliente")
public class Customer implements Serializable{

	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idCustomer;
	
	@Column(name="nombreCliente", length=60, nullable=false)
    private String nameCustomer;
	
	@Column(name="apellidoCliente", length=60, nullable=false)
	private String lastnameCustomer;
	
	@Column(name="celularCliente", length=60, nullable=false)
	private int phoneCustomer;
	
	@Column(name="direccionCliente", length=60, nullable=false)
	private String addressCustomer;
	
	@Column(name="correoCliente", length=60, nullable=false, unique = true)
	private String emailCustomer;
	
	@Column(name="contrasenaCliente", length=60, nullable=false, unique = true)
	private String passwordCustomer;

	@OneToOne
	private Role rol;
	
	public Customer() {
		super();
		
	}

	

	public Customer(int idCustomer, String nameCustomer, String lastnameCustomer, int phoneCustomer,
			String addressCustomer, String emailCustomer, String passwordCustomer, Role rol) {
		super();
		this.idCustomer = idCustomer;
		this.nameCustomer = nameCustomer;
		this.lastnameCustomer = lastnameCustomer;
		this.phoneCustomer = phoneCustomer;
		this.addressCustomer = addressCustomer;
		this.emailCustomer = emailCustomer;
		this.passwordCustomer = passwordCustomer;
		this.rol = rol;
	}



	public int getIdCustomer() {
		return idCustomer;
	}

	public void setIdCustomer(int idCustomer) {
		this.idCustomer = idCustomer;
	}

	public String getNameCustomer() {
		return nameCustomer;
	}

	public void setNameCustomer(String nameCustomer) {
		this.nameCustomer = nameCustomer;
	}

	public String getLastnameCustomer() {
		return lastnameCustomer;
	}

	public void setLastnameCustomer(String lastnameCustomer) {
		this.lastnameCustomer = lastnameCustomer;
	}

	public int getPhoneCustomer() {
		return phoneCustomer;
	}

	public void setPhoneCustomer(int phoneCustomer) {
		this.phoneCustomer = phoneCustomer;
	}

	public String getAddressCustomer() {
		return addressCustomer;
	}

	public void setAddressCustomer(String addressCustomer) {
		this.addressCustomer = addressCustomer;
	}

	public String getEmailCustomer() {
		return emailCustomer;
	}

	public void setEmailCustomer(String emailCustomer) {
		this.emailCustomer = emailCustomer;
	}

	public String getPasswordCustomer() {
		return passwordCustomer;
	}

	public void setPasswordCustomer(String passwordCustomer) {
		this.passwordCustomer = passwordCustomer;
	}


	public Role getRol() {
		return rol;
	}


	public void setRol(Role rol) {
		this.rol = rol;
	}
		
	
}
