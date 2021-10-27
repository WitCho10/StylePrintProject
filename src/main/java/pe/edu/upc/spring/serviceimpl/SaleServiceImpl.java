package pe.edu.upc.spring.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upc.spring.model.Sale;
import pe.edu.upc.spring.repository.ISaleRepository;
import pe.edu.upc.spring.service.ISaleService;

@Service
public class SaleServiceImpl implements ISaleService{

	@Autowired
	private ISaleRepository sSale;
	
	@Override
	@Transactional
	public boolean Registrar(Sale sale) {
		Sale objSale = sSale.save(sale);
		if(objSale==null)
			return false;
		else
			return true;
	}
	
	@Override
	@Transactional
	public void eliminar(int idSale) {
		sSale.deleteById(idSale);
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Sale> listarId(int idSale) {
		return sSale.findById(idSale);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Sale> listar() {
		return sSale.findAll();
	}


}
