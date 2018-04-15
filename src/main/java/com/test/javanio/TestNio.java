package com.test.javanio;

public class TestNio {
    public static void main(String[] args) throws Exception {

        NIOServer server = new NIOServer();
        ThreadServer threadServer=new ThreadServer(server);
        Thread thread=new Thread(threadServer);
        thread.start();
        Thread.sleep(1000);
        NIOClient client = new NIOClient();
        ThreadClient threadClient=new ThreadClient(client);
        Thread thread1=new Thread(threadClient);
        thread1.start();


       /*
       NIOServer server=new NIOServer();
       server.initServer(8970);
       server.listen();
       NIOClient client=new NIOClient();
       client.initClient("127.0.0.1",8970);
       client.listen();
       */
    }
}
