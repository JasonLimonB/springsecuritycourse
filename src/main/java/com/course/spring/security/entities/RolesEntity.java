package com.course.spring.security.entities;

import lombok.Data;

@Data
public class RolesEntity {

    private Long id;
    private String rol;
    private String code;

    public RolesEntity() {
    }

    public RolesEntity(Long id, String rol, String code) {
        this.id = id;
        this.rol = rol;
        this.code = code;
    }
}
