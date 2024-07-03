package com.Uzumaki.Car_Rental_System.Car_Rental_System_Data;

import com.Uzumaki.Car_Rental_System.Car_Rental_System_Data.Car_Rental_Application.Car;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Component
public class JsonDataMigration {

    private final ObjectMapper objectMapper;

    @Autowired
    public JsonDataMigration(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    public List<Car> migrateCarData(String filePath) throws IOException {
        List<Car> cars = new ArrayList<>();
        Map<String, Object> jsonData = objectMapper.readValue(new File("src/main/resources/cars.json"), Map.class);

        List<Map<String, Object>> carEntries = (List<Map<String, Object>>) jsonData.get(cars);
        for (Map<String, Object> carData : carEntries) {
            Car car = new Car(
                    (String) carData.get("carId"),
                    (String) carData.get("model"),
                    (String) carData.get("brand"),
                    (Double) carData.get("pricePerDay")
            );
            cars.add(car);
        }
        return cars;
    }
}
