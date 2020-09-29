package com.zichen.homewrok5;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Server {

    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        Socket socket = null;
        List<Socket> socketList = new ArrayList<>();

        try {
            serverSocket = new ServerSocket(8888);
            while(true){
                System.out.println("------------------");
                System.out.println("等待连接...");
                socket = serverSocket.accept();
                socketList.add(socket);
                System.out.println("客户端"+socket.getInetAddress()+"连接成功！");
                ServerThread serverThread = new ServerThread(socket);
                ServerThread.socketList = socketList;
                serverThread.start();
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {

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
