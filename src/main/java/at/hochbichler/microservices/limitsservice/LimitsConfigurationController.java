package at.hochbichler.microservices.limitsservice;

import at.hochbichler.microservices.limitsservice.bean.LimitsConfiguration;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LimitsConfigurationController {
    @Autowired
    private Configuration configuration;

    @GetMapping("/limits")
    public LimitsConfiguration retrieveLimitsFromConfiguration() {
        return new LimitsConfiguration(configuration.getMinimum(),configuration.getMaximum());
    }

    @GetMapping("/limits-fault")
    @HystrixCommand(fallbackMethod = "retrieveLimitsFallback")
    public LimitsConfiguration retrieveLimitsFault() {
        throw new RuntimeException("A fault occured!");
    }

    public LimitsConfiguration retrieveLimitsFallback() {
        return new LimitsConfiguration(1,100);
    }
}
