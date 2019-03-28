package com.gt.projects.bdd.base.config;

import org.apache.log4j.ConsoleAppender;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import java.io.PrintStream;

@Configuration
public class LoggerConfig {
    
    protected static Logger logger = Logger.getLogger(LoggerConfig.class);
    
    @PostConstruct
    public void initLogger(){
        
        Logger rootLogger = Logger.getRootLogger();
        rootLogger.setLevel(Level.INFO);
        
        ConsoleAppender console = new ConsoleAppender();
        String PATTERN = "%t, %d{yyyy/MM/dd HH:mm:ss.SSS} %5p (%F:%L) - %m%n";
        console.setLayout(new PatternLayout(PATTERN));
        console.setThreshold(Level.INFO);
        console.activateOptions();
        
    
        System.setOut(newLoggerPrintStream(System.out));
        System.setErr(newLoggerPrintStream(System.err));
    }
    
    public static PrintStream newLoggerPrintStream(final PrintStream original){
        return new PrintStream(original){
            @Override
            public void print(String s) {
                logger.info(s);
            }
        };
    }
    
}
