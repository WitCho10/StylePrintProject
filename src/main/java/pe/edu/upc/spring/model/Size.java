package pe.edu.upc.spring.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Size")
public class Size implements Serializable{

	public Size(int idSize, String nameSize) {
		super();
		IdSize = idSize;
		NameSize = nameSize;
	}
	public Size() {
		super();
		// TODO Auto-generated constructor stub
	}
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	
	private int IdSize;
	
	@Column(name="NombreTalla", length=60,nullable=false)
	private String NameSize;
	
	public int getIdSize() {
		return IdSize;
	}
	public void setIdSize(int idSize) {
		IdSize = idSize;
	}
	public String getNameSize() {
		return NameSize;
	}
	public void setNameSize(String nameSize) {
		NameSize = nameSize;
	}
	
	
}
