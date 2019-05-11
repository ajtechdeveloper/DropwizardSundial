package com.aj.dropwizardsundial.job;

import org.knowm.sundial.Job;
import org.knowm.sundial.annotations.SimpleTrigger;
import org.knowm.sundial.exceptions.JobInterruptException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

@SimpleTrigger(repeatInterval = 10, timeUnit = TimeUnit.SECONDS)
public class SimpleJob extends Job {

    private static final Logger logger = LoggerFactory.getLogger(SimpleJob.class);
    @Override
    public void doRun() throws JobInterruptException {
        logger.info("Hello from Simple Job");
    }
}
