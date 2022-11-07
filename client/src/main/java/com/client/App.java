package com.client;

import java.io.IOException;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws IOException
    {
        SocketClient client = new SocketClient();
        client.connect();
        client.send();
    }
}
