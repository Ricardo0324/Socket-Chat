package com.wyq;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;
import java.util.Scanner;

/**
 * @ClassName SocketServer
 * @Description: //TODO 服务端
 * @Author wyq
 * @Date 2022/4/11 20:39
 */
public class SocketServer {
    public static void main(String[] args) throws IOException {
        //创建Scanner对象，接收键盘输入
        Scanner input = new Scanner(System.in);
        //创建ServerSocket对象
        ServerSocket serverSocket = new ServerSocket(8888);
        //等待客户端连接
        System.out.println("等待客户端连接。。。");
        //监听客户端连接,返回Socket对象
        Socket socket = serverSocket.accept();
        //获得当前客户端的IP地址
        String clientIP = socket.getInetAddress().getHostAddress();
        System.out.println("【" + clientIP + "】连接成功..." + new Date());
        //通过Socket对象获得InputStream和OutputStream
        InputStream in = socket.getInputStream();
        OutputStream out = socket.getOutputStream();
        // 借助于 InputStream 和 OutputStream 获得 BufferedReader 和 BufferedWriter
        InputStreamReader isr = new InputStreamReader(in);
        BufferedReader reader = new BufferedReader(isr);
        OutputStreamWriter osw = new OutputStreamWriter(out);
        BufferedWriter writer = new BufferedWriter(osw);

        // 通过 BufferedWriter 向客户端发送连接成功信息
        writer.write("服务端连接成功..." + new Date());
        writer.newLine();
        //强制把数据输出,清空缓冲区
        writer.flush();

        while (true) {
            // 接收来自客户端的信息
            System.out.println("来自【客户端】的信息 (" + new Date() + ") ：" + reader.readLine());
            // 通过控制台输入信息并且进行发送
            writer.write(input.next());
            writer.newLine();
            writer.flush();
        }
    }
}
