package com.mobileAutomationFinalPractice.utils.providers;

import java.util.Random;

public class Emailprovider {
    private static final String ALPHABET = "abcdefghijklmnopqrstuvwxyz";
    private static final Random RANDOM = new Random();
    public String generateEmail(){
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i<10; i++){
            int index = RANDOM.nextInt(ALPHABET.length());
            sb.append(ALPHABET.charAt(index));
        }

        sb.append(RANDOM.nextBoolean()?"@gmail.com":"@hotmail.com");

        return sb.toString();
    }
}
