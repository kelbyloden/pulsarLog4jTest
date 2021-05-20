package hello;

import java.util.concurrent.atomic.AtomicLong;

import javax.annotation.PreDestroy;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.pulsar.client.api.Producer;
import org.apache.pulsar.client.api.PulsarClient;
import org.apache.pulsar.client.api.PulsarClientException;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();
    
    // Use Logback or Log4j2 through the SLF4J interface
    //private Logger log = LoggerFactory.getLogger(GreetingController.class);

    // Use Log4j2 API directly
    private Logger log = LogManager.getLogger(GreetingController.class);
    
	@SuppressWarnings("null")
	@RequestMapping(value="/greeting",
    		method=RequestMethod.GET,
    		produces = { "application/json" })
    public Greeting greeting(@RequestParam(value="name", defaultValue="World") String name) {
    	
    	log.info("Sample app log message");
    	
    	if ("error".equalsIgnoreCase(name)) {
        	log.error("Logging sample error message ;errorCode={};", 1000);
    	} else if ("warn".equalsIgnoreCase(name)) {
        	log.warn("Logging sample warning message");
    	}
    	
    	log.info("Sample manual key-value message: ;{}={};{}={};", "key1", "value1", "key2", "value2");
    	// {"timestamp":"2018-09-21T21:57:44.083Z","message":"Sample log message key1=value1 key2=value2 ","logger":"h.GreetingController","thread":"http-nio-8080-exec-1","level":"INFO"}

        return new Greeting(counter.incrementAndGet(), String.format(template, name));
    }
}
