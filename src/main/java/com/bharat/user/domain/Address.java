package com.bharat.user.domain;

import javax.persistence.*;

/**
 * Created by BharatBh on 4/24/2017.
 */
@Entity
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int addressId;

    @Column(name = "address")
    private String addressLine;

    private String city;

    private  String state;

    private int pincode;

    public Address() {
    }

    public Address(String addressLine, String city, String state, int pincode) {
        this.addressLine = addressLine;
        this.city = city;
        this.state = state;
        this.pincode = pincode;
    }


}
