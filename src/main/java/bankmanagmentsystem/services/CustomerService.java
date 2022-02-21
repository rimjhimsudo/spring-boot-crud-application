package bankmanagmentsystem.services;

import bankmanagmentsystem.exceptions.ResourceNotfoundException;
import bankmanagmentsystem.models.Customer;

import java.util.List;

public interface CustomerService {
    List<Customer> getAllCustomers();
    Customer getCustomerById(Long cusID) throws ResourceNotfoundException;
    void save(Customer customer);
    void deleteById(Long cusID);
    Customer getCustomerByName(String cusName) throws ResourceNotfoundException;
}
