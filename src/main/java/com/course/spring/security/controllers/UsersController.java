package com.course.spring.security.controllers;

import com.course.spring.security.entities.RolesEntity;
import com.course.spring.security.services.RolesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.management.relation.Role;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UsersController {

    @Autowired
    private RolesService rolesService;

    @GetMapping
    public ResponseEntity<List<RolesEntity>> getRoles(){
        return new ResponseEntity<List<RolesEntity>>( rolesService.getRoles(), HttpStatus.OK );
    }

}
