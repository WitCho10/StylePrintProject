 package pe.edu.upc.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import pe.edu.upc.spring.model.Administrator;

@Repository
public interface IAdministratorRepository extends JpaRepository<Administrator, Integer> {
	
	@Query("from Administrator p where p.nameAdministrator like %:nameAdministrator%")
	List<Administrator> buscarNombre(@Param("nameAdministrator") String nameAdministrator);
	
	public Administrator findByEmailAdministrator(String emailAdministrator);
	
}
