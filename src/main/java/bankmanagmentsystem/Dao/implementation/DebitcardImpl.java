package bankmanagmentsystem.Dao.implementation;

import bankmanagmentsystem.Dao.DebitcardDao;
import bankmanagmentsystem.model.DebitCard;
import bankmanagmentsystem.repository.DebitRepository;

import java.util.ArrayList;
import java.util.List;

public class DebitcardImpl implements DebitcardDao {
    DebitRepository debitRepository;

    public DebitcardImpl(DebitRepository debitRepository) {
        this.debitRepository = debitRepository;
    }

    @Override
    public void create(DebitCard debitCard) {
        debitRepository.save(debitCard);
    }

    @Override
    public DebitCard read(String debitNum) {
        DebitCard myDebitcard= debitRepository.findBydebitNum(debitNum);
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
    public void deleteByDebitNum(String debitNum) {
        debitRepository.deleteBydebitNum(debitNum);
    }
}
