package com.bharat.user.dtos;

/**
 * Created by BharatBh on 2/14/2017.
 */
public class PhoneNumber {

    private final String number;

    public PhoneNumber(String number) {
        if (!isValid(number)) {
            throw new IllegalArgumentException("not a valid phone number");
        }
        this.number = number;
    }

    private boolean isValid(String number) {
        return number.matches("[0-9]{10}");
    }

    public String getNumber(){
        return number;
    }

    public static void main(String[] args){
//        new PhoneNumber("safdsa");
        new PhoneNumber("9210832122");
    }
}
