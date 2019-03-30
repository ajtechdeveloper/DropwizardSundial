package com.aj.dropwizardsundial.job;

import org.knowm.sundial.annotations.CronTrigger;
import org.knowm.sundial.exceptions.JobInterruptException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@CronTrigger(cron = "0 19 13 * * ?")
public class CronJob extends org.knowm.sundial.Job {

    private static final Logger logger = LoggerFactory.getLogger(CronJob.class);
    @Override
    public void doRun() throws JobInterruptException {
        logger.info("Hello from Cron Job");
    }
}
