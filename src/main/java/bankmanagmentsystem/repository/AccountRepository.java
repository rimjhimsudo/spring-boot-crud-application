package bankmanagmentsystem.repository;

import bankmanagmentsystem.model.Account;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountRepository  extends CrudRepository<Account,Integer> {
    //to make easier for reader to see wat all methods are being used in DAOImpl.
    public Account findByAccNumber(String accNumber);
    public Account save(Account account);
    public List<Account> findAll();
    public void deleteById(int accId);
}
