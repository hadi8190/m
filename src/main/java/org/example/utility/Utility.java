package org.example.utility;

public class Utility {

  public static void integerForm(String natioanlcode) {
    try{
         int nat = Integer.parseInt(natioanlcode);
         System.out.println(nat);
    }catch (Exception e){
        System.out.println("Please enter integer.");
    }
  }
  public static void range(String nationalCode){
      if (nationalCode.length() != 5){
          System.out.println("ERROR!");
      }
  }
}
