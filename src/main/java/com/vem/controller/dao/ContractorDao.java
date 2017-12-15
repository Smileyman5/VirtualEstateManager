package com.vem.controller.dao;

import com.vem.controller.model.Contract;
import com.vem.controller.model.Contractor;

import java.util.List;

/**
 * Created by alex on 12/14/17.
 */
public interface ContractorDao {
    public void save(Contractor contractor);
    public void delete(Contractor contractor);
    public Contractor getContractor(int contractorId);
    public List<Contractor> getAllContractors();
}
