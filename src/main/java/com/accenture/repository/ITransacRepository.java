package com.accenture.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.accenture.entity.Transaction;

@Repository
public interface ITransacRepository extends CrudRepository<Transaction, Long> {

}
