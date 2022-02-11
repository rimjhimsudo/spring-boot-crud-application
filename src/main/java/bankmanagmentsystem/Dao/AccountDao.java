package bankmanagmentsystem.Dao;

import bankmanagmentsystem.model.Account;
import bankmanagmentsystem.model.Customer;

import java.util.List;

public interface AccountDao {
    void create(Account account,Customer customer); //create
    Account read(String accNumber);  //get
    List<Account> readAll();        //readAll
    void update(Account account);  //post
    void deleteById(int accId);  //delete
}
