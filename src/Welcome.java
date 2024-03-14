public class Welcome {
    public static void main(String[] args) {
        CarRentalSystem rentalSystem = new CarRentalSystem();

        Cars car1 = new Cars("C001","Dzire", "MarutiSuzuki", 30.0);
        Cars car2 = new Cars("C002", "Nexon", "Tata", 55.0);
        Cars car3 = new Cars("C003", "Thar", "Mahindra", 95.6);

        rentalSystem.addCar(car1);
        rentalSystem.addCar(car2);
        rentalSystem.addCar(car3);

        rentalSystem.menu();
    }
}
