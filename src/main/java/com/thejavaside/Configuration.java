package com.thejavaside;

import org.apache.commons.configuration.CompositeConfiguration;
import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;


public class Configuration {


    private static final String DEFAULT_CONF_FILE_NAME = "application";
    private static final String FILE_EXT = ".properties";
    private static final String ENV_NAME = "env";

    private final CompositeConfiguration cc;

    private static Configuration INSTANCE = new Configuration();

    public Configuration() {
        this(DEFAULT_CONF_FILE_NAME);
    }

    public Configuration(String confFileName) {
        cc = new CompositeConfiguration();
        try {

            //load the different configuration file
            org.apache.commons.configuration.Configuration defaultProperties = new PropertiesConfiguration(confFileName + FILE_EXT);

            //get the environment information
            String envName = System.getProperty(ENV_NAME);

            //if the environment is specified, then load the environment specific property file
            if (envName != null) {
                org.apache.commons.configuration.Configuration envProperties = new PropertiesConfiguration(confFileName + "-" + envName + FILE_EXT);
                cc.addConfiguration(envProperties);
            }

            cc.addConfiguration(defaultProperties);

        } catch (ConfigurationException e) {
            throw new RuntimeException("Unable to load configuration file", e);
        }
    }

    public static String getString(String key) {
        return INSTANCE.cc.getString(key);
    }

    public static String getString(String key, String defaultValue) {
        return INSTANCE.cc.getString(key, defaultValue);
    }

}
