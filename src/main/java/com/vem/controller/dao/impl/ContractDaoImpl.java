package com.vem.controller.dao.impl;

import com.vem.controller.dao.*;
import com.vem.controller.model.Contract;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by alex on 12/14/17.
 */
@Repository
public class ContractDaoImpl implements ContractDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    LandlordDao landlordDao;
    @Autowired
    ContractorDao contractorDao;
    @Autowired
    TaskDao taskDao;
    @Autowired
    RentalDao rentalDao;

    public ContractDaoImpl() {}

    @Override
    public void save(Contract contract) {
        // insert
        String sql = "INSERT INTO contract VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, contract.getStartDate(), contract.getEndDate(), contract.getCost(), contract.getContractData(),
                contract.getLandlord().getLandlordId(), contract.getContractor().getId(), contract.getTask().getTaskId(), contract.getRental().getRentalId());
    }

    @Override
    public void delete(Contract contract) {
        String sql = "DELETE FROM contract WHERE start_date=? AND landlord_id=? AND contractor_id=? AND task_id=? AND rental_id=?";
        jdbcTemplate.update(sql, contract.getStartDate(), contract.getLandlord().getLandlordId(),
                contract.getContractor().getId(), contract.getTask().getTaskId(), contract.getRental().getRentalId());
    }

    @Override
    public Contract getContract(int contractId) {
        String sql = "Select * from contract where id=" + contractId;
        return jdbcTemplate.query(sql, (resultSet) -> {
           if (resultSet.next()) {
               Contract contract = new Contract();
               contract.setStartDate(resultSet.getDate("start_date"));
               contract.setEndDate(resultSet.getDate("end_date"));
               contract.setCost(resultSet.getDouble("cost"));
               contract.setContractData(resultSet.getBlob("contract_data"));
               contract.setLandlord(landlordDao.getLandlord(resultSet.getInt("landlord_id")));
               contract.setContractor(contractorDao.getContractor(resultSet.getInt("contractor_id")));
               contract.setTask(taskDao.getTask(resultSet.getInt("task_id")));
               contract.setRental(rentalDao.getRental(resultSet.getInt("rental_id")));
               return contract;
           }
           return null;
        });
    }

    @Override
    public List<Contract> getAllContracts() {
        String sql = "Select * from contract";
        List<Contract> contracts = jdbcTemplate.query(sql, (resultSet, i) -> {
            if (resultSet.next()) {
                Contract contract = new Contract();
                contract.setStartDate(resultSet.getDate("start_date"));
                contract.setEndDate(resultSet.getDate("end_date"));
                contract.setCost(resultSet.getDouble("cost"));
                contract.setContractData(resultSet.getBlob("contract_data"));
                contract.setLandlord(landlordDao.getLandlord(resultSet.getInt("landlord_id")));
                contract.setContractor(contractorDao.getContractor(resultSet.getInt("contractor_id")));
                contract.setTask(taskDao.getTask(resultSet.getInt("task_id")));
                contract.setRental(rentalDao.getRental(resultSet.getInt("rental_id")));
                return contract;
            }
            return null;
        });
        return contracts;
    }
}
