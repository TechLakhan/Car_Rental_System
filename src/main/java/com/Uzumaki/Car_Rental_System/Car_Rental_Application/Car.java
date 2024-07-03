package com.Uzumaki.Car_Rental_System.Car_Rental_Application;

import jakarta.persistence.Entity;

@Entity
public class Car {

    private String carId;

    private String model;

    private String brand;

    private double pricePerDay;

    private boolean isAvailable;

    public Car() {

    }

    public Car(String carId, String model, String brand, double pricePerDay) {
        this.carId = carId;
        this.model = model;
        this.brand = brand;
        this.pricePerDay = pricePerDay;
    }

    public String getCarId() {
        return carId;
    }

    public String getModel() {
        return model;
    }

    public String getBrand() {
        return brand;
    }

    public double getPricePerDay() {
        return pricePerDay;
    }

    public double totalPrice(double rentedDays) {
        return pricePerDay * rentedDays;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void rent() {
        isAvailable = false;
    }

    public void returnCar() {
        isAvailable = true;
    }
}
