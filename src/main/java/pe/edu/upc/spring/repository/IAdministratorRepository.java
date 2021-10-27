 package pe.edu.upc.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import pe.edu.upc.spring.model.Administrator;

@Repository
public interface IAdministratorRepository extends JpaRepository<Administrator, Integer> {
	

	@Query("from Administrator a where a.Email=? and p.Password =?")
	List<Administrator>searchName(@Param("nameAdmin")String nameAdmin);
	
	
}
