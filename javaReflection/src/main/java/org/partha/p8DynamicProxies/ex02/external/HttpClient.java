package org.partha.p8DynamicProxies.ex02.external;

public interface HttpClient {

    void initialize();

    String sendRequest(String request);
}
