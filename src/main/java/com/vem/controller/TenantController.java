package com.vem.controller;

import com.vem.controller.dao.TenantDao;
import com.vem.welcome.WelcomeController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by alex on 12/13/2017.
 */
@Controller
public class TenantController {
    @Autowired
    private TenantDao tenantDao;

    @RequestMapping(value = "/list-tenants", method = RequestMethod.GET)
    public ModelAndView getCurrentTenants(ModelAndView mv) {
        mv.addObject("currentTenants", tenantDao.getAllTenants());
        mv.addObject("name", WelcomeController.getLoggedInUserName());
        mv.setViewName("tenants");

        return mv;
    }
}
