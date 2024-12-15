package org.example.week10.Task1;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@interface UserPermission {
    String value();
}

abstract class User {
    String username;
    public User(String username) {
        this.username = username;
    }
}

@UserPermission("regular")
class RegularUser extends User {
    public RegularUser(String username) {
        super(username);
    }
}

@UserPermission("admin")
class AdminUser extends User {
    public AdminUser(String username) {
        super(username);
    }
}

public class Main {
    public static void main(String[] args) {
        User admin = new AdminUser("Alice");
        User regularUser = new RegularUser("Bob");

        if (admin.getClass().getAnnotation(UserPermission.class).value().equals("admin")) {
            System.out.println(admin.username + " sent a message: Access granted.");
        } else {
            System.out.println(admin.username + " is restricted: Access denied.");
        }

        if (regularUser.getClass().getAnnotation(UserPermission.class).value().equals("admin")) {
            System.out.println(regularUser.username + " sent a message: Access granted.");
        } else {
            System.out.println(regularUser.username + " is restricted: Access denied.");
        }
    }
}
