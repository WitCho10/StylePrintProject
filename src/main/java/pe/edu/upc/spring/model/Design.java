package pe.edu.upc.spring.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;


@Entity
@Table(name="Diseno")
public class Design implements Serializable{

	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idDesign;
	
	@Column(name="nombreDiseño", length=60, nullable=false)
	private String nameDesign;
	
	private String imgDesign;
	
	@ManyToOne
	@JoinColumn(name="idDesigner",nullable=false)
	private Designer designer;
	
	@Column(name="DetalleDiseno")
	private String detailDesign;
	
	@Temporal(TemporalType.DATE)
	@Column(name="fechaPublicacion")
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date dateDesign;

	public Design() {
		super();
		
	}

	public Design(int idDesign, String nameDesign, String imgDesign, Designer designer, String detailDesign,
			Date dateDesign) {
		super();
		this.idDesign = idDesign;
		this.nameDesign = nameDesign;
		this.imgDesign = imgDesign;
		this.designer = designer;
		this.detailDesign = detailDesign;
		this.dateDesign = dateDesign;
	}

	public int getIdDesign() {
		return idDesign;
	}

	public void setIdDesign(int idDesign) {
		this.idDesign = idDesign;
	}

	public String getNameDesign() {
		return nameDesign;
	}

	public void setNameDesign(String nameDesign) {
		this.nameDesign = nameDesign;
	}

	public String getImgDesign() {
		return imgDesign;
	}

	public void setImgDesign(String imgDesign) {
		this.imgDesign = imgDesign;
	}

	public Designer getDesigner() {
		return designer;
	}

	public void setDesigner(Designer designer) {
		this.designer = designer;
	}

	public String getDetailDesign() {
		return detailDesign;
	}

	public void setDetailDesign(String detailDesign) {
		this.detailDesign = detailDesign;
	}

	public Date getDateDesign() {
		return dateDesign;
	}

	public void setDateDesign(Date dateDesign) {
		this.dateDesign = dateDesign;
	}

	
	
	
	
	
	
}
