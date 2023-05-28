package org.example.service;

public class MenuService {
    public static void welcomeMenu(){
        System.out.println("Welcome :)");
    }
    public static void mainMenu(){
        System.out.println("Press your choice: \t" +
                           "1 -> Login\t" +
                           "2 -> Sign up\t" +
                           "3 -> quit");
    }
}
