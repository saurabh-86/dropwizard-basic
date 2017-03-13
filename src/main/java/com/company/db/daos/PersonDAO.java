package com.company.db.daos;

import com.company.db.entities.Person;
import com.google.inject.Inject;
import io.dropwizard.hibernate.AbstractDAO;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

import java.util.UUID;

public class PersonDAO extends AbstractDAO<Person> {

    @Inject
    public PersonDAO(SessionFactory factory) {
        super(factory);
    }

    public Person findById(UUID id) {
        Criteria criteria = super.criteria();
        criteria.add(Restrictions.eq("id", id));
        return super.uniqueResult(criteria);
    }

    public void createOrUpdate(Person person) {
        persist(person);
    }

}