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



	public GarmentPosition(int idPosition, String namePosition) {
		super();
		IdPosition = idPosition;
		this.namePosition = namePosition;
	}
	public GarmentPosition() {
		super();
	}

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int IdPosition;
	@Column(name="NombrePosicionPrenda",length=60,nullable=false)	
	private String namePosition;
	
	public int getIdPosition() {
		return IdPosition;
	}
	public void setIdPosition(int idPosition) {
		IdPosition = idPosition;
	}
	public String getNamePosition() {
		return namePosition;
	}
	public void setNamePosition(String namePosition) {
		this.namePosition = namePosition;
	}
	
}