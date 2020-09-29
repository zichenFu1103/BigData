package com.zichen.homework4;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        Socket socket = null;
        ObjectInputStream objectInputStream = null;
        ObjectOutputStream objectOutputStream = null;
        try {
            serverSocket = new ServerSocket(8888);
            System.out.println("等待连接...");
            socket = serverSocket.accept();
            objectInputStream = new ObjectInputStream(socket.getInputStream());
            UserMessage obj = (UserMessage)objectInputStream.readObject();
            if(obj.getUser().getUsername().equals("admin")){
                obj.setType("success");
            }else{
                obj.setType("fail");
            }
            objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
            objectOutputStream.writeObject(obj);
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
            if(objectInputStream != null){
                try {
                    objectInputStream.close();
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
            if(serverSocket != null){
                try {
                    serverSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
