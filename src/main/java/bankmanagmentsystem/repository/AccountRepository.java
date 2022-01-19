package bankmanagmentsystem.repository;

import bankmanagmentsystem.model.Account;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountRepository  extends CrudRepository<Account,Integer> {
    public Account findByAccNumber(String accNumber);
    public Account save(Account account);
    public List<Account> findAll();
    public void deleteById(int accId);
}
