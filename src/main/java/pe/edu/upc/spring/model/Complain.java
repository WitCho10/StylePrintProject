package pe.edu.upc.spring.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="Queja")
public class Complain implements Serializable{

	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idComplain;
	
	@Column(name="nombreQueja", length=70,nullable=false)
	private String nameComplain;

	public Complain() {
		super();
		
	}

	public Complain(int idComplain, String nameComplain) {
		super();
		this.idComplain = idComplain;
		this.nameComplain = nameComplain;
	}

	public int getIdComplain() {
		return idComplain;
	}

	public void setIdComplain(int idComplain) {
		this.idComplain = idComplain;
	}

	public String getNameComplain() {
		return nameComplain;
	}

	public void setNameComplain(String nameComplain) {
		this.nameComplain = nameComplain;
	}
	
	
	
}
