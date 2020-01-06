package code.devloafer.retries.config;

import lombok.Data;
import lombok.Value;

import java.util.concurrent.TimeUnit;

@Value
public class DelayConfig {
    private long delay;
    private TimeUnit timeUnit;
}
