package bankmanagmentsystem.services;

import bankmanagmentsystem.daos.DebitCardDao;
import bankmanagmentsystem.exceptions.ResourceNotfoundException;
import bankmanagmentsystem.models.DebitCard;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class DebitCardService {
    DebitCardDao debitCardDao;

    public DebitCardService(DebitCardDao debitCardDao) {
        this.debitCardDao = debitCardDao;
    }
    //to get debit card from db
    public List<DebitCard> getAll(){
        List<DebitCard> debitCardList = new ArrayList<>();
        debitCardDao.readAll().forEach(debitCard -> debitCardList.add(debitCard));
        return debitCardList;
    }
    //to get debit card b debit card number
    public DebitCard getByNumber(String number) throws ResourceNotfoundException {
        DebitCard debitCard=debitCardDao.read(number);
        if(debitCard==null){
            throw new ResourceNotfoundException("Debit card with this number does not exist");
        }
        return debitCard;
    }

    public void save(DebitCard debitCard){
        debitCardDao.create(debitCard);
    }
    public void update(DebitCard debitCard){
        debitCardDao.update(debitCard);
    }
    public void deleteByNumber(String number){
        debitCardDao.deleteByNumber(number);
    }









}


