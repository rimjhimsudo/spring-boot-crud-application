package bankmanagmentsystem.daos;

import bankmanagmentsystem.models.Account;

import java.util.List;

public interface AccountDao {
    void create(Account account); //create
    Account read(String accNumber);  //get
    List<Account> readAll();        //readAll
    void update(Account account);  //post
    void deleteById(int accId);  //delete
}
