package org.example;
import org.example.service.MenuService;
import org.example.service.userService;
import org.example.utility.Utility;
import java.util.Scanner;
public class Main {
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        userService user = new userService();
        MenuService.welcomeMenu();
        MenuService.mainMenu();

        boolean quit = false;
        boolean flag = false;

        while (!quit) {

            System.out.println("Please enter your choice 0 for Main Menu: ");
            int choice = scanner.nextByte();
            scanner.nextLine();

            switch (choice) {
                case 0:
                    MenuService.mainMenu();
                    break;
                case 1:
                    System.out.print("Please enter your national code: ");
                    String username = scanner.nextLine();
                    System.out.print("Please enter your password: ");
                    String password = scanner.nextLine();
                    user.login(username, password);

                case 2:
                    System.out.print("Please enter your User Name: ");
                    String userName = scanner.nextLine();
                    System.out.print("Please enter your password: ");
                    password = scanner.nextLine();
                    System.out.println("Enter your nationalcode: ");
                    String nationalCode = scanner.nextLine();
                    Utility.integerForm(nationalCode);
                    Utility.range(nationalCode);
                    while (!flag){

                        flag = false;
                        break;
                    }
                    user.signUp(userName, password, nationalCode);
                    break;
                case 3:
                    quit = true;
                    break;

            }
        }
    }
}
