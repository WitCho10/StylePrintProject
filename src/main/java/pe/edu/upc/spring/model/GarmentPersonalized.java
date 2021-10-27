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
@Table(name="PrendaPersonalizada")
public class GarmentPersonalized implements Serializable  {


	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idGarmentPersonalized;
	
	@Column(name="urlimagenPrendaPersonalizada",length=200,nullable=false)
	private String urlimageGarmentPersonalized;

	@ManyToOne
	@JoinColumn(name="idGarment",nullable=false)
	private Garment garment;
	
	@ManyToOne
	@JoinColumn(name="idCustomer",nullable=false)
	private Customer customer;

	public GarmentPersonalized() {
		super();
		
	}

	public GarmentPersonalized(int idGarmentPersonalized, String urlimageGarmentPersonalized, Garment garment,
			Customer customer) {
		super();
		this.idGarmentPersonalized = idGarmentPersonalized;
		this.urlimageGarmentPersonalized = urlimageGarmentPersonalized;
		this.garment = garment;
		this.customer = customer;
	}

	public int getIdGarmentPersonalized() {
		return idGarmentPersonalized;
	}

	public void setIdGarmentPersonalized(int idGarmentPersonalized) {
		this.idGarmentPersonalized = idGarmentPersonalized;
	}

	public String getUrlimageGarmentPersonalized() {
		return urlimageGarmentPersonalized;
	}

	public void setUrlimageGarmentPersonalized(String urlimageGarmentPersonalized) {
		this.urlimageGarmentPersonalized = urlimageGarmentPersonalized;
	}

	public Garment getGarment() {
		return garment;
	}

	public void setGarment(Garment garment) {
		this.garment = garment;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

		
	
}