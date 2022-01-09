package bankmanagmentsystem.repository;

import bankmanagmentsystem.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CustomerRepository extends CrudRepository<Customer,Integer> {

   /*List<Customer> findAll(int cusID); ///sql query
    Customer findById(int cusID);*/
}
