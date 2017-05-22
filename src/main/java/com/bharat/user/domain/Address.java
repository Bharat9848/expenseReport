package com.bharat.user.domain;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * Created by BharatBh on 4/24/2017.
 */

@Embeddable
public class Address {

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
