package bankmanagmentsystem.repositories;

import bankmanagmentsystem.models.Account;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

//@Repository
public interface AccountRepository  extends CrudRepository<Account,Integer> {
    //to make easier for reader to see what all methods are being used in DAOImpl.

    public Account findByNumber(String accNumber); //this query is made up of find+by+attribute name
    public Account save(Account account);
    public List<Account> findAll();
    public void deleteById(int accId);
}
