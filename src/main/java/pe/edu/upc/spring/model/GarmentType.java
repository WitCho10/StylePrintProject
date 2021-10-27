package pe.edu.upc.spring.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="TipoPrenda")
public class GarmentType implements Serializable  {
	
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idGarmentType;
	
	@Column(name="nombreTipoPrenda", length=60,nullable=false)
	private String nameGarmentType;

	public GarmentType() {
		super();
		
	}

	public GarmentType(int idGarmentType, String nameGarmentType) {
		super();
		this.idGarmentType = idGarmentType;
		this.nameGarmentType = nameGarmentType;
	}

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
	
	
}