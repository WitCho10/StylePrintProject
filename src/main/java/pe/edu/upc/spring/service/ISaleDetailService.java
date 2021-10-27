package pe.edu.upc.spring.service;

import java.util.List;

import pe.edu.upc.spring.model.SaleDetail;

public interface ISaleDetailService {

	public boolean insertar(SaleDetail saleDetail);
	public boolean modify(SaleDetail saleDetail);
	public void remove(int idSaleDetail );
	List<SaleDetail> listar();
	List<SaleDetail>finbyid(int idSaleDetail);
}
