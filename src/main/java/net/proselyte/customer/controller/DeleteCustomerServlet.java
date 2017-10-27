package net.proselyte.customer.controller;

import net.proselyte.customer.DaoSingleton;
import net.proselyte.customer.model.Customer;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DeleteCustomerServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=utf-8");

        String customerIdStr = req.getParameter("customer_id");
        long customerId = Long.parseLong(customerIdStr);

        //Delete customer with given id
        Customer customer = DaoSingleton.getInstance().getDao().getById(customerId);
        DaoSingleton.getInstance().getDao().delete(customer);

        //Show some feedback for user
        resp.getWriter().println("Покупець успішно видалений!");
        resp.getWriter().println("<br>");
        resp.getWriter().println("<br>");

        //Show link to see all customers
        String link = "<a href=\"/customer/list\">Список всіх покупців</a>";
        resp.getWriter().println(link);
    }
}
