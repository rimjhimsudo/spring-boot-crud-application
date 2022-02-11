package bankmanagmentsystem.Dao.implementation;

import bankmanagmentsystem.Dao.CustomerDao;
import bankmanagmentsystem.model.Customer;
import bankmanagmentsystem.repository.CustomerRepository;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

//customerDaoImpl clss-(implements)->customerDao
//customeDaoIml autowire CustomerRepository
//serice java class autowirse DaoInterface
@Component
public class CustomerDaoImpl implements CustomerDao {

    /*
    DAO : for filtering/processing result set
     */
    CustomerRepository customerRepository;
    /*
    You can either autowire repo or you can make constructor of daoImpl and initialise repository as done in below line
     */

    public CustomerDaoImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public void create(Customer customer) {
        //insert method
        customerRepository.save(customer);
    }
    /*
      TO DO: see if throws exception if null
     */
    @Override
    public Customer read(Long id) {
        Customer customer=customerRepository.findBycusId(id);
        return customer;
    }

    @Override
    public List<Customer> readAll() {
        List<Customer> customerslist=new ArrayList<Customer>();
        customerRepository.findAll().forEach(customer -> customerslist.add(customer));
        return customerslist;
    }

    @Override
    public void update(Customer customer) {
        //update any value of  any row already exiting
        //use find by id then modify object
        //then modify
        customerRepository.save(customer);
    }

    @Override
    public void deleteById(Long id) {
        customerRepository.deleteBycusId(id);
    }

    @Override
    public Customer findBycusName(String cusName) {
        Customer myCustomer=customerRepository.findBycusName(cusName);
        return myCustomer;
    }

}
