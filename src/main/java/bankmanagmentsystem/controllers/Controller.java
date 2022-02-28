package bankmanagmentsystem.controllers;

import bankmanagmentsystem.exceptions.ResourceNotfoundException;
import bankmanagmentsystem.models.Account;
import bankmanagmentsystem.models.Customer;
import bankmanagmentsystem.models.DebitCard;
import bankmanagmentsystem.response.BaseResponse;
import bankmanagmentsystem.services.AccountServiceImpl;
import bankmanagmentsystem.services.CustomerServiceImpl;
import bankmanagmentsystem.services.DebitCardServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;
/*
    THERE IS ONE CONTROLLER WHICH EXPOSES TO WEB FOR API CALLING
*/
@RestController
public class Controller {
    BaseResponse baseResponse=new BaseResponse();
    CustomerServiceImpl customerServiceImpl;
    AccountServiceImpl accountServiceImpl ;
    DebitCardServiceImpl debitCardServiceImpl;

    public Controller(CustomerServiceImpl customerServiceImpl, AccountServiceImpl accountServiceImpl, DebitCardServiceImpl debitCardServiceImpl) {
        this.customerServiceImpl = customerServiceImpl;
        this.accountServiceImpl = accountServiceImpl;
        this.debitCardServiceImpl = debitCardServiceImpl;
    }

    //creating mapping that retrieves all customers
    @GetMapping("/customers")
    public List<Customer> getAllcustomers(){
        //return Arrays.asList(new Customer(1,"Database",95603)); //can be used to instantite here
        return customerServiceImpl.getAllCustomers();
    }
    //creating mapping that get you a customer by id
    /*
        WHEN GIVING 'cusId' AS PATH VARIABLE THEN IT IS NOT PARAM IN POSTMAN AND USE @PATHVARIABLE
    */
    @GetMapping("/customer/{cusId}")
    private Customer getCustomer(@PathVariable Long cusId) throws ResourceNotfoundException {
        return customerServiceImpl.getCustomerById(cusId);
    }

    @DeleteMapping("/customer/{cusId}")
    private void deleteCustomer(@PathVariable Long cusId){
        customerServiceImpl.deleteById(cusId);
    }

    //insert details of customer in database
    @PostMapping("/customer")
    private Long saveCustomer(@RequestBody Customer customer){
        customerServiceImpl.save(customer);
        return customer.getId();
    }

    //patch mapping that updates details of customers
    @PatchMapping("/customer")
    public Long updateCustomer(@RequestBody Customer customer) throws ResourceNotfoundException {
        //not making other not specified value as null but persisting
        Customer myCustomer = customerServiceImpl.getCustomerById(customer.getId());
        //these checks are for values that are provided on postman
        if(customer.getName()!=null){
            myCustomer.setName(customer.getName());
        }
        if(customer.getPhoneNumber()!=null){
            myCustomer.setPhoneNumber(customer.getPhoneNumber());
        }
        if(customer.getAddress()!=null){
            myCustomer.setAddress(customer.getAddress());
        }
        customerServiceImpl.update(myCustomer);
        return myCustomer.getId();
    }
    @GetMapping("/customer/name/{cusName}")
    private Customer getCustomerByName(@PathVariable String cusName) throws ResourceNotfoundException {
        return customerServiceImpl.getCustomerByName(cusName); //ideally it must be a list
    }

    // create account
    @PostMapping("/account")
    public String saveAccount(@RequestBody Account account,@RequestParam Long cusId){

        accountServiceImpl.saveAccount(account,cusId);
        return account.getNumber();
    }
    //get account details
    @GetMapping("/account/{accNumber}")
    public Account getAccount(@PathVariable String accNumber){
        return accountServiceImpl.getByAccNumber(accNumber);
    }

    //to deduct amount from account balance
    @PostMapping("/account/debit")
    private BaseResponse balanceDeduct(@RequestParam String accNumber, @RequestParam int amount){
        String answer= accountServiceImpl.debit(accNumber,amount);
        baseResponse.setResponseMessage(answer);
        baseResponse.setResponseCode(HttpStatus.OK.toString());
        return baseResponse;
    }

    @PostMapping("/account/credit")
    private BaseResponse balanceAdd(@RequestParam String accNumber, @RequestParam int amount){
        String answer= accountServiceImpl.credit(accNumber,amount);
        baseResponse.setResponseMessage(answer);
        baseResponse.setResponseCode(HttpStatus.OK.toString());
        baseResponse.setStatus("SUCCESS");
        return baseResponse;
    }

    /*@GetMapping("/debitcards")
    public List<Customer> getAllDebitCards(){
        
        //return debitCardService.getAll();
    }*/
   @PostMapping("/debit")
    public String saveDebitCard(@RequestBody DebitCard debitCard){
        DebitCard db=debitCardServiceImpl.save(debitCard);
        return db.getHolderName();
    }
    @GetMapping("/debitcards")
    public List<DebitCard> getAllDebitCards(){
       return debitCardServiceImpl.getAll();
    }
    @GetMapping("/debitcard/{number}")
    public DebitCard getDebitCardByNumber(@PathVariable String number) throws ResourceNotfoundException {
       return debitCardServiceImpl.getByNumber(number);

    }









}
