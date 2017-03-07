package com.company;

import com.hubspot.dropwizard.guice.GuiceBundle;
import io.dropwizard.Application;
import io.dropwizard.db.DataSourceFactory;
import io.dropwizard.migrations.MigrationsBundle;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import org.glassfish.jersey.message.filtering.SelectableEntityFilteringFeature;

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

        // Registering and configuring entity-filtering feature based on dynamic and configurable query parameters
        // See:
        //  - https://jersey.java.net/documentation/latest/entity-filtering.html
        //  - https://gist.github.com/oillio/1c1845059caf47527f94202bf14b2dca
        //  - https://github.com/dropwizard/dropwizard/issues/1005
        environment.jersey().property(SelectableEntityFilteringFeature.QUERY_PARAM_NAME, "select");
        environment.jersey().register(SelectableEntityFilteringFeature.class);
    }


}
