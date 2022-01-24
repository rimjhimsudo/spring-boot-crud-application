package bankmanagmentsystem.controller;

import bankmanagmentsystem.exception.ResourceNotfoundException;
import bankmanagmentsystem.model.Account;
import bankmanagmentsystem.model.Customer;
import bankmanagmentsystem.service.CustomerService;
import org.hibernate.dialect.LobMergeStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
/*
    THERE IS ONE CONTROLLER WHICH EXPOSES TO WEB FOR API CALLING
*/
@RestController
public class CustomerController {
    /*autowiring customer service class here is important coz you cant instatantiate any object
     so annotation is importnt OR YOU CAN CALL CONSTRUCTOR AND INSTANTIATE SERVICE THERE BECAUSE
     ANNOTATION SOMETIMES GIVES ERROR
     */
    @Autowired
    CustomerService customerService;
    //creating mapping that retrieves all customers
    @GetMapping("/customer")
    private List<Customer> getAllcustomers(){
        //return Arrays.asList(new Customer(1,"Database",95603));
        return customerService.getAllCustomers();
    }
    //creating mapping that get you a customer by id
    /*
        WHEN GIVING 'cusId' AS PATH VARIABLE THEN IT IS NOT PARAM IN POSTMAN AND USE @PATHVARIABLE
    */
    @GetMapping("/customer/{cusId}")
    private Customer getCustomer(@PathVariable int cusId) throws ResourceNotfoundException {
        return customerService.getCustomerByID(cusId);
    }


    @DeleteMapping("/customer/{cusId}")
    private void deleteCustomer(@PathVariable int cusId){
        customerService.deleteById(cusId);
    }

    //post that post details of customer in database
    @PostMapping("/customer")
    private int saveCustomer(@RequestBody Customer customer){
        customerService.save(customer);
        return customer.getCusId();
    }
    //creating put mapping that updates details of customers
    /*@PatchMapping("/customer")
    private Customer update(@RequestBody Customer customer){
        customerService.save(customer);
        return customer;
    }*/
    @PatchMapping("/customer") //use fields not body
    public void updateCustomer(@RequestBody Customer customer) throws ResourceNotfoundException {
        //not making other not specified value as null but persisting
        Customer myCustomer = customerService.getCustomerByID(customer.getCusId());
        //these checks are for values that are provided on postman
        if(customer.getCusName()!=null){
            myCustomer.setCusName(customer.getCusName());
        }
        if(customer.getCusPhoneNumber()!=null){
            myCustomer.setCusPhoneNumber(customer.getCusPhoneNumber());
        }
        if(customer.getCusAddress()!=null){
            myCustomer.setCusAddress(customer.getCusAddress());
        }

        customerService.save(myCustomer);
    }
    //findAndUpdate use
    @PostMapping("/saveaccount")
    public String saveAccount(@RequestBody Account account){
        customerService.saveAccount(account);
        return account.getAccNumber();
    }
    @GetMapping("/getaccount/{accNumber}")
    public Account getAccount(@PathVariable String accNumber){
        return customerService.getByAccNumber(accNumber);
    }

    @GetMapping("/withdraw")
    private String withdraw(@RequestParam String accNumber, @RequestParam int amount){
        String ans=customerService.withdraw(accNumber,amount);
        return ans;
    }





















}
