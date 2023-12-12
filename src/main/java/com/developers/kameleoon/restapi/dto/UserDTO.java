package com.developers.kameleoon.restapi.dto;

import lombok.Data;

import java.util.Date;

@Data
public class UserDTO {
    private String name;
    private String email;
    private String password;
    private Date creationDate;
}
