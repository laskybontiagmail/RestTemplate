package com.lasky;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;

import com.lasky.RestTemplate.utilities.Utility;


/**
 * Rest Template
 *
 */
@SpringBootApplication
@EnableAutoConfiguration(exclude = {
		DataSourceAutoConfiguration.class,
		DataSourceTransactionManagerAutoConfiguration.class,
		HibernateJpaAutoConfiguration.class})
public class Application {
	private static Logger logger = LogManager.getLogger(Application.class);
	
    public static void main( String[] args ) {
    	logger.info("main(...) { ");
    	
    	logger.info("Artanis' Rest Template!");
    	logger.info("Process ID: " + Utility.getOnlyInstance().getSystemProcessIdLightWeightProcessId());
    	
    	SpringApplication.run(Application.class, args);
    	
    	logger.info("} main(...)");
    }
    
}


