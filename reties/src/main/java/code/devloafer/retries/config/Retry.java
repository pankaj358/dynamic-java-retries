package code.devloafer.retries.config;


import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;


public class Retry {

    private Set<Class> runWith = null;
    private long _delay = 0;
    private Exception thrownException;

    public <R> R run(Callable<R> callable, RetryConfig config) throws Exception {
        if (config == null || config.getRetryWith() == null)
            throw new RetryConfigException("Configuration for retry can not be null.");
        boolean delay = (config.getDelayConfig() != null);
        if (delay) _delay = config.getDelayConfig().getDelay();
        int maxAttempts = config.getMaxxAttempts();
        runWith = config.getRetryWith();
        while (maxAttempts-- > 0) {
            try {
                return callable.call();
            } catch (Exception calledException) {
                if (isCallbackThrowableFound(calledException)) {
                    if (delay) {
                        config.getDelayConfig().getTimeUnit().sleep(_delay);
                    }
                }
                thrownException = calledException;
            }
        }
        throw thrownException;
    }

    private boolean isCallbackThrowableFound(Exception exception) {
        return runWith.contains(exception.getClass());
    }
}
