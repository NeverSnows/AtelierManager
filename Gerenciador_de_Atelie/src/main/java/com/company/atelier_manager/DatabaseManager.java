package com.company.atelier_manager;

import java.util.Objects;

public class DatabaseManager {
    public static boolean validateUser(String email, String password){
        return !Objects.equals(email, "false") && !Objects.equals(password, "false");
    }
    public static boolean registerUser(String name, String email, String password){
        return !Objects.equals(name, "false") && !Objects.equals(email, "false") && !Objects.equals(password, "false");
    }
}
