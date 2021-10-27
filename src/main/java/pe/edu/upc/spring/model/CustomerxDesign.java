package pe.edu.upc.spring.model;

import java.io.Serializable;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name="ClientexDiseno")
public class CustomerxDesign implements Serializable{

	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idCustomerxDesign;
	
	@ManyToOne
	@JoinColumn(name="idDesign",nullable=false)
	private Design design;
	
	@ManyToOne
	@JoinColumn(name="idCliente",nullable=false)
	private Customer customer;

	public CustomerxDesign() {
		super();
		
	}

	public CustomerxDesign(int idCustomerxDesign, pe.edu.upc.spring.model.Design design, Customer customer) {
		super();
		this.idCustomerxDesign = idCustomerxDesign;
		this.design = design;
		this.customer = customer;
	}

	public int getIdCustomerxDesign() {
		return idCustomerxDesign;
	}

	public void setIdCustomerxDesign(int idCustomerxDesign) {
		this.idCustomerxDesign = idCustomerxDesign;
	}

	public Design getDesign() {
		return design;
	}

	public void setDesign(Design design) {
		this.design = design;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	
	
	
	
}
