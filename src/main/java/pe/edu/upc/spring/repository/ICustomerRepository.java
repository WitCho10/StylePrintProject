package pe.edu.upc.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import pe.edu.upc.spring.model.Customer;

@Repository
public interface ICustomerRepository extends JpaRepository<Customer, Integer>{

	@Query("from Customer d where d.nameCustomer like %:nameCustomer%")
	List<Customer> buscarNombre(@Param("nameCustomer") String nameCustomer);
	
//	@Query("from Customer d where d.emailCustomer=? and d.passwordCustomer=?")
//	Customer buscarPorUsernameYPassword(String emailCustomer, String passwordCustomer);

	public Customer findByEmailCustomer(String emailCustomer);
	
}
