package pe.edu.upc.spring.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Administrador")
public class Administrator implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idAdministrator;
	

	@Column(name="nombreAdministradorn",length=60,nullable=false)
	private String nameAdministrator;
	
	@Column(name="apellidoAdministrador",length=60,nullable=false)
	private String lastnameAdministrator;
	
	@Column(name="dniAdministrador",length=60,nullable=false)
	private int dniAdministrator;
	
	@Column(name="celularAdministrador",length=60,nullable=false)
	private int phoneAdministrator;
	
	@Column(name="correoAdministrador",length=60,nullable=false)
	private String emailAdministrator;
	
	@Column(name="contrasenaAdministrador",length=60,nullable=false)
	private String passwordAdministrator;
	
	public Administrator() {
		super();
	}

	public Administrator(int idAdministrator, String nameAdministrator, String lastnameAdministrator,
			int dniAdministrator, int phoneAdministrator, String emailAdministrator, String passwordAdministrator) {
		super();
		this.idAdministrator = idAdministrator;
		this.nameAdministrator = nameAdministrator;
		this.lastnameAdministrator = lastnameAdministrator;
		this.dniAdministrator = dniAdministrator;
		this.phoneAdministrator = phoneAdministrator;
		this.emailAdministrator = emailAdministrator;
		this.passwordAdministrator = passwordAdministrator;
	}

	public int getIdAdministrator() {
		return idAdministrator;
	}

	public void setIdAdministrator(int idAdministrator) {
		this.idAdministrator = idAdministrator;
	}

	public String getNameAdministrator() {
		return nameAdministrator;
	}

	public void setNameAdministrator(String nameAdministrator) {
		this.nameAdministrator = nameAdministrator;
	}

	public String getLastnameAdministrator() {
		return lastnameAdministrator;
	}

	public void setLastnameAdministrator(String lastnameAdministrator) {
		this.lastnameAdministrator = lastnameAdministrator;
	}

	public int getDniAdministrator() {
		return dniAdministrator;
	}

	public void setDniAdministrator(int dniAdministrator) {
		this.dniAdministrator = dniAdministrator;
	}

	public int getPhoneAdministrator() {
		return phoneAdministrator;
	}

	public void setPhoneAdministrator(int phoneAdministrator) {
		this.phoneAdministrator = phoneAdministrator;
	}

	public String getEmailAdministrator() {
		return emailAdministrator;
	}

	public void setEmailAdministrator(String emailAdministrator) {
		this.emailAdministrator = emailAdministrator;
	}

	public String getPasswordAdministrator() {
		return passwordAdministrator;
	}

	public void setPasswordAdministrator(String passwordAdministrator) {
		this.passwordAdministrator = passwordAdministrator;
	}

	

	
	
}