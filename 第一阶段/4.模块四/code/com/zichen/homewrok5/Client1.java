package com.zichen.homewrok5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class Client1 {
    public static void main(String[] args) {
        Socket socket = null;
        Scanner sc = null;
        PrintStream printStream = null;
        BufferedReader bufferedReader = null;
        try {
            socket = new Socket("127.0.0.1", 8888);
            sc = new Scanner(System.in);
            printStream = new PrintStream(socket.getOutputStream());
            while(true){
                System.out.println("--------------------");
                System.out.println("输入要发送的信息：");
                String string = sc.next();
                printStream.println(string);
                System.out.println("发送成功！");
                if(string.equals("退出程序")){
                    break;
                }
                bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                String string2 = bufferedReader.readLine();
                System.out.println();
                System.out.println("服务器回发的字符内容是：" + string2);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(bufferedReader != null){
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(printStream != null){
                printStream.close();
            }

            sc.close();

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
