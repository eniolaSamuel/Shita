package shita;

import shita.controllers.UserController;
import shita.dtos.requests.RegisterUserRequest;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.swing.*;

@SpringBootApplication
public class Main {
    private static UserController userController = new UserController();

    public static void main(String... params) {
        SpringApplication.run(Main.class, params);}}
//        String  mainMenu = """
//                Hi,
//                What do you want to do?
//                1 -> Register new User
//                2 -> Find Registered User
//                """;
//
//        int userInput = collectUserInput(mainMenu);
//
//        switch (userInput) {
//            case 1 -> registerUser();
//            case 2 -> findRegisteredUser();
//        }
//    }

//    private static void findRegisteredUser() {
//        int userId = collectUserInput("Enter user id");
//        display(userController.findById(userId).toString());
//        main();
//    }
//
//    private static void display(String prompt){
//        JOptionPane.showMessageDialog(null, prompt);
//    }
//
//    private static  void registerUser(){
//        String firstname = collectStringInput("Enter first name");
//        String lastname = collectStringInput("Enter last name");
//        String address = collectStringInput("Enter Address");
//        String email = collectStringInput("Enter Email");
//        String phoneNumber = collectStringInput("Enter Phone Number");
//        RegisterUserRequest request = new RegisterUserRequest();
//
//        request.setAddress(address);
//        request.setEmail(email);
//        request.setFirstName(firstname);
//        request.setLastName(lastname);
//        request.setPhoneNumber(phoneNumber);
//        display(userController.registerNewUser(request).toString());
//    }
//
//    private static String collectStringInput(String prompt){
//        return JOptionPane.showInputDialog(prompt);
//    }
//    private static int collectUserInput(String mainMenu){
//        return Integer.parseInt(JOptionPane.showInputDialog(mainMenu));
//    }
//}