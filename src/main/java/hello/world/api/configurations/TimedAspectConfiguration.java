package hello.world.api.configurations;

import io.micrometer.core.aop.TimedAspect;
import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TimedAspectConfiguration {

    @Bean
    public TimedAspect cccc(MeterRegistry registry) {
        return new TimedAspect(registry);
    }

}
