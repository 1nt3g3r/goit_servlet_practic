package net.proselyte.customer.controller;

import net.proselyte.customer.DaoSingleton;
import net.proselyte.customer.model.Customer;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AddCustomerServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/jsp/add_customer.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=utf-8");

        try {
            String name = req.getParameter("name");
            String address = req.getParameter("address");

            //Create new customer from POST params
            Customer customer = new Customer();
            customer.setName(name);
            customer.setAddress(address);

            //Add customer into DB
            DaoSingleton.getInstance().getDao().save(customer);

            //Show some feedback for user
            resp.getWriter().println("Покупець успішно доданий!");
            resp.getWriter().println("<br>");
            resp.getWriter().println("<br>");

            //Show link to see all customers
            String link = "<a href=\"/customer/list\">Список всіх покупців</a>";
            resp.getWriter().println(link);
        } catch (Exception e) {
            //Show some error for user
            resp.getWriter().println("Помилка додавання покупця!");
        }
    }
}
