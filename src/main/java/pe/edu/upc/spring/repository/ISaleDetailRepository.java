package pe.edu.upc.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import pe.edu.upc.spring.model.SaleDetail;

@Repository
public interface ISaleDetailRepository extends JpaRepository<SaleDetail, Integer> {
	
	@Query("from SaleDetail s where s.idSaleDetail")
	List<SaleDetail>findbyid(@Param("idSaleDetail")int idSaleDetail);
	
	

}
