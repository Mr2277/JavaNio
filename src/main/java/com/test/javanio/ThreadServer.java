package com.test.javanio;

public class ThreadServer implements Runnable {
    private NIOServer nioServer;
    public  ThreadServer(NIOServer nioServer){
        this.nioServer=nioServer;
    }
    @Override
    public void run() {
        try {
            nioServer.initServer(8989);
            nioServer.listen();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
