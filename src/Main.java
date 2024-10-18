import Observable.IphoneObservableImpl;
import Observable.StockObservable;
import Observer.EmailNotificationObserver;
import Observer.MobileNotificationObserver;
import Observer.NotificationAlertObserver;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to Amazon!");

        // Initialize Scanner to take input from the terminal
        Scanner scanner = new Scanner(System.in);

        // Create StockObservable for iPhone
        StockObservable iPhoneStockObservable = new IphoneObservableImpl();

        // Input number of observers
        System.out.print("Enter the number of observers: ");
        int numObservers = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        // List to hold observers
        List<NotificationAlertObserver> observers = new ArrayList<>();

        // Loop to get the details for each observer
        for (int i = 1; i <= numObservers; i++) {
            System.out.println("Observer " + i + ":");

            // Ask the user for the type of notification observer
            System.out.print("Is this an Email or Mobile observer? (enter 'email' or 'mobile'): ");
            String observerType = scanner.nextLine().toLowerCase();

            // Get details based on the type of observer
            if (observerType.equals("email")) {
                // Input email for the email notification observer
                System.out.print("Enter the email: ");
                String email = scanner.nextLine();
                observers.add(new EmailNotificationObserver(email, iPhoneStockObservable));

            } else if (observerType.equals("mobile")) {
                // Input mobile username for the mobile notification observer
                System.out.print("Enter the mobile username: ");
                String mobileUsername = scanner.nextLine();
                observers.add(new MobileNotificationObserver(mobileUsername, iPhoneStockObservable));

            } else {
                System.out.println("Invalid observer type. Please enter 'email' or 'mobile'.");
                i--; // Decrease the counter to re-ask for valid input
            }
        }

        // Add all observers to the observable
        for (NotificationAlertObserver observer : observers) {
            iPhoneStockObservable.add(observer);
        }

        // Input stock count
        System.out.print("Add new stock count: ");
        int stockCount = scanner.nextInt();

        // Set stock count in the observable
        iPhoneStockObservable.setStockCount(stockCount);

        // Close the scanner to prevent resource leaks
        scanner.close();
    }
}