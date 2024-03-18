import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class Welcome {
    public static void main(String[] args) {
        try {
            // Initialize ObjectMapper for JSON parsing
            ObjectMapper objectMapper = new ObjectMapper();

            // Read the JSON file containing car information
            List<Cars> cars = objectMapper.readValue(new File("C:\\Users\\patil\\IdeaProjects\\Car_Rental_System\\src\\main\\resources\\Database\\Cars.json"), new TypeReference<List<Cars>>() {});

            // Create a new CarRentalSystem instance
            CarRentalSystem rentalSystem = new CarRentalSystem();

            // Add cars from the JSON file to the rental system
            for (Cars car : cars) {
                rentalSystem.addCar(car);
            }

            // Display the rental system menu
            rentalSystem.menu();

        } catch (IOException e) {
            // Handle any exceptions that occur during file reading or JSON parsing
            e.printStackTrace();
        }
    }
}
