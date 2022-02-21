package bankmanagmentsystem.services;

import bankmanagmentsystem.exceptions.ResourceNotfoundException;
import bankmanagmentsystem.models.DebitCard;

import java.util.List;

public interface DebitCardService {
    List<DebitCard> getAll();
    DebitCard getByNumber(String number) throws ResourceNotfoundException;
    DebitCard save(DebitCard debitCard);
    void update(DebitCard debitCard);
    void deleteByNumber(String number);
}
