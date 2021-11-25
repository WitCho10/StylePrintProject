package pe.edu.upc.spring.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
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
	
	@Column(length=60, nullable=false, unique = true)
	private String username;
	
	@Column( length=60, nullable=false, unique = true)
	private String password;
	
	private Boolean enabled;
	
	
	@OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	@JoinColumn(name="customer_id")
	private List<Role> rol;
	
	public Customer() {
		super();
		
	}
	
	public Customer(int idCustomer, String nameCustomer, String lastnameCustomer, int phoneCustomer,
			String addressCustomer, String username, String password, Boolean enabled, List<Role> rol) {
		super();
		this.idCustomer = idCustomer;
		this.nameCustomer = nameCustomer;
		this.lastnameCustomer = lastnameCustomer;
		this.phoneCustomer = phoneCustomer;
		this.addressCustomer = addressCustomer;
		this.username = username;
		this.password = password;
		this.enabled = enabled;
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

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

	public List<Role> getRol() {
		return rol;
	}

	public void setRol(List<Role> rol) {
		this.rol = rol;
	}

	

	

	

	
		
	
}
