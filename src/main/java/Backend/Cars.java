public class Cars {
//    Attributes initialization
    private String carId;

    private String model;

    private String brand;

    private double pricePerDay;

    private boolean isAvailable;

    public Cars () {

    }

    public Cars(String carId, String model, String brand, double pricePerDay) {
        this.carId = carId;
        this.model = model;
        this.brand = brand;
        this.pricePerDay = pricePerDay;
        this.isAvailable = true;
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