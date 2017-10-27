package net.proselyte.customer.controller;

import net.proselyte.customer.DaoSingleton;
import net.proselyte.customer.model.Customer;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class EditCustomerServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=utf-8");

        String customerIdStr = req.getParameter("customer_id");
        long customerId = Long.parseLong(customerIdStr);

        String name = req.getParameter("name");
        String address = req.getParameter("address");

        Customer customer = DaoSingleton.getInstance().getDao().getById(customerId);
        customer.setName(name);
        customer.setAddress(address);

        DaoSingleton.getInstance().getDao().update(customer);

        //Show some feedback for user
        resp.getWriter().println("Покупець оновлений!");
        resp.getWriter().println("<br>");
        resp.getWriter().println("<br>");

        //Show link to see all customers
        String link = "<a href=\"/customer/list\">Список всіх покупців</a>";
        resp.getWriter().println(link);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String customerIdStr = req.getParameter("customer_id");
        long customerId = Long.parseLong(customerIdStr);

        //Get customer data
        Customer customer = DaoSingleton.getInstance().getDao().getById(customerId);
        String name = customer.getName();
        String address = customer.getAddress();

        req.setAttribute("customerId", customerId);

        //Make HTML form
        String form = "<!DOCTYPE html>\n" +
                "<html>\n" +
                "    <head>\n" +
                "        <meta charset=\"utf-8\"/>\n" +
                "        <title>Редагування покупця</title>\n" +
                "    </head>\n" +
                "\n" +
                "    <body>\n" +
                "        <h2>Редагувати покупця</h2>\n" +
                "\n" +
                "        <form action=\"edit\" method=\"POST\" accept-charset=\"utf-8\">\n" +
                "\n" +
                "            <p>Як звати</p>\n" +
                "            <input type=\"text\" name=\"name\"/ value=\"" + name + "\">\n" +
                "\n" +
                "            <p>Адреса</p>\n" +
                "            <input type=\"text\" name=\"address\" value=\"" + address +"\"/>\n" +
                "\n <input type=\"hidden\" name=\"customer_id\" value=\"" +customerIdStr + "\"" +
                "            <br>\n" +
                "            <input type=\"submit\" value=\"Редагувати покупця\"/>\n" +
                "        </form>\n" +
                "\n" +
                "    </body>\n" +
                "\n" +
                "</html>";

        resp.setContentType("text/html; charset=utf-8");
        resp.getWriter().println(form);

    }
}
