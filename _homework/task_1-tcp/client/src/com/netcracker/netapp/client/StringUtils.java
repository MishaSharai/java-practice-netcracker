package com.netcracker.netapp.client;

public class StringUtils {

  private static final String EMPTY_STR = "";

  public static boolean isEmpty(String str) {
    if (str != null) {
      return EMPTY_STR.equals(str);
    }

    return true;
  }

  public static boolean isNotEmpty(String str) {
    return !isEmpty(str);
  }

  public static boolean isBlank(String str) {
    if (isNotEmpty(str)) {
      return EMPTY_STR.equals(str.trim());
    }

    return true;
  }
}
