package pe.edu.upc.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import pe.edu.upc.spring.model.GarmentType;


public interface IGarmentTypeRepository extends JpaRepository<GarmentType, Integer>{

	@Query("from GarmentType t where t.idGarmentType")
	List<GarmentType>findbyid(@Param("idGarmentType")int idGarmentType);
	
	
}
