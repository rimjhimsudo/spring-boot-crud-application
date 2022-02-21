package bankmanagmentsystem.daos.implementation;

import bankmanagmentsystem.daos.DebitCardDao;
import bankmanagmentsystem.models.DebitCard;
import bankmanagmentsystem.repositories.DebitRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
@Repository
public class DebitCardDaoImpl implements DebitCardDao {
    DebitRepository debitRepository;

    public DebitCardDaoImpl(DebitRepository debitRepository) {
        this.debitRepository = debitRepository;
    }

    @Override
    public DebitCard create(DebitCard debitCard) {
        DebitCard myDebitcard=debitRepository.save(debitCard);
        return myDebitcard;
    }

    @Override
    public DebitCard read(String debitNum) {
        DebitCard myDebitcard= debitRepository.findByNumber(debitNum);
        return myDebitcard;
    }

    @Override
    public List<DebitCard> readAll() {
        List<DebitCard> debitlist=new ArrayList<>();
        debitRepository.findAll().forEach(debitcards -> debitlist.add(debitcards));
        return debitlist;
    }

    @Override
    public void update(DebitCard debitCard) {
        debitRepository.save(debitCard);
    }

    @Override
    public void deleteByNumber(String debitNum) {
        debitRepository.deleteByNumber(debitNum);
    }
}
