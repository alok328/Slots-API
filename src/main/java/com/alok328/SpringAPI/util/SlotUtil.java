package com.alok328.SpringAPI.util;

import java.util.UUID;

public class SlotUtil {

  public static String generateUniqueId(){
    return UUID.randomUUID().toString().replaceAll("-", "").toUpperCase();
  }

}
