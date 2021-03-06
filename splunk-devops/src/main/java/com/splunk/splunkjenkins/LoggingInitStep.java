package com.splunk.splunkjenkins;

import hudson.init.Initializer;

import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

import static hudson.init.InitMilestone.JOB_LOADED;

@edu.umd.cs.findbugs.annotations.SuppressFBWarnings("LG_LOST_LOGGER_DUE_TO_WEAK_REFERENCE")
public class LoggingInitStep {
    private final static String rootLoggerName = "";

    @Initializer(after = JOB_LOADED)
    public static void setupSplunkJenkins() {
        //only log warning message for HealthMonitor which runs every 20s
        Logger.getLogger(HealthMonitor.class.getName()).setLevel(Level.WARNING);
        Logger.getLogger(rootLoggerName).addHandler(JdkSplunkLogHandler.LogHolder.LOG_HANDLER);
        //init plugin
        SplunkJenkinsInstallation.markComplete(true);
    }

}
