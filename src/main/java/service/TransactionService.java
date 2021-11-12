package service;

import entity.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import repository.ITransacRepository;

@Service
@Transactional
public class TransactionService implements ITransacService{

    @Autowired
    ITransacRepository transacRepository;

    public void save(Transaction transaction) {
        transacRepository.save(transaction);
    }



}
