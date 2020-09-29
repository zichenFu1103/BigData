package com.zichen.homewrok5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.util.List;

public class ServerThread extends Thread{

    private Socket socket;
    public static List<Socket> socketList;

    public ServerThread(Socket socket){
        this.socket = socket;
    }



    @Override
    public void run() {
        BufferedReader bufferedReader = null;
        PrintStream printStream = null;
        try{
            bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            while(true){
                System.out.println("------------------");
                String string = bufferedReader.readLine();
                System.out.println("客户端"+socket.getInetAddress()+"发来的字符内容是：" + string);
                if(string.equals("退出程序")){
                    System.out.println("客户端"+socket.getInetAddress()+"已下线！");
                    break;
                }
                for(Socket s : socketList){
                    if(!s.equals(socket)){
                        printStream = new PrintStream(s.getOutputStream());
                        printStream.println(string);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(printStream != null){
                printStream.close();
            }

            if(bufferedReader != null){
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
