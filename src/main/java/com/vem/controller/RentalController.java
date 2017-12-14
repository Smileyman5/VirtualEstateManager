package com.vem.controller;

import com.vem.controller.service.RentalService;
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
public class RentalController {

    @Autowired
    private RentalService rentalService;

    @RequestMapping(value = "/list-rentals", method = RequestMethod.GET)
    public ModelAndView getCurrentRentals(ModelAndView mv) {
        mv.addObject("currentRentals", rentalService.getCurrentRentals());
        mv.addObject("name", WelcomeController.getLoggedInUserName());
        mv.setViewName("rentals");

        return mv;
    }

}
