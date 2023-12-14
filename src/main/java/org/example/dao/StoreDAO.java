package org.example.dao;

import org.example.entity.Store;
import org.hibernate.SessionFactory;

public class StoreDAO extends AbstractHibernateDao<Store> {
    public StoreDAO(SessionFactory sessionFactory) {
        super(Store.class, sessionFactory);
    }
}
