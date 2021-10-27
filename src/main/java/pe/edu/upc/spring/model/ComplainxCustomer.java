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
@Table(name="QuejaxCliente")
public class ComplainxCustomer implements Serializable{

	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idComplainxCustomer;
	
	@Column(name="asuntoQuejaxCliente")
	private String affairComplainxCustomer;
	
	@ManyToOne
	@JoinColumn(name="idCustomer",nullable=false)
	private Customer customer;
	
	@ManyToOne
	@JoinColumn(name="idComplain",nullable=false)
	private Complain complain;
	
	@Temporal(TemporalType.DATE)
	@Column(name="fechaQueja")
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date dateComplainxCustomer;
	
	@Column(name="detalleQuejaxCliente",length=100,nullable=false)
	private String detailComplainxCustomer;

	public ComplainxCustomer() {
		super();
		
	}

	public ComplainxCustomer(int idComplainxCustomer, String affairComplainxCustomer, Customer customer,
			Complain complain, Date dateComplainxCustomer, String detailComplainxCustomer) {
		super();
		this.idComplainxCustomer = idComplainxCustomer;
		this.affairComplainxCustomer = affairComplainxCustomer;
		this.customer = customer;
		this.complain = complain;
		this.dateComplainxCustomer = dateComplainxCustomer;
		this.detailComplainxCustomer = detailComplainxCustomer;
	}

	public int getIdComplainxCustomer() {
		return idComplainxCustomer;
	}

	public void setIdComplainxCustomer(int idComplainxCustomer) {
		this.idComplainxCustomer = idComplainxCustomer;
	}

	public String getAffairComplainxCustomer() {
		return affairComplainxCustomer;
	}

	public void setAffairComplainxCustomer(String affairComplainxCustomer) {
		this.affairComplainxCustomer = affairComplainxCustomer;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Complain getComplain() {
		return complain;
	}

	public void setComplain(Complain complain) {
		this.complain = complain;
	}

	public Date getDateComplainxCustomer() {
		return dateComplainxCustomer;
	}

	public void setDateComplainxCustomer(Date dateComplainxCustomer) {
		this.dateComplainxCustomer = dateComplainxCustomer;
	}

	public String getDetailComplainxCustomer() {
		return detailComplainxCustomer;
	}

	public void setDetailComplainxCustomer(String detailComplainxCustomer) {
		this.detailComplainxCustomer = detailComplainxCustomer;
	}

	
	
	
	
	
	
}
