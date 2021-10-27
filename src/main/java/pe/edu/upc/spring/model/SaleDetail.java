package pe.edu.upc.spring.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="DetalleVenta")
public class SaleDetail implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idSaleDetail;
	
	@Column(name="cantidadDetalleVenta",length=60,nullable=false)
	private int amountSaleDetail;
	
	@Column(name="subtotalDetalleVenta",length=60,nullable=false)
	private float subTotalSaleDetail;
	
	@ManyToOne
	@JoinColumn(name="idSale",nullable=false)
	private Sale sale;
	
	@ManyToOne
	@JoinColumn(name="idGarmentPersonalized",nullable=false)
	private GarmentPersonalized garmentpersonalized;

	public SaleDetail() {
		super();
		
	}

	public SaleDetail(int idSaleDetail, int amountSaleDetail, float subTotalSaleDetail, Sale sale,
			GarmentPersonalized garmentpersonalized) {
		super();
		this.idSaleDetail = idSaleDetail;
		this.amountSaleDetail = amountSaleDetail;
		this.subTotalSaleDetail = subTotalSaleDetail;
		this.sale = sale;
		this.garmentpersonalized = garmentpersonalized;
	}

	public int getIdSaleDetail() {
		return idSaleDetail;
	}

	public void setIdSaleDetail(int idSaleDetail) {
		this.idSaleDetail = idSaleDetail;
	}

	public int getAmountSaleDetail() {
		return amountSaleDetail;
	}

	public void setAmountSaleDetail(int amountSaleDetail) {
		this.amountSaleDetail = amountSaleDetail;
	}

	public float getSubTotalSaleDetail() {
		return subTotalSaleDetail;
	}

	public void setSubTotalSaleDetail(float subTotalSaleDetail) {
		this.subTotalSaleDetail = subTotalSaleDetail;
	}

	public Sale getSale() {
		return sale;
	}

	public void setSale(Sale sale) {
		this.sale = sale;
	}

	public GarmentPersonalized getGarmentpersonalized() {
		return garmentpersonalized;
	}

	public void setGarmentpersonalized(GarmentPersonalized garmentpersonalized) {
		this.garmentpersonalized = garmentpersonalized;
	}
	
	
	
	
}
