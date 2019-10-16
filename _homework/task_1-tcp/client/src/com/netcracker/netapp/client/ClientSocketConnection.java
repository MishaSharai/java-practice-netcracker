package com.netcracker.netapp.client;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class ClientSocketConnection {

  Socket socket;
  PrintWriter writer;
  BufferedReader reader;

  public ClientSocketConnection(String host) throws IOException {
    InetAddress serverIP = InetAddress.getByName(host);
    socket = new Socket(serverIP, 8848);

    OutputStream outputStream = socket.getOutputStream();
    writer = new PrintWriter(outputStream);

    InputStream input = socket.getInputStream();
    reader = new BufferedReader(new InputStreamReader(input));
  }

  public void writeToServer(String str) {
    writer.println(str);
    writer.flush();
  }

  public List<String> readFromServer() throws IOException {
    List<String> result = new ArrayList<>();

    String line;
    while ((line = reader.readLine()) != null) {
      result.add(line);
    }

    return result;
  }

  public void close() {
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

    if (socket != null) {
      try {
        socket.close();
      } catch (IOException e) {
        throw new RuntimeException("error during closing of internal socket!", e);
      }
    }
  }
}
