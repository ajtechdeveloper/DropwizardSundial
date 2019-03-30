package com.aj.dropwizardsundial.resource;

import com.aj.dropwizardsundial.DropwizardSundialConfiguration;
import com.codahale.metrics.health.HealthCheck;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DropwizardSundialHealthCheckResource extends HealthCheck {

    private static final Logger logger = LoggerFactory.getLogger(DropwizardSundialHealthCheckResource.class);

    private static String appName;

    public DropwizardSundialHealthCheckResource(DropwizardSundialConfiguration dropwizardSundialConfiguration){
       this.appName = dropwizardSundialConfiguration.getAppName();
    }

    @Override
    protected Result check() throws Exception {
        logger.info("App Name is: {}", appName);
        if("DropwizardSundial".equalsIgnoreCase(appName)) {
            return Result.healthy();
        }
        return Result.unhealthy("Dropwizard Sundial Service is down");
    }
}