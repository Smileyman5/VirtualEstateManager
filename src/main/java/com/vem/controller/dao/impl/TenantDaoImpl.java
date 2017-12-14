package com.vem.controller.dao.impl;

import com.vem.controller.dao.TenantDao;
import com.vem.controller.model.Tenant;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by alex on 12/14/17.
 */
@Repository
public class TenantDaoImpl implements TenantDao {
    @Override
    public void add(Tenant tenant) {

    }

    @Override
    public void edit(Tenant tenant) {

    }

    @Override
    public void delete(Tenant tenant) {

    }

    @Override
    public Tenant getTenant(int tenantId) {
        return null;
    }

    @Override
    public List<Tenant> getAllTenants() {
        return null;
    }
}
