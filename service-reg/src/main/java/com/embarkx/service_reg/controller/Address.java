package com.embarkx.service_reg.controller;

public class Address {

    public  String Address1;
    public   String Address2;
    public  Long pincode;

    public Address(String address1 , String address2 , Long pincode_) {
        Address1 = address1;
        Address2 = address2;
        pincode = pincode_;
    }

    public String getAddress1() {
        return Address1;
    }

    public String getAddress2() {
        return Address2;
    }

    public Long getPincode() {
        return pincode;
    }

    public void setAddress1(String address1) {
        Address1 = address1;
    }

    public void setAddress2(String address2) {
        Address2 = address2;
    }

    public void setPincode(Long pincode) {
        this.pincode = pincode;
    }
}
