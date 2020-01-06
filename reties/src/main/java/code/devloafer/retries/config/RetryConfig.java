package code.devloafer.retries.config;

import lombok.Value;

import java.util.Set;

@Value
public class RetryConfig {
    private Set<Class> retryWith;
    private int maxxAttempts;
    private DelayConfig delayConfig;
}
