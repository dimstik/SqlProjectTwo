package org.example.dao;

import org.example.entity.Country;
import org.hibernate.SessionFactory;

public class CountryDAO extends AbstractHibernateDao<Country> {
    public CountryDAO(SessionFactory sessionFactory) {
        super(Country.class, sessionFactory);
    }
}
