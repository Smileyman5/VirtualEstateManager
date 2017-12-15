package com.vem.controller.dao;

import com.vem.controller.model.Tenant;

import java.util.List;

/**
 * Created by alex on 12/14/17.
 */
public interface TenantDao {
    void saveOrUpdate(Tenant tenant);
    void delete(Tenant tenant);
    Tenant getTenant(int tenantId);
    List<Tenant> getAllTenants();
}
