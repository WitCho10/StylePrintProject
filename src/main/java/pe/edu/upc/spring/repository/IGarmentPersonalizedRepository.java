package pe.edu.upc.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import pe.edu.upc.spring.model.GarmentPersonalized;


@Repository
public interface IGarmentPersonalizedRepository extends JpaRepository<GarmentPersonalized, Integer>{
	
	@Query("from GarmentPersonalized d where d.urlimageGarmentPersonalized like %:urlimageGarmentPersonalized%")
	List<GarmentPersonalized> buscarUrl(@Param("urlimageGarmentPersonalized") String urlimageGarmentPersonalized);
	
	@Query("from GarmentPersonalized d where d.customer.nameCustomer like %:nameCustomer%")
	List<GarmentPersonalized> buscarCliente(@Param("nameCustomer") String nameCustomer);
}
