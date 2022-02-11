package bankmanagmentsystem.Dao;

import bankmanagmentsystem.model.Account;
import bankmanagmentsystem.model.Customer;
import bankmanagmentsystem.model.DebitCard;

import java.util.List;

public interface DebitcardDao {
    void create(DebitCard debitCard); //create
    DebitCard read(String debitNum);  //get
    List<DebitCard> readAll();
    void update(DebitCard debitCard);  //post
    void deleteByDebitNum(String debitNum);
}
