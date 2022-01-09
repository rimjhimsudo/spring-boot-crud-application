package bankmanagmentsystem.service;

import bankmanagmentsystem.model.Customer;
import bankmanagmentsystem.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
// SERVICE CLASS IS FOR DEFINING BUSINESS LOGIC
@Service
public class CustomerService {
    @Autowired
    CustomerRepository customerRepository;
    public List<Customer>  getAllCustomers(){
       List<Customer>  customerslist=new ArrayList<Customer>();
       customerRepository.findAll().forEach(customer -> customerslist.add(customer)); //lambda expession
        return customerslist;
    }

    public Customer getCustomerByID(int cusID) {
        return customerRepository.findById(cusID).get();
    }

    public void delete(int cusID) {
        customerRepository.deleteById(cusID);
    }

    public void save(Customer customer) {
        customerRepository.save(customer);
    }
    public void update(Customer customer) {
        customerRepository.save(customer);
    }
}
