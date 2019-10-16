package com.netcracker.netapp.server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerApp {

  private static final int SERVER_PORT = 8848;

  public static void main(String[] args) {
    ServerSocket serverSocket = null;
    try {
      serverSocket = new ServerSocket(SERVER_PORT);
    } catch (IOException e) {
      e.printStackTrace();
    }

    while (true) {
      BufferedReader reader = null;
      PrintWriter writer = null;

      try {
        Socket clientSocket = serverSocket.accept();

        InputStream clientInput = clientSocket.getInputStream();
        InputStreamReader streamReader = new InputStreamReader(clientInput);
        reader = new BufferedReader(streamReader);
        String str = reader.readLine();

        OutputStream clientOS = clientSocket.getOutputStream();
        writer = new PrintWriter(clientOS);
        writer.println(StringUtils.getInvertString(str));
        writer.flush();
      } catch (IOException e) {
        e.printStackTrace();
      } finally {
        if (reader != null) {
          try {
            reader.close();
          } catch (IOException e) {
            e.printStackTrace();
          }
        }
        if (writer != null) {
          writer.close();
        }
      }
    }
  }
}
