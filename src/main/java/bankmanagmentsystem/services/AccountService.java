package bankmanagmentsystem.services;

import bankmanagmentsystem.models.Account;

import java.util.List;

public interface AccountService {
    List<Account> getAllAccounts();
    Account getByAccNumber(String accNumber);
    void saveAccount(Account account,Long cusId);
    void update(Account account);
    void deleteByByAccNumber(Integer accNumber);
    String debit(String accNumber, int amount);
    String credit(String  accNumber, int amount);

}
