import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CarRentalSystem {

    private List<Cars> cars;

    private List<Customer> customers;

    private List<Rental> rentals;

    public CarRentalSystem() {
        cars = new ArrayList<>();
        customers = new ArrayList<>();
        rentals = new ArrayList<>();
    }

    public void addCar(Cars car) {
        cars.add(car);
    }

    public void customerInfo(Customer customer) {
        customers.add(customer);
    }

    public void rentalInfo(Cars car, Customer customer, int days) {
        if (car.isAvailable()) {
            car.rent();
            rentals.add(new Rental(car, customer, days));
        }
        else {
            System.out.println("Oops, Sorry ! This car is not available for rent");
        }
    }

    public void returnCar(Cars car) {
        car.returnCar();
        Rental rentalToRemove = null;
        for (Rental rental : rentals) {
            if (rental.getCar() == car) {
                rentalToRemove = rental;
                break;
            }
        }
        if (rentalToRemove != null) {
            rentals.remove(rentalToRemove);
            System.out.println("Car returned successfully.");
        }
        else {
            System.out.println("Car was not rented.");
        }
    }

    public void menu() {
        Scanner input = new Scanner(System.in);

        while (true) {
            System.out.println(" -----> CAR RENTAL SYSTEM <-----");
            System.out.println("1. Rent A Car ");
            System.out.println("2. Return A Car ");
            System.out.println("3. Exit*");
            System.out.println("Book your favourite Car ");

            int choice = input.nextInt();
            input.nextLine();

            String customerName = null;
            if (choice == 1) {
                System.out.println("\n---> Rent a Car <---\n");
                System.out.println("Enter your Name");
                customerName = input.nextLine();

                System.out.println("\n -> Available Cars ->");
                for (Cars car : cars) {
                    if (car.isAvailable()) {
                        System.out.println(car.getCarId() + " - " + car.getBrand() + " - " + car.getModel());
                    }
                }

                System.out.println("\n Enter the CarId you want to rent :");
                String carId = input.nextLine();

                System.out.println("Enter the number of days for Rental");
                int rentalDays = input.nextInt();
                input.nextLine();

                Customer newCustomer = new Customer("CUS" + (customers.size() + 1), customerName);
                customerInfo(newCustomer);

                Cars selectedCar = null;
                for (Cars car : cars) {
                    if (car.getCarId().equals(carId) && car.isAvailable()) {
                        selectedCar = car;
                        break;
                    }
                }

                if (selectedCar != null) {
                    double totalAmount = selectedCar.totalPrice(rentalDays);
                    System.out.println("\n ---> Rental Information <--- \n");
                    System.out.println("CustomerId : " + newCustomer.getCustomerId());
                    System.out.println("CustomerName : " + newCustomer.getCustomerName());
                    System.out.println("Selected Car : " + selectedCar.getBrand() + " " + selectedCar.getModel());
                    System.out.println("Rental Days : " + rentalDays);
                    System.out.println("Total Price : $" + totalAmount);


                    System.out.println("\n Confirm Bookings (Y/N): \n");
                    String confirm = input.nextLine();

                    if (confirm.equalsIgnoreCase("Y")) {
                        rentalInfo(selectedCar, newCustomer, rentalDays);
                        System.out.println("The car booking is successful. You will get keys in No-Time !");
                    } else {
                        System.out.println("\n Rental Cancelled ");
                    }
                } else {
                    System.out.println("\n Invalid Car Selection or Car is not available for rent");
                }
            } else if (choice == 2) {
                System.out.println("\n Return a car. \n");
                System.out.println("Enter the CarId you want return :");
                String carId = input.nextLine();

                Cars carToReturn = null;
                for (Cars car : cars) {
                    if (car.getCarId().equals(carId) && !car.isAvailable()) {
                        carToReturn = car;
                        break;
                    }
                }

                if (carToReturn != null) {
                    Customer customer = null;
                    for (Rental rental : rentals) {
                        if (rental.getCar() == carToReturn) {
                            customer = rental.getCustomer();
                            break;
                        }
                    }
                    if (customer != null) {
                        returnCar(carToReturn);
                        System.out.println("Car returned successfully by " + customer.getCustomerName() + " Thank you ! Please visit Again !");
                    } else {
                        System.out.println("Car was not rented or rental information is missing.");
                    }
                } else {
                    System.out.println("Invalid car Id or car is not rented.");
                }
            } else if (choice == 3) {
                break;
            } else {
                System.out.println("Invalid choice. Please enter a valid option.");
            }
            System.out.println("\nThank you for using the Car Rental System!\n");
        }
    }
}