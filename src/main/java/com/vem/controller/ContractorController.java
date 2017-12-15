package com.vem.controller;

import com.vem.controller.dao.ContractorDao;
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
public class ContractorController {

    @Autowired
    private ContractorDao contractorDao;

    @RequestMapping(value = "/list-contractors", method = RequestMethod.GET)
    public ModelAndView getAvailableContractors(ModelAndView mv) {
        mv.addObject("availableContractors", contractorDao.getAllContractors());
        mv.addObject("name", WelcomeController.getLoggedInUserName());
        mv.setViewName("contractors");

        return mv;
    }

}
