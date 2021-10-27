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
@Table(name="prenda")

public class Garment implements Serializable  {

	public Garment() {
		super();
	}

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idGarment;
	private String nameGarment;
	private String colorname;
	
	@ManyToOne
	@JoinColumn(name="TipoPrenda_id",nullable=false)
	private GarmentType idGarmentType;
	
	@ManyToOne
	@JoinColumn(name="Proveedor_Id",nullable=false)
	private Supplier idSupplier;
	
	@ManyToOne
	@JoinColumn(name="Talla_id",nullable=false)
	private Size idSize;

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

	public String getColorname() {
		return colorname;
	}

	public void setColorname(String colorname) {
		this.colorname = colorname;
	}

	public GarmentType getIdGarmentType() {
		return idGarmentType;
	}

	public void setIdGarmentType(GarmentType idGarmentType) {
		this.idGarmentType = idGarmentType;
	}

	public Supplier getIdSupplier() {
		return idSupplier;
	}

	public void setIdSupplier(Supplier idSupplier) {
		this.idSupplier = idSupplier;
	}

	public Size getIdSize() {
		return idSize;
	}

	public void setIdSize(Size idSize) {
		this.idSize = idSize;
	}
}

