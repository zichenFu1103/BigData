package com.zichen.homework4;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class Client {

    public static void main(String[] args) {
        Socket socket = null;
        ObjectOutputStream objectOutputStream = null;
        ObjectInputStream objectInputStream = null;
        try {
            socket = new Socket("127.0.0.1", 8888);
            System.out.println("连接成功！");
            UserMessage userMessage = new UserMessage("check", new User("visitor","123456"));
            objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
            objectOutputStream.writeObject(userMessage);
            objectInputStream = new ObjectInputStream(socket.getInputStream());
            UserMessage obj = (UserMessage)objectInputStream.readObject();
            if(obj.getType().equals("success")){
                System.out.println("登陆成功！");
            }else{
                System.out.println("登陆失败！");
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            if(objectOutputStream != null){
                try {
                    objectOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(socket != null){
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
