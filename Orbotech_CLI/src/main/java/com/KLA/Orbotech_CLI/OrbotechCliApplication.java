package com.KLA.Orbotech_CLI;

import com.KLA.Orbotech_CLI.Entity.AuthUser;
import com.KLA.Orbotech_CLI.Entity.User;
import com.KLA.Orbotech_CLI.Services.Service;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class OrbotechCliApplication {
    static Service service = new Service();
    static Scanner scanner = new Scanner(System.in);
    static User currentUser;
    static String email;
    static String password;
    public static boolean isLogin,isNewUser = false;


    public static void main(String[] args) {
        System.out.println("Welcome To KLA ORBOTECH CLI");
        System.out.println("Login = 1 | SingUp = 2");
        System.out.print("Choose Option: ");
        String userState = scanner.nextLine();

        switch (userState)
        {
            case "1":
                Login();
                break;
            case "2":
                SignUp();
                Login();
                break;
            default:
                break;
        }
    }

    private static void Login() {
        while (!isLogin)
        {
            System.out.print("Enter Email: ");
            email = scanner.nextLine();

            System.out.print("Enter Password: ");
            password = scanner.nextLine();

            service.Login(new AuthUser(email, password));
        }
    }

    private static void SignUp() {
        while (!isNewUser)
        {
            System.out.print("Enter Name: ");
            String newName = scanner.nextLine();

            System.out.print("Enter Email: ");
            String newEmail = scanner.nextLine();

            System.out.print("Enter Password: ");
            String newPassword = scanner.nextLine();

            service.SignUp(new User(newName, newEmail, newPassword));
        }
    }

    private static  void SetCurrnetUser(){
        //TODO: Set 'currentUser' according to user that logged in
    }
}
