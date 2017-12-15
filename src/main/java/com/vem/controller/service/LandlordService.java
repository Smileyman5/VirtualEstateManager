package com.vem.controller.service;

import com.vem.controller.dao.LandlordDao;
import com.vem.controller.model.Landlord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Created by alex on 12/15/17.
 */
@Service
public class LandlordService {

    @Autowired
    private LandlordDao landlordDao;

    public Optional getLandlordByUsername(String username) {
        return landlordDao.getAllLandlords().stream()
                .filter(landlord -> ((Landlord) landlord).getUsername().equals(username)).findFirst();
    }

}
