package bankmanagmentsystem.services;

import bankmanagmentsystem.daos.AccountDao;
import bankmanagmentsystem.daos.CustomerDao;
import bankmanagmentsystem.exceptions.ResourceNotfoundException;
import bankmanagmentsystem.models.Customer;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
// SERVICE CLASS IS FOR DEFINING *****BUSINESS LOGIC*****
/*
    THERE IS ONLY ONE SERVICE CLASS FOR 1 SPRING APPLICATION WHICH DEALS WITH 1 CONTROLLER
 */
@Service
public class CustomerServiceImpl implements CustomerService{
    AccountDao accountDao;
    CustomerDao customerDao;

    //instantiating to autowire DAOS
    public CustomerServiceImpl(AccountDao accountDao, CustomerDao customerDao) {
        this.accountDao = accountDao;
        this.customerDao = customerDao;
    }
    //to get all customers from db
    public List<Customer>  getAllCustomers(){
       List<Customer>  customerslist=new ArrayList<bankmanagmentsystem.models.Customer>();
        customerDao.readAll().forEach(customer -> customerslist.add(customer));//lambda expession
        return customerslist;
    }
    //to get customer by id from db
    public Customer getCustomerById(Long cusID) throws ResourceNotfoundException{
        Customer customer= this.customerDao.read(cusID);
        if(customer==null){
            throw new ResourceNotfoundException("Customer with this id does not exist");
        }
        return customer;
    }
    //to insert customer into db
    public void save(Customer customer) {
        this.customerDao.create(customer); //for the first time row is created
    }
    public void update(Customer customer) {
        this.customerDao.update(customer); //when already made customer details are updated
    }
    //to delete customer from db
    public void deleteById(Long cusID) {
        customerDao.deleteById(cusID);
    }


    public Customer getCustomerByName(String cusName) throws ResourceNotfoundException{
            Customer customer= this.customerDao.findByName(cusName);
            if(customer==null){
                throw new ResourceNotfoundException("Customer with this name does not exist");
            }
            return customer;
    }



}
