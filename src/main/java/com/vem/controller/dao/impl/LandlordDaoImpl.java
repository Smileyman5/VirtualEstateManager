package com.vem.controller.dao.impl;

import com.vem.controller.dao.LandlordDao;
import com.vem.controller.model.Landlord;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by alex on 12/14/17.
 */
@Repository
public class LandlordDaoImpl implements LandlordDao {

    @Autowired
    private SessionFactory session;

    @Override
    public void add(Landlord landlord) {
        session.getCurrentSession().save(landlord);
    }

    @Override
    public void edit(Landlord landlord) {
        session.getCurrentSession().update(landlord);
    }

    @Override
    public void delete(Landlord landlord) {
        session.getCurrentSession().delete(landlord);
    }

    @Override
    public Landlord getLandlord(int landlordId) {
        return session.getCurrentSession().get(Landlord.class, landlordId);
    }

    @Override
    public List getAllLandlords() {
        return session.getCurrentSession().createQuery("from Landlord").list();
    }
}
