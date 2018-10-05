package com.sample.firebase.user;

import com.sample.firebase.security.Roles;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import java.util.Date;
import java.util.List;

@Data
@Builder
@ToString
public class User {

    private String uuid;
    private String name;
    private String email;
    private Date birthDate;
    private List<Roles> roles;

}
