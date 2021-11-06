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
@Table(name="Prenda")
public class Garment implements Serializable  {


	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idGarment;
	
	@Column(name="nombrePrenda", length=60, nullable=false)
	private String nameGarment;
	
	@Column(name="nombreColor", length=60, nullable=false)
	private String colornameGarment;

	@Column(name="imagenPrenda",length=300, nullable=false)
	 private String imageGarment;
	
	@ManyToOne
	@JoinColumn(name="idGarmentType",nullable=false)
	private GarmentType garmenttype;
	
	@ManyToOne
	@JoinColumn(name="idSupplier",nullable=false)
	private Supplier supplier;
	
	@ManyToOne
	@JoinColumn(name="idSize",nullable=false)
	private Size size;
	
	@ManyToOne
	@JoinColumn(name="idGarmentPosition",nullable=false)
	private GarmentPosition garmentPosition;
	
	@ManyToOne
	@JoinColumn(name="idAdministrator",nullable=false)
	private Administrator administrator;

	public Garment() {
		super();
		
	}

	public Garment(int idGarment, String nameGarment, String colornameGarment, GarmentType garmenttype,
			Supplier supplier, Size size, GarmentPosition garmentPosition, Administrator administrator, String imageGarment) {
		super();
		this.idGarment = idGarment;
		this.nameGarment = nameGarment;
		this.colornameGarment = colornameGarment;
		this.garmenttype = garmenttype;
		this.supplier = supplier;
		this.size = size;
		this.garmentPosition = garmentPosition;
		this.administrator = administrator;
		this.imageGarment = imageGarment;
	}

	public int getIdGarment() {
		return idGarment;
	}

	public void setIdGarment(int idGarment) {
		this.idGarment = idGarment;
	}

	public String getNameGarment() {
		return nameGarment;
	}

	public void setNameGarment(String nameGarment) {
		this.nameGarment = nameGarment;
	}

	public String getColornameGarment() {
		return colornameGarment;
	}

	public void setColornameGarment(String colornameGarment) {
		this.colornameGarment = colornameGarment;
	}

	public String getImageGarment() {
		return imageGarment;
	}

	public void setImageGarment(String imageGarment) {
		this.imageGarment = imageGarment;
	}

	public GarmentType getGarmenttype() {
		return garmenttype;
	}

	public void setGarmenttype(GarmentType garmenttype) {
		this.garmenttype = garmenttype;
	}

	public Supplier getSupplier() {
		return supplier;
	}

	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}

	public Size getSize() {
		return size;
	}

	public void setSize(Size size) {
		this.size = size;
	}

	public GarmentPosition getGarmentPosition() {
		return garmentPosition;
	}

	public void setGarmentPosition(GarmentPosition garmentPosition) {
		this.garmentPosition = garmentPosition;
	}

	public Administrator getAdministrator() {
		return administrator;
	}

	public void setAdministrator(Administrator administrator) {
		this.administrator = administrator;
	}

	
	

	
}

