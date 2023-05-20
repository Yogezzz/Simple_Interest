
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import package1.Customer;

public class CustomerDAO {
    private Connection connection;

    public CustomerDAO() {
        // Establish the database connection
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            
            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "yoges", "yoges");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void insertCustomer(Customer customer) {
        try {
            // Validate customer details
            if (!validateCustomerDetails(customer)) {           
                return; // Exit if validation fails
            }

            // Insert customer details into the database
            String query = "INSERT INTO TESTING_NEW (CUSTOMER_NAME, AGE, PRINCIPLE_AMOUNT, YEARS, RATE) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, customer.getCustomerName());
            statement.setInt(2, customer.getAge());
            statement.setDouble(3, customer.getPrincipleAmount());
            statement.setInt(4, customer.getYears());
            statement.setDouble(5, customer.getRate());

            statement.executeUpdate();
            statement.close();

            // Calculate Simple Interest and set it in the customer object
            double simpleInterest = (customer.getPrincipleAmount() * customer.getYears() * customer.getRate()) / 100;
            customer.setSimpleInterest(simpleInterest);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private boolean validateCustomerDetails(Customer customer) {
        // Validate customer name
        if (!customer.getCustomerName().matches("[a-zA-Z ]+")) {
            System.out.println("Invalid customer name. Please enter only alphabets and spaces.");
            return false;
        }

        // Validate age
        if (customer.getAge() <= 0) {
            System.out.println("Invalid age. Please enter a valid number.");
            return false;
        }

        // Validate principle amount
        if (customer.getPrincipleAmount() <= 0 || customer.getPrincipleAmount() > 100000) {
            System.out.println("Invalid principle amount. Please enter a number between 1 and 100,000.");
            return false;
        }

        // Validate years
        if (customer.getYears() <= 0) {
            System.out.println("Invalid years. Please enter a valid number.");
            return false;
        }

        // Validate rate
        if (customer.getRate() <= 0 || customer.getRate() > 10) {
            System.out.println("Invalid rate. Please enter a number between 1 and 10.");
            return false;
        }

        return true; // Validation successful
    }
}
