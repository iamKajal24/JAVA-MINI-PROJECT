package Car_Rental;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Car {
	private String CarId;
	private String Brand;
	private String Model;
	private double BasePricePerDay;
	private boolean isAvailable;

	public Car(String CarId, String Brand, String Model, double BasePricePerDay) {
		this.CarId = CarId;
		this.Brand = Brand;
		this.Model = Model;
		this.BasePricePerDay = BasePricePerDay;
		this.isAvailable = true;
	}

	public String getCarId() {
		return CarId;
	}

	public String getBrand() {
		return Brand;
	}

	public String getModel() {
		return Model;
	}

	public double CalculatePrice(int rentalDays) {
		return BasePricePerDay * rentalDays;
	}

	public void rent() {
		isAvailable = false;
	}

	public void ReturnCar() {
		isAvailable = true;
	}

	public boolean isAvailable() {
		return isAvailable;
	}
}

class Customer {
	private String CustomerId;
	private String Name;

	public Customer(String CustomerId, String Name) {
		this.CustomerId = CustomerId;
		this.Name = Name;
	}

	public String getCustomerId() {
		return CustomerId;
	}

	public String getName() {
		return Name;
	}
}

class Rental {
	private Car car;
	private Customer customer;
	private int days;

	public Rental(Car car, Customer customer, int days) {
		this.car = car;
		this.customer = customer;
		this.days = days;
	}

	public Car getCar() {
		return car;
	}

	public Customer getCustomer() {
		return customer;
	}

	public int getDays() {
		return days;
	}
}

public class CarRentalSystem {

	private List<Car> cars;
	private List<Customer> customers;
	private List<Rental> rentals;
	private String anotherString;

	public CarRentalSystem() {
		cars = new ArrayList<>();
		customers = new ArrayList<>();
		rentals = new ArrayList<>();
	}

	public void addCar(Car car) {
		cars.add(car);
	}

	public void addCustomer(Customer customer) {
		customers.add(customer);
	}

	public void rentCar(Car car, Customer customer, int days) {
		if (car.isAvailable()) {
			car.rent();
			rentals.add(new Rental(car, customer, days));
		} else {
			System.out.println("Car is not available for rent ");
		}
	}

	public void returnCar(Car car) {
		car.ReturnCar();
		Rental rentalToRemove = null;
		for (Rental rental : rentals) {
			if (rental.getCar() == car) {
				rentalToRemove = rental;
				break;
			}
		}

		if (rentalToRemove != null) {
			rentals.remove(rentalToRemove);
			System.out.println("Car returned successfully");
		} else {
			System.out.println("Car was not Returned or rental information");
		}
	}

	public void menu() {
		Scanner scanner = new Scanner(System.in);
		while (true) {
			System.out.println("==== Car Rental System ====");
			System.out.println("1. Rent a Car");
			System.out.println("2. Return a Car");
			System.out.println("3. EXIT");
			System.out.println("Enter your Choice : ");

			int choice = scanner.nextInt();
			scanner.nextLine(); // consume new Line

			if (choice == 1) {
				System.out.println("\n==Rent a Car==\n");
				System.out.println("Enter your name : ");
				String customerName = scanner.nextLine();

				System.out.println("\nAvailable Cars :");
				for (Car car : cars) {
					if (car.isAvailable()) {
						System.out.println(car.getCarId() + "-" + car.getBrand() + "-" + car.getModel());
					}
				}

				System.out.println("Enter the car Id you want to rent : ");
				String carId = scanner.nextLine();

				System.out.println("Enter the number of days for rental : ");
				int rentalDays = scanner.nextInt();
				scanner.nextLine();

				Customer newCustomer = new Customer("CUS" + (customers.size() + 1), customerName);
				addCustomer(newCustomer);

				Car selectedCar = null;
				for (Car car : cars) {
					if (car.getCarId().equals(carId) && car.isAvailable()) {
						selectedCar = car;
						break;
					}
				}

				if (selectedCar != null) {
					double totalPrice = selectedCar.CalculatePrice(rentalDays);
					System.out.println("\n==Rental Information==\n");
					System.out.println("Customer Id : " + newCustomer.getCustomerId());
					System.out.println("Customer Name : " + newCustomer.getName());
					System.out.println("Car : " + selectedCar.getBrand() + " " + selectedCar.getModel());
					System.out.println("Rental Days : " + rentalDays);
					System.out.printf("Total Price : $%.2f%n", totalPrice);

					System.out.print("\nConfirm rental (Y/N) : ");
					String confirm = scanner.nextLine();

					if (confirm.equalsIgnoreCase("Y")) {
						rentCar(selectedCar, newCustomer, rentalDays);
						System.out.println("\n Car rented successfully.");
					} else {
						System.out.println("\nRental Canceled.");
					}
				} else {
					System.out.println("\n Invalid Car selection or car not available for rent :");
				}
			} else if (choice == 2) {
				System.out.println("\n==Return a Car==\n");
				System.out.println("Enter the car Id you want to return : ");
				String carId = scanner.nextLine();

				Car carToReturn = null;
				for (Car car : cars) {
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
						System.out.println("Car Returned Successfully by " + customer.getName());
					} else {
						System.out.println("Car was not rented or rental information is missing.");
					}
				} else {
					System.out.println("Invalid Car ID car is not rented");
				}
			} else if (choice == 3) {
				break;
			} else {
				System.out.println("Invalid choice. Please enter a valid option");
			}
		}
		System.out.println("\nThank you for Using the Car Rental System!");
	}

	public static void main(String[] args) {
		CarRentalSystem carRentalSystem = new CarRentalSystem();
		carRentalSystem.menu();

		Car car1 = new Car("C001", "Toyota", "Camry", 60.0);
		Car car2 = new Car("C002", "Honda", "Accord", 70.0);
		Car car3 = new Car("C003", "Mahindra", "Thar", 150.0);

		carRentalSystem.addCar(car1);
		carRentalSystem.addCar(car2);
		carRentalSystem.addCar(car3);

	}
}
