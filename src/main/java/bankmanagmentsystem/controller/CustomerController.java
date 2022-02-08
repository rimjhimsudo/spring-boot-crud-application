package bankmanagmentsystem.controller;

import bankmanagmentsystem.exception.ResourceNotfoundException;
import bankmanagmentsystem.model.Account;
import bankmanagmentsystem.model.Customer;
import bankmanagmentsystem.response.BaseResponse;
import bankmanagmentsystem.service.CustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.Arrays;
import java.util.List;
/*
    THERE IS ONE CONTROLLER WHICH EXPOSES TO WEB FOR API CALLING
*/
@RestController
public class CustomerController {
    BaseResponse baseResponse=new BaseResponse();
    CustomerService customerService;
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    //creating mapping that retrieves all customers
    @GetMapping("/customer")
    public List<Customer> getAllcustomers(){
        //return Arrays.asList(new Customer(1,"Database",95603)); //can be used to instantite here
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

    //insert details of customer in database
    @PostMapping("/customer")
    private int saveCustomer(@RequestBody Customer customer){
        customerService.save(customer);
        return customer.getCusId();
    }

    //patch mapping that updates details of customers
    @PatchMapping("/customer")
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

    // create account
    @PostMapping("/account")
    public String saveAccount(@RequestBody Account account){
        customerService.saveAccount(account);
        return account.getAccNumber();
    }
    //get accunt details
    @GetMapping("/account/{accNumber}")
    public Account getAccount(@PathVariable String accNumber){
        return customerService.getByAccNumber(accNumber);
    }

    //to deduct amount from account balance
    @GetMapping("/withdraw")
    private BaseResponse withdraw(@RequestParam String accNumber, @RequestParam int amount){
        String answer=customerService.withdraw(accNumber,amount);
        baseResponse.setResponseMessage(answer);
        baseResponse.setResponseCode(HttpStatus.OK.toString());
        return baseResponse;
    }





















}
