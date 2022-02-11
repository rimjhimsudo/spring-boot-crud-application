package bankmanagmentsystem.daos;

import bankmanagmentsystem.models.Customer;

import java.util.List;

/*
    DAO IS FOR
    1.WRING QUERIES FOR THE DATA WE WANT TO FETCH
    2.FOR EXAMPLE, IF OU ARE TRYING TO DELETE ID WHICH DOESNOT EXIS THEN IT THROWS ERROR AND THAT ERROR
    IS HANDLED IN DAO IMPL

    TO DO: IF YOU WANT TO UPDATE INFO AND NOT MAKE ANYTHING ELSE NULL THEN FIND/FETCH AND SAVE implememtation goes IN DAO
 */
public interface CustomerDao {
    void create(Customer customer); //create
    Customer read(Long id);  //get
    List<Customer> readAll();
    void update(Customer customer);  //post
    void deleteById(Long id);  //delete
    Customer findByName(String cusName);
}
