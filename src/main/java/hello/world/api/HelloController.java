package hello.world.api;

import hello.world.api.custom_metrics.CustomCountMetric;
import hello.world.api.custom_metrics.CustomGaugeMetric;
import io.micrometer.core.annotation.Timed;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;
import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("/hello")
public class HelloController {

    @Autowired
    private CustomCountMetric customCountMetric;

    @Autowired
    private CustomGaugeMetric customGaugeMetric;

    @GetMapping
    public String olaMundo(){
        customCountMetric.increment();
        return "Hello World!";
    }

    @GetMapping("/slow")
    @Timed(
        value = "hello.world.slow",
        extraTags={"TYPE","histogram"},
        description = "teste histogram",
        histogram = true,
        percentiles = {0.5, 0.95, 0.99}
    )
    public String slow() throws InterruptedException {

        TimeUnit.SECONDS.sleep(new Random().nextInt(10));

        return "Slow Hello World!";
    }

}
