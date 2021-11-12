package repository;

import entity.Transaction;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITransacRepository extends CrudRepository<Transaction, Long> {

}
