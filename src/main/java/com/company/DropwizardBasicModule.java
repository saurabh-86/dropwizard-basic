package com.company;

import com.company.core.services.PersonService;
import com.company.core.services.PersonServiceImpl;
import com.company.db.MyHibernateBundle;
import com.company.db.daos.PersonDAO;
import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import org.hibernate.SessionFactory;

import static com.google.common.base.Preconditions.checkNotNull;

public class DropwizardBasicModule extends AbstractModule {
    @Override
    protected void configure() {
        // put explicit bindings here using bind() methods
    }

    @Provides
    public PersonService providesPersonsService(PersonDAO personDAO) {
        return new PersonServiceImpl(personDAO);
    }

    @Provides
    public SessionFactory sessionFactory(MyHibernateBundle hibernate) {
        return checkNotNull(hibernate.getSessionFactory());
    }
}
