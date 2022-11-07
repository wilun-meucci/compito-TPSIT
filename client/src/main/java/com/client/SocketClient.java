package com.client;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

import com.fasterxml.jackson.databind.ObjectMapper;

public class SocketClient {
   
    private Socket socket;
    private DataInputStream in;
    private DataOutputStream out;
    private Scanner keyboard = new Scanner(System.in);
    private String userString;
    private String serverString;

    public Socket connect() throws IOException
    {
        this.socket = new Socket(InetAddress.getLocalHost(), 34568);
        this.in = new DataInputStream(socket.getInputStream());
        this.out = new DataOutputStream(socket.getOutputStream());
        this.userString = "";
        return socket;
    }
    
    public void send() throws IOException
    {
        ObjectMapper json = new ObjectMapper();
            message m = new message();
            String s = json.writeValueAsString(m);
            out.writeBytes(s + '\n');
            System.out.println(s);
        while (true)
        {
            if(userString.toUpperCase().equals("FINE"))
            {
                break;
            }
            
            serverString = in.readLine();
            message j = json.readValue(serverString, message.class);
            System.out.println("Risposta dal server: " + '\n' + j.getBiglietti());
            System.out.println("Seleziona un bigletto tramite nome es(" + j.getBiglietti().get(0).getNome()+")");
            this.userString = this.keyboard.nextLine();
            System.out.println("user: "+ userString);
            for (Biglietto i : j.getBiglietti()) {
                System.out.println(i.getNome() + i.getPosto());
                
                if(i.getNome().equals(userString))
                {
                    j.remove(i);
                    System.out.println(i.getNome());
                    break;
                }
                System.out.println("ciao");
            }
            System.out.println("ciao: "+j.getBiglietti());
            s = json.writeValueAsString(j);
            out.writeBytes(s + '\n');
            
        }
        socket.close();
    }
}
