package bankmanagmentsystem.repository;

import bankmanagmentsystem.model.DebitCard;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface DebitRepository extends CrudRepository<DebitCard,Integer> {
    public List<DebitCard> findAll();
    public DebitCard findBydebitNum(String debitNum);
    public DebitCard save(DebitCard debitCard);
    public void deleteBydebitNum(String debitNum);
}
