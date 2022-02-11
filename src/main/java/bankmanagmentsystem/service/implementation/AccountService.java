package bankmanagmentsystem.service.implementation;

import bankmanagmentsystem.Dao.AccountDao;
import bankmanagmentsystem.Dao.CustomerDao;
import bankmanagmentsystem.model.Account;
import bankmanagmentsystem.model.Customer;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class AccountService {
    AccountDao accountDao;
    CustomerDao customerDao;

    public AccountService(AccountDao accountDao, CustomerDao customerDao) {
        this.accountDao = accountDao;
        this.customerDao = customerDao;
    }

    //to get all accounts from db
    public List<Account> getAllAccounts(){
        List<Account> accountList=new ArrayList<>();
        for (Account account : accountDao.readAll()) {
            accountList.add(account);
        }
        return accountList;
    }
    //to get account by account number from db
    public Account getByAccNumber(String  accNumber){
        return accountDao.read(accNumber);
    }
    //to insert account into db
    public void saveAccount(Account account,Long cusId){
        Customer myCustomer = customerDao.read(cusId);
        if(myCustomer!=null){
            //create account
            accountDao.create(account,myCustomer);

        }

    }
    //to update account in db
    public void update(Account account){
        accountDao.update(account);
    }
    //to delete account by accout number from db
    public void deleteByByAccNumber(Integer accNumber){
        accountDao.deleteById(Math.toIntExact(accNumber));
    }

    // method to withdraw/deduct money from account
    public String debit(String  accNumber, int amount){
        String answer;
        Account myAccount = accountDao.read(accNumber);
        int balance=myAccount.getBalance();
        if(balance>=amount){
            balance-=amount;
            myAccount.setBalance(balance);
            answer="Your balance is : "+ balance;
        }
        else{
            answer="You dont have sufficient balance to withdraw";
        }
        return answer;
    }
    public String credit(String  accNumber, int amount){
        String answer;
        Account myAccount = accountDao.read(accNumber);
        int balance=myAccount.getBalance();
        balance+=amount;
        myAccount.setBalance(balance);
        answer="Your balance is : "+ balance;
        return answer;
    }
}