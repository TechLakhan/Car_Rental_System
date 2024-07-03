package com.Uzumaki.Car_Rental_System.Car_Rental_System_Data.Car_Rental_Application;

import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.util.Map;

public class CarDataMigration {

    @Autowired
    private CarRentalRepository carRentalRepository;

    public void migrateData() throws IOException {
        for (Map<String, Object> jsonData: parsedData) {
            Car car = new Car(
                    (String) jsonData.get("Car_Id"),
                    (String) jsonData.get("model"),
                    (String) jsonData.get("brand"),
                    (Double) jsonData.get("pricePerDay")
            );
            carRentalRepository.save(car);
        }
    }


}
