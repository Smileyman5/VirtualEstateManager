package com.vem.controller;

import com.vem.controller.dao.ContractDao;
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
public class ContractController {

    @Autowired
    private ContractDao contractDao;

    @RequestMapping(value = "/list-contracts", method = RequestMethod.GET)
    public ModelAndView getActiveContracts(ModelAndView mv) {
        mv.addObject("activeContracts", contractDao.getAllContracts());
        mv.addObject("name", WelcomeController.getLoggedInUserName());
        mv.setViewName("contracts");

        return mv;
    }

}
