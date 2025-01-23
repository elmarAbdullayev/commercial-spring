package com.commercial.restcontroller;

import com.commercial.jwt.Jwtutil;
import com.commercial.security.SecurityDat;
import com.commercial.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.RequestEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("bestellungen")
public class UsersRestController {


     @Autowired
     private SecurityDat autenticationManager;

    @Autowired
    private Jwtutil jwtutil;

    private final UserService userService;

    public UsersRestController(UserService bestellungService) {
        this.userService = bestellungService;
    }


    @GetMapping
    public RequestEntity<String> getMethode(){
        return null;
    }

    @PostMapping
    public RequestEntity<String> postMethode(){
        return null;
    }



    @PutMapping
    public RequestEntity<String> putMethode(){
        return null;
    }

    @DeleteMapping
    public RequestEntity<String> deleteMethode(){
        return null;
    }



}
