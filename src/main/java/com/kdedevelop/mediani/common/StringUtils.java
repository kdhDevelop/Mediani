package com.kdedevelop.mediani.common;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class StringUtils {
    public static final char[] upperTable = {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
    public static final char[] lowerTable = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
    public static final char[] numberTable = {'0','1','2','3','4','5','6','7','8','9'};
    public static final char[] symbolTable = {'!', '@', '#', '$', '^', '&', '*'};
    public final static String SYMBOLS = ".*[^a-zA-Z0-9 ].*";
    public final static String NUMBERS = ".*[0-9].*";
    public final static String UPPERS = ".*[A-Z].*";
    public final static String LOWERS = ".*[a-z].*";

    public static void isLoginIdValid(String loginId) {
        if (loginId.matches(SYMBOLS)) throw new IllegalArgumentException("login id can't be contain symbols");
    }

    public static void isPasswordValid(String password) {
        if (password.length() < 8) throw new IllegalArgumentException("Password must be at least 8 characters");
        if (password.length() > 24) throw new IllegalArgumentException("Password must be at most 24 characters");
        if (!password.matches(StringUtils.SYMBOLS)) throw new IllegalArgumentException("Password must contain symbols");
        if (!password.matches(StringUtils.NUMBERS)) throw new IllegalArgumentException("Password must contain numbers");
        if (!password.matches(StringUtils.UPPERS)) throw new IllegalArgumentException("Password must contain uppers");
        if (!password.matches(StringUtils.LOWERS)) throw new IllegalArgumentException("Password must contain lowers");
    }

    public static String createPassword() {
        Random random = new Random(System.currentTimeMillis());

        List<Character> characterList = new ArrayList<>();
        for (int I0 = 0 ; I0 < 3 ; I0 ++) characterList.add(numberTable[random.nextInt(numberTable.length)]);
        for (int I0 = 0 ; I0 < 3 ; I0 ++) characterList.add(upperTable[random.nextInt(upperTable.length)]);
        for (int I0 = 0 ; I0 < 3 ; I0 ++) characterList.add(lowerTable[random.nextInt(lowerTable.length)]);
        for (int I0 = 0 ; I0 < 3 ; I0 ++) characterList.add(symbolTable[random.nextInt(symbolTable.length)]);
        Collections.shuffle(characterList);

        StringBuilder stringBuilder = new StringBuilder();
        for (Character character : characterList) stringBuilder.append(character);

        return stringBuilder.toString();
    }
}
