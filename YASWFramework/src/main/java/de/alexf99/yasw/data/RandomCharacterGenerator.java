package de.alexf99.yasw.data;

import de.alexf99.yasw.SystemOutputManager;

import java.util.Random;

public class RandomCharacterGenerator {

    public static enum Mode{
        Numbers,
        Letters,
        both
    }
    public static enum LetterMode{
        Uppercase,
        Lowercase,
        both
    }


    public static String generateRandom(int length, Mode mode, LetterMode letterMode){
        if (mode == Mode.Numbers)return generateRandomNumbers(length);
        else if (mode == Mode.Letters)return generateRandomLetters(length, letterMode);
        else if (mode == Mode.both)return generateRandomCharacters(length, letterMode);
        else return null;
    }
    public static String generateRandom(int length, Mode mode){
        if (mode == Mode.Numbers)return generateRandomNumbers(length);
        else if (mode == Mode.Letters)return generateRandomLetters(length, LetterMode.both);
        else if (mode == Mode.both)return generateRandomCharacters(length, LetterMode.both);
        else return null;
    }

    public static String generateRandomNumbers(int length){
        String characters = "12345677890";
        StringBuilder sb = new StringBuilder();
        Random random = new Random();

        for (int i = 0; i < length; i++) {

            int index = random.nextInt(characters.length());
            char randomChar = characters.charAt(index);
            sb.append(randomChar);
        }

        String generatedString = sb.toString();
        return generatedString;
    }
    public static String generateRandomLetters(int length, LetterMode mode){
        String characters;
        if (mode == LetterMode.Uppercase) characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        else if (mode == LetterMode.Lowercase) characters = "abcdefghijklmnopqrstuvwxyz";
        else if (mode == LetterMode.both) characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        else {
            SystemOutputManager.writeData(true, "No letter mode selected. Auto select Both");
            characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        }
        StringBuilder sb = new StringBuilder();
        Random random = new Random();

        for (int i = 0; i < length; i++) {

            int index = random.nextInt(characters.length());
            char randomChar = characters.charAt(index);
            sb.append(randomChar);
        }

        String generatedString = sb.toString();
        return generatedString;
    }
    public static String generateRandomCharacters(int length, LetterMode mode){
        String characters;
        if (mode == LetterMode.Uppercase) characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        else if (mode == LetterMode.Lowercase) characters = "abcdefghijklmnopqrstuvwxyz1234567890";
        else if (mode == LetterMode.both) characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz1234567890";
        else {
            SystemOutputManager.writeData(true, "No letter mode selected. Auto select Both");
            characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz1234567890";
        }
        StringBuilder sb = new StringBuilder();
        Random random = new Random();

        for (int i = 0; i < length; i++) {

            int index = random.nextInt(characters.length());
            char randomChar = characters.charAt(index);
            sb.append(randomChar);
        }

        String generatedString = sb.toString();
        return generatedString;
    }


}
