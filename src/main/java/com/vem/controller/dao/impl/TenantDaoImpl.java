package com.vem.controller.dao.impl;

import com.vem.controller.dao.TenantDao;
import com.vem.controller.model.Tenant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by alex on 12/14/17.
 */
@Repository
public class TenantDaoImpl implements TenantDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public TenantDaoImpl() {}

    @Override
    public void saveOrUpdate(Tenant tenant) {
        if (tenant.getTenantId() < 0) {
            // insert
            String sql = "INSERT INTO tenant VALUES (?, ?, ?, ?, ?)";
            jdbcTemplate.update(sql, tenant.getTenantId(), tenant.getFirstName(), tenant.getMiddleName(),
                    tenant.getLastName(), tenant.getJob());
        } else {
            String sql = "UPDATE tenant SET id=?, first_name=?, middle_name=?, last_name=?, job=?";
            jdbcTemplate.update(sql, tenant.getTenantId(), tenant.getFirstName(), tenant.getMiddleName(),
                    tenant.getLastName(), tenant.getJob());
        }
    }

    @Override
    public void delete(Tenant tenant) {
        String sql = "DELETE FROM tenant WHERE id=?";
        jdbcTemplate.update(sql, tenant.getTenantId());
    }

    @Override
    public Tenant getTenant(int tenantId) {
        return getTenants("SELECT * FROM tenant WHERE id=" + tenantId).get(0);
    }

    @Override
    public List<Tenant> getAllTenants() {
        return getTenants("SELECT * FROM tenant");
    }

    private List<Tenant> getTenants(String sql) {
        return jdbcTemplate.query(sql, (resultSet, i) -> {
            if (resultSet.next()) {
                Tenant tenant = new Tenant();
                tenant.setTenantId(resultSet.getInt("id"));
                tenant.setFirstName(resultSet.getString("first_name"));
                tenant.setMiddleName(resultSet.getString("middle_name"));
                tenant.setLastName(resultSet.getString("last_name"));
                tenant.setJob(resultSet.getString("job"));
                return tenant;
            }
            return null;
        });
    }
}
