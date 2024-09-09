package hello.world.api.custom_metrics;

import io.micrometer.core.instrument.Gauge;
import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class CustomGaugeMetric {

    public CustomGaugeMetric(MeterRegistry meterRegistry) {
        Gauge.builder("hello.world.gauge", () -> new Random().nextDouble() * 100)
                .description("Exemplo de metrica customizada do tipo Gauge")
                .tag("TYPE", "gauge")
                .register(meterRegistry);
    }
}
