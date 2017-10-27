package net.proselyte.customer;

import net.proselyte.customer.dao.CustomerDAO;
import net.proselyte.customer.dao.hibernate.HibernateCustomerDAOImpl;

public class DaoSingleton {
    private CustomerDAO dao;

    private static final DaoSingleton INSTANCE = new DaoSingleton();

    private DaoSingleton() {
        dao = new HibernateCustomerDAOImpl();
    }

    public static DaoSingleton getInstance() {
        return INSTANCE;
    }

    public CustomerDAO getDao() {
        return dao;
    }
}
