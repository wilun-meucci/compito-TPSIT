package com.server;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

import com.fasterxml.jackson.databind.ObjectMapper;
public class SocketServer {

    public Socket avvia() throws IOException {
        ServerSocket server = new ServerSocket(34568);

        Biglietto  b0 = new Biglietto("grande", "f");
        Biglietto  b1 = new Biglietto("piccolo", "g");
        Biglietto  b2 = new Biglietto("medio", "j");
        Biglietto  b3 = new Biglietto("sgravato", "m");
        Biglietto  b4 = new Biglietto("du gatti", "s");
        Biglietto  b5 = new Biglietto("na stanza", "t");
        message m = new message();
        m.add(b0);
        m.add(b1);
        m.add(b2);
        m.add(b3);
        m.add(b4);
        m.add(b5);

        for (;;) {
            Socket client = server.accept();
            communicate(client,m);
            server.close();
           
           
            
        }
    }
    public void communicate(Socket client, message m) throws IOException {
        String pippo ="";
        while(!pippo.toUpperCase().equals("FINE")){
            BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
            DataOutputStream out = new DataOutputStream(client.getOutputStream());
            pippo = in.readLine();
            System.out.println(pippo);
            ObjectMapper json = new ObjectMapper();
            System.out.println("voglio morire");
            message j = json.readValue(pippo, message.class);
            System.out.println(j.getBiglietti()+"ciao");
            String s = json.writeValueAsString(m);
            if(j.getBiglietti().isEmpty())
            {
                System.out.println("oh no");
                out.writeBytes(s + '\n');
            }
            else {
                out.writeBytes(s + '\n');
                System.out.println(j.getBiglietti());
            }
        }
        client.close();
        
        
        

    }
    
}



