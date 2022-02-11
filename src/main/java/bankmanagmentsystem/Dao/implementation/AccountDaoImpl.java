package bankmanagmentsystem.Dao.implementation;

import bankmanagmentsystem.Dao.AccountDao;
import bankmanagmentsystem.model.Account;
import bankmanagmentsystem.model.Customer;
import bankmanagmentsystem.repository.AccountRepository;
import bankmanagmentsystem.repository.CustomerRepository;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class AccountDaoImpl implements AccountDao {
    AccountRepository accountRepository;
    CustomerRepository customerRepository;

    public AccountDaoImpl(AccountRepository accountRepository, CustomerRepository customerRepository) {
        this.accountRepository = accountRepository;
        this.customerRepository = customerRepository;
    }

    @Override
    public void create(Account account,Customer customer) {
        account.setCustomer(customer);
        accountRepository.save(account);
    }

    @Override
    public Account read(String  accNumber) {
        Account account=accountRepository.findByAccNumber(accNumber);
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
