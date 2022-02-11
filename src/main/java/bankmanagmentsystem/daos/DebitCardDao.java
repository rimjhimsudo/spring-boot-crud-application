package bankmanagmentsystem.daos;

import bankmanagmentsystem.models.DebitCard;

import java.util.List;

public interface DebitCardDao {
    void create(DebitCard debitCard); //create
    DebitCard read(String debitNum);  //get
    List<DebitCard> readAll();
    void update(DebitCard debitCard);  //post
    void deleteByNumber(String debitNum);
}
