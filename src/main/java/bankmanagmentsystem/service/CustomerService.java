package bankmanagmentsystem.service;

import bankmanagmentsystem.Dao.CustomerDaoImpl;
import bankmanagmentsystem.Dao.CustomerDaoInterface;
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
    CustomerDaoInterface customerDaoInterface;
    public List<Customer>  getAllCustomers(){
       List<Customer>  customerslist=new ArrayList<Customer>();
       //customerRepository.findAll().forEach(customer -> customerslist.add(customer));
        customerDaoInterface.readAll().forEach(customer -> customerslist.add(customer));//lambda expession
        return customerslist;
    }

    public Customer getCustomerByID(int cusID) {
        //return customerRepository.findById(cusID).get();
        return customerDaoInterface.read(cusID).get();
    }

    public void deleteById(int cusID) {
        //customerRepository.deleteById(cusID);
        customerDaoInterface.deleteById(cusID);
    }



    public void save(Customer customer) {
        //customerRepository.save(customer);
        customerDaoInterface.create(customer); //for the first time row is created

    }
    public void update(Customer customer) {
        //customerRepository.save(customer);
        customerDaoInterface.update(customer); //when already made customer details are updated
    }
}
