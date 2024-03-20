//import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

//@JsonIgnoreProperties(ignoreUnknown = true)
public class Cars {
//    Attributes initialization
    private String carId;

    private String model;

    private String brand;

    private double pricePerDay;

    private boolean isAvailable = true;

    public Cars () {

    }

    public Cars(String carId, String model, String brand, double pricePerDay) {
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

    public double totalPrice(double rentalDays) {
        return pricePerDay * rentalDays;
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