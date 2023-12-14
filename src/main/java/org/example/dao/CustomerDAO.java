package org.example.dao;

import org.example.entity.Customer;
import org.hibernate.SessionFactory;

public class CustomerDAO extends AbstractHibernateDao<Customer> {
    public CustomerDAO(SessionFactory sessionFactory) {
        super(Customer.class, sessionFactory);
    }
}
