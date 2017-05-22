package com.bharat.user.dtos;

/**
 * Created by BharatBh on 2/21/2017.
 */
public class UserDto {
    String firstName;
    String lastname;
    int id;

    public UserDto(String firstName, String lastname, int id) {
        this.firstName = firstName;
        this.lastname = lastname;
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastname() {
        return lastname;
    }

    public int getId() {
        return id;
    }
}
