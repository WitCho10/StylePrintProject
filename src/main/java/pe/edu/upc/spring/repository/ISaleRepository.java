package pe.edu.upc.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pe.edu.upc.spring.model.Sale;

public interface ISaleRepository extends JpaRepository<Sale, Integer>{
	
}
