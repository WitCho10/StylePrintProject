package pe.edu.upc.spring.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="TipoPrenda")
public class GarmentType implements Serializable  {
	
	public GarmentType(int idGarmentType, String nameGarmentType) {
		super();
		this.idGarmentType = idGarmentType;
		this.nameGarmentType = nameGarmentType;
	}
	public GarmentType() {
		super();
		// TODO Auto-generated constructor stub
	}
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idGarmentType;
	
	
	@Column(name="NombreTipoPrenda", length=60,nullable=false)
	private String nameGarmentType;
	
	@ManyToOne
	@JoinColumn(name="Garment_id",nullable=false)
	private Garment idGarment;	
	
	@ManyToOne
	@JoinColumn(name="Customer_id",nullable=false)
	private Customer idCustomer;

	public int getIdGarmentType() {
		return idGarmentType;
	}
	public void setIdGarmentType(int idGarmentType) {
		this.idGarmentType = idGarmentType;
	}
	public String getNameGarmentType() {
		return nameGarmentType;
	}
	public void setNameGarmentType(String nameGarmentType) {
		this.nameGarmentType = nameGarmentType;
	}
	public Garment getIdGarment() {
		return idGarment;
	}
	public void setIdGarment(Garment idGarment) {
		this.idGarment = idGarment;
	}
	public Customer getIdCustomer() {
		return idCustomer;
	}
	public void setIdCustomer(Customer idCustomer) {
		this.idCustomer = idCustomer;
	}

}