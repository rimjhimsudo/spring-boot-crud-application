package bankmanagmentsystem.Dao;

import bankmanagmentsystem.model.Account;
import bankmanagmentsystem.model.Customer;
import bankmanagmentsystem.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class AccountDaoImpl implements AccountDaoInterface {
    AccountRepository accountRepository;
    public AccountDaoImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public void create(Account account) {
        accountRepository.save(account);
    }

    @Override
    public Account read(String  accNumber) {
        Account account=accountRepository.findByAccNumber(accNumber);
        //cant use id
        return account;
    }

    @Override
    public List<Account> readAll() {
        List<Account> accountslist=new ArrayList<>();
        accountRepository.findAll().forEach(customer -> accountslist.add(customer));
        return accountslist;
    }

    @Override
    public void update(Account account) {
        accountRepository.save(account);
    }

    @Override
    public void deleteById(int accId) {
        accountRepository.deleteById(accId);
    }
}
