package pe.edu.upc.spring.service;

import java.util.List;
import java.util.Optional;

import pe.edu.upc.spring.model.SaleDetail;

public interface ISaleDetailService {

	public boolean Registrar(SaleDetail saleDetail);
	public void Eliminar(int idSaleDetail );
	public Optional<SaleDetail>ListarId(int idSaleDetail);
	List<SaleDetail> listar();

}
