package net.proselyte.customer.dao.hibernate;

import net.proselyte.customer.dao.CustomerDAO;
import net.proselyte.customer.model.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class HibernateCustomerDAOImpl implements CustomerDAO {

    private SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

    public void save(Customer customer) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(customer);
        transaction.commit();
        session.close();
    }

    public void update(Customer customer) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.update(customer);
        transaction.commit();
        session.close();
    }

    public void delete(Customer customer) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(customer);
        transaction.commit();
        session.close();
    }

    public List<Customer> getAll() {
        Session session = sessionFactory.openSession();
        List<Customer> result = session.createQuery("from Customer").list();
        session.close();
        return result;
    }

    public Customer getById(Long id) {
        Session session = this.sessionFactory.openSession();

        Customer customer = session.get(Customer.class, id);
        session.close();

        return customer;
    }
}
