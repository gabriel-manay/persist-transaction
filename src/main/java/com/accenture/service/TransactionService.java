package com.accenture.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.accenture.entity.Transaction;
import com.accenture.repository.ITransacRepository;

@Service
@Transactional
public class TransactionService implements ITransactionService{

    @Autowired
    ITransacRepository transacRepository;

    public void save(Transaction transaction) {
        transacRepository.save(transaction);
    }



}
