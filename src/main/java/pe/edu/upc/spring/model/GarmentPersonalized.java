package pe.edu.upc.spring.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="GarmentPersonalized")

public class GarmentPersonalized implements Serializable  {


	public GarmentPersonalized(int idGarmentPersonalized, String urlImage) {
		super();
		IdGarmentPersonalized = idGarmentPersonalized;
		UrlImage = urlImage;
	}

	private static final long serialVersionUID = 1L;

	public GarmentPersonalized() {
		super();

	}

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	
	private int IdGarmentPersonalized;
	private String UrlImage;

	public int getIdGarmentPersonalized() {
		return IdGarmentPersonalized;
	}
	public void setIdGarmentPersonalized(int idGarmentPersonalized) {
		IdGarmentPersonalized = idGarmentPersonalized;
	}
	public String getUrlImage() {
		return UrlImage;
	}
	public void setUrlImage(String urlImage) {
		UrlImage = urlImage;
	}


	
}