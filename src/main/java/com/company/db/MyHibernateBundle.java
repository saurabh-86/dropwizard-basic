package com.company.db;

import com.company.DropwizardBasicConfiguration;
import com.google.common.collect.ImmutableList;
import com.google.inject.Singleton;
import io.dropwizard.ConfiguredBundle;
import io.dropwizard.db.DataSourceFactory;
import io.dropwizard.hibernate.HibernateBundle;
import io.dropwizard.hibernate.SessionFactoryFactory;
import org.reflections.Reflections;

import javax.persistence.Entity;

@Singleton
public class MyHibernateBundle
        extends HibernateBundle<DropwizardBasicConfiguration>
        implements ConfiguredBundle<DropwizardBasicConfiguration> {

    public MyHibernateBundle() {
        super(myDbEntities(), new SessionFactoryFactory());
    }

    private static ImmutableList<Class<?>> myDbEntities( ) {
        Reflections reflections = new Reflections("com.company.db.entities");
        ImmutableList<Class<?>> entities = ImmutableList.copyOf(reflections.getTypesAnnotatedWith(Entity.class));
        return entities;
    }

    @Override
    public DataSourceFactory getDataSourceFactory(DropwizardBasicConfiguration configuration) {
        return configuration.getDatabase();
    }
}
