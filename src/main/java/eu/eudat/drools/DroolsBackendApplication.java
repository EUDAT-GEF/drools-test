package eu.eudat.drools;


import eu.eudat.drools.health.AppHealthCheck;
import eu.eudat.drools.resources.DroolsBackendResource;
import io.dropwizard.Application;
import io.dropwizard.configuration.EnvironmentVariableSubstitutor;
import io.dropwizard.configuration.SubstitutingSourceProvider;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class DroolsBackendApplication extends Application<DroolsBackendConfiguration> {

    public static void main(String[] args) throws Exception {
        new DroolsBackendApplication().run(args);
    }

    @Override
    public void run(DroolsBackendConfiguration config, Environment env) {


        final DroolsBackendResource bookService = new DroolsBackendResource();
        env.jersey().register(bookService);
        env.healthChecks().register("drools", new AppHealthCheck());


    }

    @Override
    public void initialize(Bootstrap<DroolsBackendConfiguration> bootstrap) {
        bootstrap.setConfigurationSourceProvider(new SubstitutingSourceProvider(
                bootstrap.getConfigurationSourceProvider(), new EnvironmentVariableSubstitutor(false)));
    }
}