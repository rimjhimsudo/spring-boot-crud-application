package bankmanagmentsystem.repositories;

import bankmanagmentsystem.models.DebitCard;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface DebitRepository extends CrudRepository<DebitCard,Integer> {
    public List<DebitCard> findAll();
    public DebitCard findByNumber(String debitNum);
    public DebitCard save(DebitCard debitCard);
    public void deleteByNumber(String debitNum);
}
