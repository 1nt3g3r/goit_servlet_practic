package net.proselyte.customer.controller;

import net.proselyte.customer.DaoSingleton;
import net.proselyte.customer.model.Customer;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class ListAllCustomersServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=utf8");

        //Get all customers
        List<Customer> customers = DaoSingleton.getInstance().getDao().getAll();

        //Print all customers as links
        for(Customer customer: customers) {
            String customerText = customer.getName() + ", " + customer.getAddress();
            String editLinkCustomer =
                    "<a href=\"/customer/edit?customer_id=" + customer.getId() + "\">" + customerText + "</a>";

            String deleteLinkCustomer =
                    "<a href=\"/customer/delete?customer_id=" + customer.getId() + "\">Видалити</a>";

            String finalLink = editLinkCustomer + " " + deleteLinkCustomer;


            resp.getWriter().println(finalLink);
            resp.getWriter().println("<br>");
        }
    }
}
