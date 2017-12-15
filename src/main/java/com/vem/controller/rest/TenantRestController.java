package com.vem.controller.rest;

import com.vem.controller.dao.TenantDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by alex on 12/15/17.
 */
@RestController
public class TenantRestController {
    @Autowired
    TenantDao tenantDao;


}
