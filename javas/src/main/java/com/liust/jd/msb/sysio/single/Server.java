package com.liust.jd.msb.sysio.single;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    ServerSocket serverSocket ;
    int port  = 9090;

    public void init(){

        try {
            serverSocket = new ServerSocket(port, 20);
            System.out.println("server start at port: " + port);

            while (true){
                System.out.println(" server wait for client:");
                Socket client = serverSocket.accept();
                System.out.println(" server get an client:" + client.getInetAddress() + ":" + client.getPort());

                new Thread( ()->{
                    try{
                        InputStream inputStream = client.getInputStream();
                        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
                        while(true){
                            String line = reader.readLine();
                            if(line != null ){
                                System.out.println("from client:" + line);
                            }else {
                                System.out.println("read from client over");
                                client.close();
                                break;
                            }
                        }
                    }catch (Exception e) {
                        e.printStackTrace();
                    }


                }).start();


            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Server().init();
    }


}
