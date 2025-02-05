package org.partha.p8DynamicProxies.ex02.external.impl;

import org.partha.p8DynamicProxies.ex02.external.HttpClient;

public class HttpClientImpl implements HttpClient {
    @Override
    public void initialize() {
        System.out.println("Initialize HTTP client");
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String sendRequest(String request) {
        System.out.println(String.format("Sending request %s", request));
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Received response");
        return "someResponse data";
    }
}
