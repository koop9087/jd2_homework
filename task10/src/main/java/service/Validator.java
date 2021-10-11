package service;

public class Validator {
    public static boolean validate(String name, String phone, String email) {
        return !name.isBlank() && (!phone.isBlank() || !email.isBlank());
    }
}
