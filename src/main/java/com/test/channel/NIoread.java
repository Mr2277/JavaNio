package com.test.channel;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class NIoread {
    public void readByNIO(String file) throws IOException {
        //第一步 获取通道
        FileInputStream fis = null;
        FileChannel channel=null;
        try {
            fis = new FileInputStream(file);
            channel=fis.getChannel();

            //文件内容的大小
            int size=(int) channel.size();

            //第二步 指定缓冲区
            ByteBuffer buffer=ByteBuffer.allocate(1024);
            System.out.println(channel.position());

            //第三步 将通道中的数据读取到缓冲区中
            channel.read(buffer);
            System.out.println(channel.position());
             
            Buffer bf= buffer.flip();
            System.out.println("limt:"+bf.limit());

            byte[] bt=buffer.array();
            System.out.println(new String(bt,0,size));

            buffer.clear();
            buffer=null;
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally{
            try {
                channel.close();
                fis.close();

            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }


        }

    }
    /**
     * 利用NIO将内容输出到文件中
     * @param file
     */
    public void writeFileByNIO(String file){
        FileOutputStream fos=null;
        FileChannel fc=null;
        ByteBuffer buffer=null;
        try {
            fos=new FileOutputStream(file);
            //第一步 获取一个通道
            fc=fos.getChannel();
            //buffer=ByteBuffer.allocate(1024);
            //第二步 定义缓冲区
            buffer=ByteBuffer.wrap("Hello World 2".getBytes());
            //将内容写到缓冲区
            fos.flush();
            fc.write(buffer);

        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally{
            try {
                fc.close();
                fos.close();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

        }
    }
    public static void main(String[] args) throws IOException {
        NIoread nood=new NIoread();
        String fileName="F:\\input.txt";
        //nood.readFileByIO(fileName);
         nood.readByNIO(fileName);
        //nood.writeFileByNIO(fileName);
    }



}
