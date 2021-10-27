package pe.edu.upc.spring.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Talla")
public class Size implements Serializable{

	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idSize;
	
	@Column(name="nombreTalla", length=60,nullable=false)
	private String nameSize;

	public Size() {
		super();
		
	}

	public Size(int idSize, String nameSize) {
		super();
		this.idSize = idSize;
		this.nameSize = nameSize;
	}

	public int getIdSize() {
		return idSize;
	}

	public void setIdSize(int idSize) {
		this.idSize = idSize;
	}

	public String getNameSize() {
		return nameSize;
	}

	public void setNameSize(String nameSize) {
		this.nameSize = nameSize;
	}
	
	
	
}
