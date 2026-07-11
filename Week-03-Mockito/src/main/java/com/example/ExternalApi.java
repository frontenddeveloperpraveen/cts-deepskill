package com.example;

public interface ExternalApi {
    String getData();
    void logAction(String message);
    String process(int value);
    void notifyUser(String user, String msg);
}
