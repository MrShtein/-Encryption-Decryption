package encryptdecrypt;

import java.util.HashMap;

public class Encryptor {

    private HashMap<Character, Character> letters;

    public Encryptor() {
        this.letters = addLetters();
    }

    public HashMap<Character, Character> addLetters() {
        HashMap<Character, Character> mapOfLetters = new HashMap<>();
        for (char start = 'a', stop = 'z'; start <= 'z'; start++, stop--) {
            mapOfLetters.put(start, stop);
        }
        return mapOfLetters;
    }

    public String encryptPhrase(String phraseToEncrypt) {
        char[] charArray = phraseToEncrypt.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (char item : charArray) {
            if (Character.isLetter(item)) {
                sb.append(letters.get(item));
            } else {
                sb.append(item);
            }
        }
        return sb.toString();
    }

    public void hidePhrase(String phraseToHide) {
        for (int i = 0; i < phraseToHide.length(); i++) {
            char currentChar = phraseToHide.charAt(i);
            if (Character.isLetter(currentChar)) {
                System.out.print("#");
            } else {
                System.out.print(currentChar);
            }
        }
    }
}
