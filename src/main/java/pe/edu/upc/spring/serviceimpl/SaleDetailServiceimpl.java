package pe.edu.upc.spring.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upc.spring.model.SaleDetail;
import pe.edu.upc.spring.service.ISaleDetailService;

@Repository
public class SaleDetailServiceimpl implements ISaleDetailService{

	@Autowired
	private ISaleDetailService dDetailService;
	
	@Override
	@Transactional
	public boolean insertar(SaleDetail saleDetail) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	@Transactional
	public boolean modify(SaleDetail saleDetail) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	@Transactional
	public void remove(int idSaleDetail) {
		// TODO Auto-generated method stub
		
	}

	@Override
	@Transactional
	public List<SaleDetail> listar() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional
	public List<SaleDetail> finbyid(int idSaleDetail) {
		// TODO Auto-generated method stub
		return null;
	}
	

}
