package com.vem.controller.dao;

import com.vem.controller.model.Task;
import com.vem.controller.model.Tenant;

import java.util.List;

/**
 * Created by alex on 12/14/17.
 */
public interface TenantDao {
    public void add(Tenant tenant);
    public void edit(Tenant tenant);
    public void delete(Tenant tenant);
    public Tenant getTenant(int tenantId);
    public List<Tenant> getAllTenants();
}
