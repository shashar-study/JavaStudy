package Ncoder;

import java.io.ByteArrayInputStream;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {
  public static void main(String[] args) {
    String obj  = "abc";
    byte b[] = obj.getBytes();
    ByteArrayInputStream obj1 = new ByteArrayInputStream(b);
    for (int i = 0; i < 2; ++ i) {
      int c;
      while ((c = obj1.read()) != -1) {
        if (i == 0) {
          System.out.print(Character.toUpperCase((char)c));
        }
      }
    }

  }
}
/*
  public String reverseLeftWords(String s, int n) {
    String ans=s.substring(6)+s.substring(0,6);

}*/
