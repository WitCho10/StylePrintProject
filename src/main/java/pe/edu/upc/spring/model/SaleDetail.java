package pe.edu.upc.spring.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="DetalleVenta")

public class SaleDetail implements Serializable{

	public SaleDetail(int idSaleDetail, int cant, float subTotal) {
		super();
		this.idSaleDetail = idSaleDetail;
		this.cant = cant;
		this.subTotal = subTotal;
	}
	public SaleDetail() {
		super();
		// TODO Auto-generated constructor stub
	}
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	
	private int idSaleDetail;
	private int cant;
	private float subTotal;
	
	public int getIdSaleDetail() {
		return idSaleDetail;
	}
	public void setIdSaleDetail(int idSaleDetail) {
		this.idSaleDetail = idSaleDetail;
	}
	public int getCant() {
		return cant;
	}
	public void setCant(int cant) {
		this.cant = cant;
	}
	public float getSubTotal() {
		return subTotal;
	}
	public void setSubTotal(float subTotal) {
		this.subTotal = subTotal;
	}
	
	
	
}
