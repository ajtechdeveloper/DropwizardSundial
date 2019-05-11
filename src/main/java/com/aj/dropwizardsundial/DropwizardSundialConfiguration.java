package com.aj.dropwizardsundial;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.dropwizard.Configuration;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.knowm.dropwizard.sundial.SundialConfiguration;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@JsonIgnoreProperties(ignoreUnknown = true)
public class DropwizardSundialConfiguration extends Configuration {

    @JsonProperty
    public String appName;

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    @Valid
    @NotNull
    public SundialConfiguration sundialConfiguration = new SundialConfiguration();

    @JsonProperty("sundial")
    public SundialConfiguration getSundialConfiguration() {
        return sundialConfiguration;
    }
}
