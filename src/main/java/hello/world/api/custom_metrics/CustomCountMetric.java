package hello.world.api.custom_metrics;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.stereotype.Component;

@Component
public class CustomCountMetric {

    Counter visitCounter;

    CustomCountMetric(MeterRegistry registry) {
        visitCounter = Counter.builder("hello.world.counter")
                .description("Exemplo de metrica customizada do tipo Gauge")
                .tag("TYPE", "counter")
                .register(registry);
    }

    public void increment() {
        visitCounter.increment();
    }

}
