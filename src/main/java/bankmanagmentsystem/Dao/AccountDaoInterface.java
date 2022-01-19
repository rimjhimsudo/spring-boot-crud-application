package bankmanagmentsystem.Dao;

import bankmanagmentsystem.model.Account;
import bankmanagmentsystem.model.Customer;

import java.util.List;

public interface AccountDaoInterface {
    void create(Account account); //create
    Account read(String accNumber);  //get
    List<Account> readAll();
    void update(Account account);  //post
    void deleteById(int accId);  //delete
}
