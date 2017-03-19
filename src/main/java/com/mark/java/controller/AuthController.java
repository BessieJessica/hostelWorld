package com.mark.java.controller;

import com.mark.java.service.MembershipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * Created by lois on 2017/3/19.
 */

@Controller
public class AuthController {

    @Autowired
    private MembershipService membershipService;

}
