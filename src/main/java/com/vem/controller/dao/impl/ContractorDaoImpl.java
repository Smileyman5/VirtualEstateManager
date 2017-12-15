package com.vem.controller.dao.impl;

import com.vem.controller.dao.ContractorDao;
import com.vem.controller.model.Contractor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by alex on 12/14/17.
 */
@Repository
public class ContractorDaoImpl implements ContractorDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public ContractorDaoImpl() {}

    @Override
    public void save(Contractor contractor) {
        // insert
        String sql = "INSERT INTO contractor VALUES (?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, contractor.getId(), contractor.getFirstName(), contractor.getMiddleName(),
                contractor.getLastName(), contractor.getType());
    }

    @Override
    public void delete(Contractor contractor) {
        String sql = "DELETE FROM contractor WHERE id=?";
        jdbcTemplate.update(sql, contractor.getId());
    }

    @Override
    public Contractor getContractor(int contractorId) {
        String sql = "Select * from contractor where id=" + contractorId;
        return getContractors(sql).get(0);
    }

    @Override
    public List<Contractor> getAllContractors() {
        String sql = "Select * from contractor";
        return getContractors(sql);
    }

    private List<Contractor> getContractors(String sql) {
        return jdbcTemplate.query(sql, (resultSet, i) -> {
            if (resultSet.next()) {
                Contractor contractor = new Contractor();
                contractor.setId(resultSet.getInt("id"));
                contractor.setFirstName(resultSet.getString("first_name"));
                contractor.setMiddleName(resultSet.getString("middle_name"));
                contractor.setLastName(resultSet.getString("last_name"));
                contractor.setType(resultSet.getString("type"));
                return contractor;
            }
            return null;
        });
    }
}
