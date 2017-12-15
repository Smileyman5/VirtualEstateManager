package com.vem.controller.dao.impl;

import com.vem.controller.dao.LandlordDao;
import com.vem.controller.model.Landlord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by alex on 12/14/17.
 */
@Repository
public class LandlordDaoImpl implements LandlordDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public LandlordDaoImpl() {}

    @Override
    public void add(Landlord landlord) {
        // insert
        String sql = "INSERT INTO contract VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, landlord.getLandlordId(), landlord.getFirstName(), landlord.getMiddleName(), landlord.getLastName(),
                landlord.getSecretPassword(), landlord.getUsername(), landlord.getRole(), landlord.getEnabled());
    }

    @Override
    public void edit(Landlord landlord) {

    }

    @Override
    public void delete(Landlord landlord) {

    }

    @Override
    public Landlord getLandlord(int landlordId) {
        return null;
    }

    @Override
    public List getAllLandlords() {
        return null;
    }
}
