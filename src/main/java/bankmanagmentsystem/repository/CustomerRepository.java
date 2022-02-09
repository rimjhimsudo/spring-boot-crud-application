package bankmanagmentsystem.repository;

import bankmanagmentsystem.model.Account;
import bankmanagmentsystem.model.Customer;
import org.springframework.data.annotation.QueryAnnotation;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/*
    REPOSITORY IS FOR 2 THINGS:
    1.WRITING NATIVE SQL QUERIES
    2.
    AND
    REPOSITORY IS AUTOWIRED  TO DAOIMPL JAVA CLASS
 */
@Repository
public interface CustomerRepository extends CrudRepository<Customer,Integer> {
    //@Query(value = "select * from customer where cusId=:id",nativeQuery = true)
    //public Customer findByCusId(int cusId);
    public List<Customer> findAll();
    public Customer findById(Long cusId);
    public Customer findBycusName(String cusName);
    public Customer save(Customer customer);
    public void deleteById(Long cusId);

}
