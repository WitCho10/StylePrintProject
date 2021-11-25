package pe.edu.upc.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import pe.edu.upc.spring.model.ComplainxCustomer;

@Repository
public interface IComplainxCustomerRepository extends JpaRepository<ComplainxCustomer, Integer>{
	

	@Query("from ComplainxCustomer d where d.customer.nameCustomer like %:nameCustomer%")
	List<ComplainxCustomer> buscarCliente(@Param("nameCustomer") String nameCustomer);

	@Query("from ComplainxCustomer d where d.complain.nameComplain like %:nameComplain%")
	List<ComplainxCustomer> buscarQueja(@Param("nameComplain") String nameComplain);
	
}
