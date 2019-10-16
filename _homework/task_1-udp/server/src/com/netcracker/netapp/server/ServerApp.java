package com.netcracker.netapp.server;

import java.io.IOException;
import java.net.*;
import java.util.Date;

public class ServerApp {

  public static void main(String[] args) {

    while (true) {
      try {
        Date date = new Date();
        long time = date.getTime();
        String timeStr = String.valueOf(time);
        byte[] data = timeStr.getBytes();

        InetAddress addr = InetAddress.getByName("127.0.0.1");

        DatagramPacket pack = new DatagramPacket(data, data.length, addr, 1050);

        DatagramSocket ds = new DatagramSocket();

        ds.send(pack);

        ds.close();
      } catch (IOException e) {
        System.err.println(e);
      }

      try {
        Thread.sleep(1000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }
}
