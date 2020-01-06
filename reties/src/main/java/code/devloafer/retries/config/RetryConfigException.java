package code.devloafer.retries.config;

public class RetryConfigException extends Exception {

    public RetryConfigException(String configErrorMessage) {
        super(configErrorMessage);
    }
}
