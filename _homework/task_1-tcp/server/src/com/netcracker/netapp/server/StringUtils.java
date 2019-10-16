package com.netcracker.netapp.server;

public class StringUtils {

  public static String getInvertString(String str) {
    return new StringBuilder(str).reverse().toString();
  }
}
