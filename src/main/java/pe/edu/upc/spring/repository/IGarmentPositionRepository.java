package pe.edu.upc.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import pe.edu.upc.spring.model.GarmentPosition;
import pe.edu.upc.spring.model.Size;

@Repository
public interface IGarmentPositionRepository extends JpaRepository<GarmentPosition,Integer> {

	@Query("from IGarmentPositionRepositoy p where p.namePosition like %:namePosition%")
	List<Size>SearchName(@Param("namePosition")String namePosition);
	}

