package com.server;

import java.io.IOException;


public class App 
{
    public static void main( String[] args ) throws IOException
    {
        System.out.println("ciao");
        SocketServer server = new SocketServer();
        server.avvia();     
        
}
}

