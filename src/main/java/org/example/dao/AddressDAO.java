package org.example.dao;

import org.example.entity.Address;
import org.hibernate.SessionFactory;

public class AddressDAO extends AbstractHibernateDao<Address> {
    public AddressDAO(SessionFactory sessionFactory) {
        super(Address.class, sessionFactory);
    }
}
