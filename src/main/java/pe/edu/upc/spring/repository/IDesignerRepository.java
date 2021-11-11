package pe.edu.upc.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import pe.edu.upc.spring.model.Designer;

@Repository
public interface IDesignerRepository extends JpaRepository<Designer, Integer>{

	@Query("from Designer d where d.nameDesigner like %:nameDesigner%")
	List<Designer> buscarNombre(@Param("nameDesigner") String nameDesigner);

	public Designer findByUsername(String username);
	
}
