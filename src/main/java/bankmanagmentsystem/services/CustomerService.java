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
//@Service
public class CustomerService {
    AccountDao accountDao;
    CustomerDao customerDao;

    //instantiating to autowire DAOS
    public CustomerService(AccountDao accountDao, CustomerDao customerDao) {
        this.accountDao = accountDao;
        this.customerDao = customerDao;
    }
    //to get all customers from db
    public List<Customer>  getAllCustomers(){
       List<Customer>  customerslist=new ArrayList<Customer>();
        customerDao.readAll().forEach(customer -> customerslist.add(customer));//lambda expession
        return customerslist;
    }
    //to get customer by id from db
    public Customer getCustomerById(Long cusID) throws ResourceNotfoundException{
        Customer customer= customerDao.read(cusID);
        if(customer==null){
            throw new ResourceNotfoundException("Customer with this id does not exist");
        }
        return customer;
    }
    //to insert customer into db
    public void save(Customer customer) {
        customerDao.create(customer); //for the first time row is created
    }
    public void update(Customer customer) {
        customerDao.update(customer); //when already made customer details are updated
    }
    //to delete customer from db
    public void deleteById(Long cusID) {
        customerDao.deleteById(cusID);
    }


    public Customer getCustomerByName(String cusName) throws ResourceNotfoundException{
            Customer customer= customerDao.findByName(cusName);
            if(customer==null){
                throw new ResourceNotfoundException("Customer with this name does not exist");
            }
            return customer;
    }



}
