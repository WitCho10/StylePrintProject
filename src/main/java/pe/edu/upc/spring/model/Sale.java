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
@Table(name="Venta")
public class Sale implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idSale;
	
	@Temporal(TemporalType.DATE)
	@Column(name="fechaEmision")
	@DateTimeFormat(pattern="yyyy-MM-dd")
    private Date fechaemisionSale;
	
	@Column(name="precio")
	private double totalSale;
	
//	@Column(name="imgVenta")
//	private String imagenventaSale;
	
	@ManyToOne
	@JoinColumn(name="idEstado")
	private Status statusSale;
	
	@Temporal(TemporalType.DATE)
	@Column(name="fechaFinal")
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date fechafinalSale;
	
	@ManyToOne
	@JoinColumn(name="idCustomer")
	private Customer customerSale;

	public Sale() {
		super();
		
	}
	
	public Sale(int idSale, Date fechaemisionSale, double totalSale, Status statusSale, Date fechafinalSale,
			Customer customerSale) {
		super();
		this.idSale = idSale;
		this.fechaemisionSale = fechaemisionSale;
		this.totalSale = totalSale;
		this.statusSale = statusSale;
		this.fechafinalSale = fechafinalSale;
		this.customerSale = customerSale;
	}

	public int getIdSale() {
		return idSale;
	}

	public void setIdSale(int idSale) {
		this.idSale = idSale;
	}

	public Date getFechaemisionSale() {
		return fechaemisionSale;
	}

	public void setFechaemisionSale(Date fechaemisionSale) {
		this.fechaemisionSale = fechaemisionSale;
	}

	public double getTotalSale() {
		return totalSale;
	}

	public void setTotalSale(double totalSale) {
		this.totalSale = totalSale;
	}

	public Status getStatusSale() {
		return statusSale;
	}

	public void setStatusSale(Status statusSale) {
		this.statusSale = statusSale;
	}

	public Date getFechafinalSale() {
		return fechafinalSale;
	}

	public void setFechafinalSale(Date fechafinalSale) {
		this.fechafinalSale = fechafinalSale;
	}

	public Customer getCustomerSale() {
		return customerSale;
	}

	public void setCustomerSale(Customer customerSale) {
		this.customerSale = customerSale;
	}

	
	
	
	
}
