package com.admin.controllers;


import com.admin.Repository.ActivityRepository;
import com.admin.models.Activity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;

@RestController
public class ActivityController {


    @Autowired
    ActivityRepository activityRepository;

    @RequestMapping(value="/desactiverCompte", method = RequestMethod.POST)
    public Activity desac(@RequestBody ArrayList<Long> l) {
        Activity activity = new Activity(8,new Date(),l.get(0),l.get(1));
        return activityRepository.save(activity);
    }

    @RequestMapping(value="/supprimerClient", method = RequestMethod.POST)
    public Activity supprimer(@RequestBody ArrayList<Long> l) {
        Activity activity = new Activity(7,new Date(),l.get(0),l.get(1));
        return activityRepository.save(activity);
    }


}
