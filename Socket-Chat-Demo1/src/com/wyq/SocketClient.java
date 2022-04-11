package com.wyq;

import java.io.*;
import java.net.Socket;
import java.util.Date;
import java.util.Scanner;

/**
 * @ClassName SocketClient
 * @Description: //TODO 客户端
 * @Author wyq
 * @Date 2022/4/11 21:09
 */
public class SocketClient {
    public static void main(String[] args) throws IOException {
        // 创建 Scanner 对象
        Scanner input = new Scanner(System.in);
        // 创建 Socket 对象
        Socket socket = new Socket("127.0.0.1", 8888);
        // 通过 Socket 对象获得 InputStream 和 OutputStream
        InputStream in = socket.getInputStream();
        OutputStream out = socket.getOutputStream();
        // 借助于 InputStream 和 OutputStream 获得 BufferedReader 和 BufferedWriter
        InputStreamReader isr = new InputStreamReader(in);
        BufferedReader reader = new BufferedReader(isr);
        OutputStreamWriter osw = new OutputStreamWriter(out);
        BufferedWriter writer = new BufferedWriter(osw);

        while (true) {
            // 接收来自服务端的信息
            System.out.println("来自【服务端】的信息 (" + new Date() + ") ：" + reader.readLine());
            // 通过控制台输入信息并且进行发送
            writer.write(input.next());
            writer.newLine();
            writer.flush();
        }
    }
}
