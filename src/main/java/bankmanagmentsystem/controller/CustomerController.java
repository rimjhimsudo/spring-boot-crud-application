package bankmanagmentsystem.controller;

import bankmanagmentsystem.model.Customer;
import bankmanagmentsystem.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
public class CustomerController {
    //autowiring customer service class here is important coz you cant instatantiate any obect so annotation is importnt
    @Autowired
    CustomerService customerService;
    //creating mapping that retrieves all customers
    @GetMapping("/customer")
    private List<Customer> getAllcustomers(){
        //return Arrays.asList(new Customer(1,"Database",95603));
        return customerService.getAllCustomers();
    }

    //creating mapping that get you a customer by id
    @GetMapping("/customer{cusID}")
    private int getCustomer(@RequestParam("cusID") int cusID){
        return customerService.getCustomerByID(cusID).getCus_id();
    }


    @DeleteMapping("/customer")
    private void deleteCustomer(@RequestParam("cusID") int cusID){
        customerService.delete(cusID);
    }

    //post that post details of customer in database
    @PostMapping("/customer")
    private int saveCustomer(@RequestBody Customer customer){
        customerService.save(customer);
        return customer.getCus_id();
    }
    //creating put mapping that updates details of customers
    @PutMapping("/customer")
    private Customer update(@RequestBody Customer customer){
        customerService.save(customer);
        return customer;
    }







}
