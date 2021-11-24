package pe.edu.upc.spring.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Disenador")
public class Designer implements Serializable{

	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idDesigner;
	
	@Column(name="nombreDisenador", length=60, nullable=false)
	private String nameDesigner;
	
	@Column(name="apellidoDisenador", length=60, nullable=false)
    private String lastnameDesigner;
	
	@Column(name="celularDisenador", length=60, nullable=false)
	private int phoneDesigner;
	
	@Column(name="usernameDisenador", length=60, nullable=false)
	private String usernameDesigner;
	
	@Column(name="correoDisenador", length=80, nullable=false)
	private String emailDesigner;
	
	@Column(name="contrasenaDiseñador", length=60, nullable=false)
	private String passworDesigner;

	public Designer() {
		super();
		
	}

	public Designer(int idDesigner, String nameDesigner, String lastnameDesigner, int phoneDesigner,
			String usernameDesigner, String emailDesigner, String passworDesigner) {
		super();
		this.idDesigner = idDesigner;
		this.nameDesigner = nameDesigner;
		this.lastnameDesigner = lastnameDesigner;
		this.phoneDesigner = phoneDesigner;
		this.usernameDesigner = usernameDesigner;
		this.emailDesigner = emailDesigner;
		this.passworDesigner = passworDesigner;
	}

	public int getIdDesigner() {
		return idDesigner;
	}

	public void setIdDesigner(int idDesigner) {
		this.idDesigner = idDesigner;
	}

	public String getNameDesigner() {
		return nameDesigner;
	}

	public void setNameDesigner(String nameDesigner) {
		this.nameDesigner = nameDesigner;
	}

	public String getLastnameDesigner() {
		return lastnameDesigner;
	}

	public void setLastnameDesigner(String lastnameDesigner) {
		this.lastnameDesigner = lastnameDesigner;
	}

	public int getPhoneDesigner() {
		return phoneDesigner;
	}

	public void setPhoneDesigner(int phoneDesigner) {
		this.phoneDesigner = phoneDesigner;
	}

	public String getUsernameDesigner() {
		return usernameDesigner;
	}

	public void setUsernameDesigner(String usernameDesigner) {
		this.usernameDesigner = usernameDesigner;
	}

	public String getEmailDesigner() {
		return emailDesigner;
	}

	public void setEmailDesigner(String emailDesigner) {
		this.emailDesigner = emailDesigner;
	}

	public String getPassworDesigner() {
		return passworDesigner;
	}

	public void setPassworDesigner(String passworDesigner) {
		this.passworDesigner = passworDesigner;
	}
	
	
	
}
