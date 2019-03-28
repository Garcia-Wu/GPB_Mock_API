package com.gt.projects.bdd.base.utils;

import org.apache.commons.exec.*;
import org.apache.log4j.Logger;

import java.io.IOException;

/**
 * Created by giotto.chow on 1/12/2018.
 */
public class CmdUtils{
    
    protected static Logger logger = Logger.getLogger(CmdUtils.class);
    
    public static Boolean runCommand(String command){
        try {
            CommandLine cmdLine = CommandLine.parse(command);
            DefaultExecutor executor = new DefaultExecutor();
            return executor.execute(cmdLine) == 0;
        } catch(IllegalArgumentException|IOException ex){
            ex.printStackTrace();
        }
        
        return false;
    }
    
    public static ExecuteWatchdog runCommandAsync(String command){
        return runCommandAsync(command, new DefaultExecuteResultHandler());
    }
    
    public static ExecuteWatchdog runCommandAsync(String command, ExecuteResultHandler handler){
        try {
            CommandLine cmdLine = CommandLine.parse(command);
            DefaultExecutor executor = new DefaultExecutor();
        
            ExecuteWatchdog watchdog = new ExecuteWatchdog(ExecuteWatchdog.INFINITE_TIMEOUT);
            executor.setWatchdog(watchdog);
            
            executor.execute(cmdLine, handler);
        
            return watchdog;
        } catch(IllegalArgumentException|IOException ex){
            ex.printStackTrace();
        }
        
        return null;
    }
}
