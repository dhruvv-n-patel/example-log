package com.obsTask.Logging;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component

public class LoggingTask {

    private static final Logger logger = LoggerFactory.getLogger(LoggingTask.class);
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    @Scheduled(fixedRate = 60000) // Execute every 1 minute (60,000 milliseconds)
    public void logMessage() {
    	String currentTime = LocalDateTime.now().format(formatter);
        logger.info("This is a log message. Current time: {}", currentTime);
    }
}
