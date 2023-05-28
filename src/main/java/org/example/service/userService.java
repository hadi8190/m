package org.example.service;
import
        org.example.model.User;
import org.example.repository.userRepo;

public class userService {

    private User loggedInUser = null;

    public void signUp(String username,String password, String nationalCode) {
        if (userRepo.findUser(password) == null) {
            if (userRepo.findUser1(nationalCode,password) == null) {
                User user = new User(username,password, nationalCode);
                userRepo.createUser(user);
                System.out.println("Sign up is ok");
            } else {
                System.out.println("national code has already been signed up, please log in");
            }
        } else {
            System.out.println("username has already been signed up, please log in");
        }
    }
    public boolean login(String username, String password) {
        User user = userRepo.findUser(username);
        if (user != null) {
            if (user.getPassword().equals(password)) {
                loggedInUser = user;
                return true;
            }
            else {
                return false;
            }
        } else {
            System.out.println("User with this username and password was not found. Please sign up");
            return false;
        }
    }

    public void changePassword(User oldPassword, String newPassword) {
        if (loggedInUser.getPassword().equals(oldPassword)) {
            userRepo.updateUserPassword(oldPassword, newPassword);
            System.out.println("Password changed");
        }
        else {
            System.out.println("Old password is incorrect");
        }
    }
}
