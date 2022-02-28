package bankmanagmentsystem.daos;

import bankmanagmentsystem.models.Account;

import java.util.List;

public interface AccountDao {
    String create(Account account); //create
    Account read(String accNumber);  //get
    List<Account> readAll();        //readAll
    void update(Account account);  //post
    void deleteByNumber(String accNumber);  //delete
}
