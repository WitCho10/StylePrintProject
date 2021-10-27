package pe.edu.upc.spring.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="PosicionPrenda")
public class GarmentPosition implements Serializable  {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idGarmentPosition;
	
	@Column(name="NombrePosicionPrenda",length=60,nullable=false)	
	private String nameGarmentPosition;

	public GarmentPosition() {
		super();
		
	}

	public GarmentPosition(int idGarmentPosition, String nameGarmentPosition) {
		super();
		this.idGarmentPosition = idGarmentPosition;
		this.nameGarmentPosition = nameGarmentPosition;
	}

	public int getIdGarmentPosition() {
		return idGarmentPosition;
	}

	public void setIdGarmentPosition(int idGarmentPosition) {
		this.idGarmentPosition = idGarmentPosition;
	}

	public String getNameGarmentPosition() {
		return nameGarmentPosition;
	}

	public void setNameGarmentPosition(String nameGarmentPosition) {
		this.nameGarmentPosition = nameGarmentPosition;
	}

	
	
}