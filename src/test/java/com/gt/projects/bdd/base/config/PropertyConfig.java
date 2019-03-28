package com.gt.projects.bdd.base.config;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

import java.io.IOException;

@Configuration
//@PropertySource("classpath:hsbc_cmb_bdd.properties")
public class PropertyConfig {

    private Logger logger = Logger.getLogger(this.getClass());

    private static final String PROPERTY_PATH = "hsbc_cmb_bdd.properties";

    @Bean
    protected PropertyPlaceholderConfigurer initPropertyPlaceholder() throws IOException{
        PropertyPlaceholderConfigurer ppc = new PropertyPlaceholderConfigurer();
        ppc.setLocation(new ClassPathResource(PROPERTY_PATH));
        ppc.setIgnoreUnresolvablePlaceholders(true);
        return ppc;
    }

}
