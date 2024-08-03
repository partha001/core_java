package org.partha.p2WorkingWithConstructors.dto;

import java.net.InetSocketAddress;

/**
 * key features of this class:
 * 1. has only one private constructor hence cant be instantiated directly from outside
 * 2. it is not only singleton but also fully immutable [doesnt have any setters ()]
 */
public class ServerConfiguration {

    private static ServerConfiguration serverConfigurationInstance;

    private final InetSocketAddress serverAddress;
    private final String greetingMessage;

    private ServerConfiguration(int port, String greetingMessage){
        this.greetingMessage = greetingMessage;
        this.serverAddress = new InetSocketAddress("localhost", port);

        if(serverConfigurationInstance==null){
            serverConfigurationInstance = this;
        }
    }

    public InetSocketAddress getServerAddress(){
        return this.serverAddress;
    }

    public String getGreetingMessage(){
        return this.greetingMessage;
    }

    public static ServerConfiguration getInstance(){
        return serverConfigurationInstance;
    }

}
