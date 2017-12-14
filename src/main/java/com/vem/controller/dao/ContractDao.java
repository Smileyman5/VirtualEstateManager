package com.vem.controller.dao;

import com.vem.controller.model.Contract;

import java.util.List;

/**
 * Created by alex on 12/14/17.
 */
public interface ContractDao {
    public void add(Contract contract);
    public void edit(Contract contract);
    public void delete(Contract contract);
    public Contract getContract(int contractId);
    public List<Contract> getAllContracts();
}
