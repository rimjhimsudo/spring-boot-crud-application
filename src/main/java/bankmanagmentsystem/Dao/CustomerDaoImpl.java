package bankmanagmentsystem.Dao;

import bankmanagmentsystem.model.Customer;
import bankmanagmentsystem.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

//customerDaoImpl clss-(implements)->customerDao
//customeDaoIml autowire CustomerRepository
//serice java class autowirse DaoInterface
@Component
public class CustomerDaoImpl implements CustomerDaoInterface{

    @Autowired
    CustomerRepository customerRepository;
    @Override
    public void create(Customer customer) {
        //insert method
        customerRepository.save(customer);
    }

    @Override
    public Optional<Customer> read(int id) {
        //get method
        //return null;
        Optional<Customer> customer=customerRepository.findById(id);
        return customer;
    }

    @Override
    public List<Customer> readAll() {
        //return Optional.empty();
        List<Customer> customerslist=new ArrayList<Customer>();
        customerRepository.findAll().forEach(customer -> customerslist.add(customer));
        return customerslist;
    }

    @Override
    public void update(Customer customer) {
        //update any value of  any row already exiting
        customerRepository.save(customer);
    }

    @Override
    public void deleteById(int id) {
        customerRepository.deleteById(id);
    }

}
