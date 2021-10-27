package pe.edu.upc.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import pe.edu.upc.spring.model.Size;

@Repository
public interface ISizeRepository extends JpaRepository<Size, Integer>{
@Query("from size s where s.NameSize like %:NameSize%")
List<Size>SearchName(@Param("NameSize")String NameSize);
}

	
