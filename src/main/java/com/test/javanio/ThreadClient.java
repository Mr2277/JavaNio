package com.test.javanio;

import java.io.IOException;

public class ThreadClient implements Runnable{
    private NIOClient nioClient;
    public ThreadClient(NIOClient nioClient){
        this.nioClient=nioClient;
    }

    @Override
    public void run() {
        try {
            nioClient.initClient("localhost", 8989);
            nioClient.listen();


        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
