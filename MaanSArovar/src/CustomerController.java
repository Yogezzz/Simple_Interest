import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import package1.Customer;

import java.io.IOException;

public class CustomerController extends HttpServlet {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Retrieve customer details from the JSP form
        String customerName = request.getParameter("customerName");
        int age = Integer.parseInt(request.getParameter("age"));
        double principleAmount = Double.parseDouble(request.getParameter("principleAmount"));
        int years = Integer.parseInt(request.getParameter("years"));
        double rate = Double.parseDouble(request.getParameter("rate"));

        // Create a new Customer object
        Customer customer = new Customer();
        customer.setCustomerName(customerName);
        customer.setAge(age);
        customer.setPrincipleAmount(principleAmount);
        customer.setYears(years);
        customer.setRate(rate);

        // Insert customer details and calculate simple interest
        CustomerDAO customerDAO = new CustomerDAO();
        customerDAO.insertCustomer(customer);

        // Set customer object as an attribute in the request
        request.setAttribute("customer", customer);

        // Forward the request to the JSP for displaying the result
        request.getRequestDispatcher("result.jsp").forward(request, response);     
    }
}
