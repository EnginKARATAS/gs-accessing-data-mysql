package com.example.accessingdatamysql.api.controllers;

import com.example.accessingdatamysql.dataAccess.abstracts.HcsrDao;
import com.example.accessingdatamysql.entity.concrate.sensor.Hcsr04;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

@Controller	// This means that this class is a Controller
@RequestMapping(path="/api/hcsr") // This means URL's start with /demo (after Application path)
@Repository
public class Hcsr04DistanceController {
    @Autowired // This means to get the bean called userRepository
    // Which is auto-generated by Spring, we will use it to handle the data
    private HcsrDao _hcrsDao;

    @PostMapping(path="/add") // Map ONLY POST Requests
    public @ResponseBody String addNewUser (@RequestParam Date date) {

        Hcsr04 hcsr04 = new Hcsr04();
        hcsr04.setTriggeredDate(date);
        _hcrsDao.save(hcsr04);
        return "Saved";
    }

    @GetMapping(path="/all")
    public @ResponseBody Iterable<Hcsr04> getAllDhtData() {
        // This returns a JSON or XML with the users
        return _hcrsDao.findAll();
    }
}
