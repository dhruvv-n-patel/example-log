package com.obsTask.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.obsTask.Logging.LoggingTask;

@RestController
@Component
public class testController {
    private static final Logger logger = LoggerFactory.getLogger(testController.class);
    
   // @RequestMapping(value="/ping", method=RequestMethod.GET,produces="text/plain")
   // @ResponseBody
    @GetMapping("/ping")
    public String foo() {
		logger.info("This is a log messeesage system is alive");
    	return "Response!";
    }
}
