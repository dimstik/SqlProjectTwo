package org.example.dao;

import org.example.entity.Category;
import org.hibernate.SessionFactory;

public class CategoryDAO extends AbstractHibernateDao<Category> {
    public CategoryDAO(SessionFactory sessionFactory) {
        super(Category.class, sessionFactory);
    }
}
