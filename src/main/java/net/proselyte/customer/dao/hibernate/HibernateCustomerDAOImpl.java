package net.proselyte.customer.dao.hibernate;

import net.proselyte.customer.dao.CustomerDAO;
import net.proselyte.customer.model.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class HibernateCustomerDAOImpl implements CustomerDAO {

    private SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

    public void save(Customer customer) {

    }

    public void update(Customer customer) {

    }

    public void delete(Customer customer) {

    }

    public List<Customer> getAll() {
        return null;
    }

    public Customer getById(Long id) {
        Session session = this.sessionFactory.openSession();

        Customer customer = session.get(Customer.class, id);
        session.close();

        return customer;
    }
}
