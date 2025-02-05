package org.partha.p8DynamicProxies.ex01.external;

public interface HttpClient {

    void initialize();

    String sendRequest(String request);
}
