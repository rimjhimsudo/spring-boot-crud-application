package bankmanagmentsystem.daos.implementation;

import bankmanagmentsystem.daos.DebitCardDao;
import bankmanagmentsystem.models.DebitCard;
import bankmanagmentsystem.repositories.DebitRepository;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class DebitCardImpl implements DebitCardDao {
    DebitRepository debitRepository;

    public DebitCardImpl(DebitRepository debitRepository) {
        this.debitRepository = debitRepository;
    }

    @Override
    public void create(DebitCard debitCard) {
        debitRepository.save(debitCard);
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
