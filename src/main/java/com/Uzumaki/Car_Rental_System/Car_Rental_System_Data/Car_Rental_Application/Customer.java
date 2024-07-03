package com.Uzumaki.Car_Rental_System.Car_Rental_System_Data.Car_Rental_Application;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Customer {

    @Id
    @GeneratedValue(Strategy = GenerationType.IDENTITY)
    private int customerId;

    private String Name;

    private String email;

    private String phoneNo;

    public Customer(String name, String email, String phoneNo) {
        this.name = name;
        this.email = email;
        this.phoneNo = phoneNo;
    }
    public String getName() {
        return name;
    }
    public  String getEmail() {
        return email;
    }
    public String getPhoneNo() {
        return phoneNo;
    }
}
