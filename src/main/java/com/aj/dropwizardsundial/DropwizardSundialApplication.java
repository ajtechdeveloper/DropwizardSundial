package com.aj.dropwizardsundial;

import com.aj.dropwizardsundial.resource.DropwizardSundialHealthCheckResource;
import com.aj.dropwizardsundial.resource.PingResource;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import org.knowm.dropwizard.sundial.SundialBundle;
import org.knowm.dropwizard.sundial.SundialConfiguration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class DropwizardSundialApplication extends Application<DropwizardSundialConfiguration> {

    private static final Logger logger = LoggerFactory.getLogger(DropwizardSundialApplication.class);

	public static void main(String[] args) throws Exception {
		new DropwizardSundialApplication().run("server", args[0]);
	}

    @Override
    public void initialize(Bootstrap<DropwizardSundialConfiguration> b) {
		b.addBundle(new SundialBundle<DropwizardSundialConfiguration>() {

			@Override
			public SundialConfiguration getSundialConfiguration(DropwizardSundialConfiguration configuration) {
				return configuration.getSundialConfiguration();
			}
		});
	}

	@Override
	public void run(DropwizardSundialConfiguration config, Environment env)
			throws Exception {
        logger.info("Registering RESTful API resources");
		env.jersey().register(new PingResource());
		env.healthChecks().register("DropwizardSundialHealthCheck",
				new DropwizardSundialHealthCheckResource(config));
	}
}
