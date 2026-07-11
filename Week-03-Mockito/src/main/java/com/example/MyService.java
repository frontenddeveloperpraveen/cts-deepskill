package com.example;

public class MyService {
    private final ExternalApi externalApi;

    public MyService(ExternalApi externalApi) {
        this.externalApi = externalApi;
    }

    public String fetchData() {
        return externalApi.getData();
    }

    public void doLogging(String message) {
        externalApi.logAction(message);
    }

    public String processValue(int val) {
        return externalApi.process(val);
    }

    public void notify(String user, String msg) {
        externalApi.notifyUser(user, msg);
    }
}
