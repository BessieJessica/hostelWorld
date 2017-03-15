package com.mark.java.controller;

import com.mark.java.service.ChargeService;
import com.mark.java.service.MembershipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by lois on 2017/3/15.
 */

@Controller
public class MembershipController {

    @Autowired
    private MembershipService membershipService;
    @Autowired
    private ChargeService chargeService;

    @RequestMapping(value = "/fillInfo", method = RequestMethod.GET)
    public String fillInfoPage(){
        return "membership/fillInfo";
    }


}
