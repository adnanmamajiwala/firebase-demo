package com.sample.firebase.user;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import java.util.Date;

@Data
@Builder
@ToString
public class User {

    private String name;
    private Date birthDate;
}
