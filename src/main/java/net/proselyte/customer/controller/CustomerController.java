package net.proselyte.customer.controller;

import net.proselyte.customer.dao.CustomerDAO;
import net.proselyte.customer.dao.hibernate.HibernateCustomerDAOImpl;
import net.proselyte.customer.model.Customer;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class CustomerController extends HttpServlet {
    private CustomerDAO customerDAO = new HibernateCustomerDAOImpl();

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");

        PrintWriter writer = response.getWriter();
        Long customerId = Long.parseLong(request.getParameter("id"));

        Customer customer = getById(customerId);

        writer.println("<html>" +
                "<head>" +
                "</head>" +
                "<body>" +
                "<h1>Customer:</h1>" +
                "<br/>" +
                "ID:" + customer.getId() +
                "<br/>" +
                "Name:" + customer.getName() +
                "<br/>" +
                "Address:" + customer.getAddress() +
                "</body>" +
                "</html>");
    }

    public Customer getById(Long id) {
        return this.customerDAO.getById(id);
    }
}
