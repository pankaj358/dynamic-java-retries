# dynamic-java-retries
This block of code can be use to retry operation based on exception specified 
You can use this code for retry for external resources in your application.
Sample use case is
 Step 1 : Create Configuration for retry
           maxxAttempts = 2
           delayConfig = null
           Set<Class> = new HashSet<>(Arrays.asList(FileNotFoundException.class));
           
           Retry::new.run(Callable<R> call, config);
