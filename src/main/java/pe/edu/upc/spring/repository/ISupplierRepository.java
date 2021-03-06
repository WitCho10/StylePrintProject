package pe.edu.upc.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import pe.edu.upc.spring.model.Supplier;

@Repository
public interface ISupplierRepository extends JpaRepository<Supplier , Integer>{
	
	@Query("from Supplier s where s.nameSupplier like %:nameSupplier%")
	List<Supplier> buscarNombre(@Param("nameSupplier")String nameSupplier);
}
