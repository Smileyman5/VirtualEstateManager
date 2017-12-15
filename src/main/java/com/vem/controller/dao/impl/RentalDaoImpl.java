package com.vem.controller.dao.impl;

import com.vem.controller.dao.RentalDao;
import com.vem.controller.model.Rental;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by alex on 12/14/17.
 */
@Repository
public class RentalDaoImpl implements RentalDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public RentalDaoImpl() {}

    @Override
    public void add(Rental rental) {
        // insert
        String sql = "INSERT INTO contract VALUES (?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, rental.getRentalId(), rental.getStreetNumber(), rental.getStreetName(), rental.getCity(), rental.getState());
    }

    @Override
    public void edit(Rental rental) {
    }

    @Override
    public void delete(Rental rental) {
    }

    @Override
    public Rental getRental(int rentalId) {
        return getRentals("Select * from rental where id=" + rentalId).get(0);
    }

    @Override
    public List<Rental> getAllRentals() {
        return getRentals("Select * from rental");
    }

    private List<Rental> getRentals(String sql) {
        return jdbcTemplate.query(sql, (resultSet, i) -> {
            if (resultSet.next()) {
                Rental rental = new Rental();
                rental.setRentalId(resultSet.getInt("id"));
                rental.setStreetNumber(resultSet.getInt("street_number"));
                rental.setStreetName(resultSet.getString("street_name"));
                rental.setCity(resultSet.getString("city"));
                rental.setState(resultSet.getString("state"));
                return rental;
            }
            return null;
        });
    }
}
