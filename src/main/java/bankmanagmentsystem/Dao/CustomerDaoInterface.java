package bankmanagmentsystem.Dao;

import bankmanagmentsystem.model.Customer;

import java.util.List;
import java.util.Optional;

public interface CustomerDaoInterface  {
    void create(Customer customer); //create
    Optional<Customer> read(int id);  //get
    List<Customer> readAll();
    void update(Customer customer);  //post
    void deleteById(int id);  //delete
}
