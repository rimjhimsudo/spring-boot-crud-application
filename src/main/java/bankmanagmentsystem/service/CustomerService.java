package bankmanagmentsystem.service;

import bankmanagmentsystem.Dao.AccountDaoInterface;
import bankmanagmentsystem.Dao.CustomerDaoImpl;
import bankmanagmentsystem.Dao.CustomerDaoInterface;
import bankmanagmentsystem.exception.ResourceNotfoundException;
import bankmanagmentsystem.model.Account;
import bankmanagmentsystem.model.Customer;
import bankmanagmentsystem.repository.CustomerRepository;
import org.apache.juli.logging.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
// SERVICE CLASS IS FOR DEFINING *****BUSINESS LOGIC*****
/*
    THERE IS ONLY ONE SERVICE CLASS FOR 1 SPRING APPLICATION WHICH DEALS WITH 1 CONTROLLER
 */
@Service
public class CustomerService {
    @Autowired
    AccountDaoInterface accountDaoInterface;
    @Autowired
    CustomerDaoInterface customerDaoInterface;
    /*
    public CustomerService(CustomerDaoInterface customerDaoInterface,) {
        this.customerDaoInterface = customerDaoInterface;
    }
    */
    // *************customer api************
    public List<Customer>  getAllCustomers(){
       List<Customer>  customerslist=new ArrayList<Customer>();
        customerDaoInterface.readAll().forEach(customer -> customerslist.add(customer));//lambda expession
        return customerslist;
    }
    public Customer getCustomerByID(int cusID) throws ResourceNotfoundException{
        Customer customer= customerDaoInterface.read(cusID);
        if(customer==null){
            throw new ResourceNotfoundException("Customer with this id does not exist");
        }
        return customer;
    }

    public void save(Customer customer) {
        customerDaoInterface.create(customer); //for the first time row is created
    }
    public void update(Customer customer) {
        customerDaoInterface.update(customer); //when already made customer details are updated
    }
    public void deleteById(int cusID) {
        customerDaoInterface.deleteById(cusID);
    }

    // *************account api************
    public List<Account> getAllAccounts(){
        List<Account> accountList=new ArrayList<>();
        for (Account account : accountDaoInterface.readAll()) {
            accountList.add(account);
        }
        return accountList;
    }
    public Account getByAccNumber(String  accNumber){
        return accountDaoInterface.read(accNumber);
    }
    public void saveAccount(Account account){
        accountDaoInterface.create(account);
    }
    public void update(Account account){
        accountDaoInterface.update(account);
    }
    public void deleteByByAccNumber(Integer accNumber){
        accountDaoInterface.deleteById(Math.toIntExact(accNumber));
    }
    // method to withdraw money from account
    public String withdraw(String  accNumber,int amount){
        String answer=new String();
        Account myAccount =accountDaoInterface.read(accNumber);
        int balance=myAccount.getAccBalance();
        if(balance>=amount){
            balance-=amount;
            myAccount.setAccBalance(balance);
            answer="Your balance is : "+ balance;
        }
        else{
            answer="You dont have sufficient balance to withdraw";
        }
        return answer;
    }


}
