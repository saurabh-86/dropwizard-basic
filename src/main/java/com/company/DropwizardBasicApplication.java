package com.company;

import com.hubspot.dropwizard.guice.GuiceBundle;
import io.dropwizard.Application;
import io.dropwizard.db.DataSourceFactory;
import io.dropwizard.migrations.MigrationsBundle;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class DropwizardBasicApplication extends Application<DropwizardBasicConfiguration> {

    public static void main(final String[] args) throws Exception {
        new DropwizardBasicApplication().run(args);
    }

    @Override
    public String getName() {
        return "DropwizardBasic";
    }

    @Override
    public void initialize(final Bootstrap<DropwizardBasicConfiguration> bootstrap) {

        GuiceBundle<DropwizardBasicConfiguration> guiceBundle = GuiceBundle.<DropwizardBasicConfiguration>newBuilder()
                .addModule(new DropwizardBasicModule())
                .enableAutoConfig(getClass().getPackage().getName())
                .setConfigClass(DropwizardBasicConfiguration.class)
                .build();

        bootstrap.addBundle(guiceBundle);

        bootstrap.addBundle(new MigrationsBundle<DropwizardBasicConfiguration>() {
            @Override
            public DataSourceFactory getDataSourceFactory(DropwizardBasicConfiguration configuration) {
                return configuration.getDatabase();
            }
        });
    }

    @Override
    public void run(final DropwizardBasicConfiguration configuration,
                    final Environment environment) {
        // now you don't need to add resources, tasks, healthchecks or providers
        // you must have your health checks inherit from InjectableHealthCheck in order for them to be injected

    }


}
