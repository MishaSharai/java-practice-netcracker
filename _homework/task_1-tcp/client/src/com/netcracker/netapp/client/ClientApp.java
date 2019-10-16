package com.netcracker.netapp.client;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class ClientApp {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    System.out.println("Enter server IP address (or press enter for localhost): ");
    String serverIPStr = scanner.nextLine();

    if (StringUtils.isBlank(serverIPStr)) {
      System.out.println("localhost ip is using");
      serverIPStr = "127.0.0.1";
    }

    ClientSocketConnection connection = null;
    try {
      connection = new ClientSocketConnection(serverIPStr);
      System.out.println("Enter something: ");
      String str = scanner.nextLine();

      connection.writeToServer(str);

      List<String> response = connection.readFromServer();

      for (String elem : response) {
        System.out.println(elem);
      }
    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      connection.close();
    }
  }
}
