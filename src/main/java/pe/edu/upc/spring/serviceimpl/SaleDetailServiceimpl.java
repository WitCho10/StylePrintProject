 package pe.edu.upc.spring.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upc.spring.model.SaleDetail;
import pe.edu.upc.spring.repository.ISaleDetailRepository;
import pe.edu.upc.spring.service.ISaleDetailService;

@Repository
public class SaleDetailServiceimpl implements ISaleDetailService{

	@Autowired
	private ISaleDetailRepository sSaleDetail;

	@Override
	@Transactional
	public boolean Registrar(SaleDetail saleDetail) {
		SaleDetail objSaleDetail=sSaleDetail.save(saleDetail);
		if(objSaleDetail==null)
		return false;
		else 
			return true;
	}

	@Override
	@Transactional
	public void Eliminar(int idSaleDetail) {
		// TODO Auto-generated method stub
		sSaleDetail.deleteById(idSaleDetail);
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<SaleDetail> ListarId(int idSaleDetail) {
	
		return sSaleDetail.findById(idSaleDetail);
	}

	@Override
	@Transactional(readOnly = true)
	public List<SaleDetail> listar() {

		return sSaleDetail.findAll();
	}
	
	
}