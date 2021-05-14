package com.course.spring.security.services;

import com.course.spring.security.entities.RolesEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RolesService {

    public List<RolesEntity> getRoles(){
        List<RolesEntity> roles = new ArrayList<>(3);
        roles.add(new RolesEntity(25784L, "ADMIN", "ADMINCODE123"));
        roles.add(new RolesEntity(34512L, "USER", "USERCODE456"));
        roles.add(new RolesEntity(43212L, "MARKETER", "MARKETER789"));
        return roles;
    }

}
