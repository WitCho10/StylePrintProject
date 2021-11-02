package pe.edu.upc.spring.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upc.spring.model.SaleDetail;
import pe.edu.upc.spring.repository.ISaleDetailRepository;
import pe.edu.upc.spring.service.ISaleDetailService;

@Service
public class SaleDetailServiceImpl implements ISaleDetailService{

	@Autowired
	private ISaleDetailRepository sdSaleDetail;
	
	@Override
	@Transactional
	public boolean Registrar(SaleDetail saledetail) {
		SaleDetail objSaleDetail = sdSaleDetail.save(saledetail);
		if(objSaleDetail==null)
			return false;
		else
			return true;
	}

	@Override
	@Transactional
	public void eliminar(int idSaleDetail) {
		sdSaleDetail.deleteById(idSaleDetail);
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<SaleDetail> listarId(int idSaleDetail) {
		return sdSaleDetail.findById(idSaleDetail);
	}

	@Override
	@Transactional(readOnly = true)
	public List<SaleDetail> listar() {
		return sdSaleDetail.findAll();
	}
	

}
