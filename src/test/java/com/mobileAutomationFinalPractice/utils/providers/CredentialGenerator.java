package com.mobileAutomationFinalPractice.utils.providers;

import java.util.Random;

public class CredentialGenerator {
    private static final String ALPHABET = "abcdefghijklmnopqrstuvwxyz";
    private static final Random RANDOM = new Random();
    private String email;
    private String password = "testpasss";
    public String generateEmail(){
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i<10; i++){
            int index = RANDOM.nextInt(ALPHABET.length());
            sb.append(ALPHABET.charAt(index));
        }

        sb.append(RANDOM.nextBoolean()?"@gmail.com":"@hotmail.com");
        this.email=sb.toString();

        return this.email;
    }
    public String getPassword(){
        return this.password;
    }

    public CredentialGenerator() {
    }
}
