package encryptdecrypt;

import java.util.Arrays;
import java.util.LinkedHashMap;

public class Encryptor {

    private final char[] letters;

    public Encryptor() {
        this.letters = "abcdefghijklmnopqrstuvwxyz".toCharArray();
    }

    public String encryptPhraseWithDigit(String phraseToEncrypt, int offset) {
        char[] charArray = phraseToEncrypt.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < charArray.length; i++) {
            if (!Character.isLetter(charArray[i])) {
                sb.append(charArray[i]);
            } else {
                int letterPositionInArray = Arrays.binarySearch(letters, charArray[i]);
                int futurePosition = letterPositionInArray + offset;
                if (futurePosition > letters.length - 1) {
                    int currentPosition = futurePosition - letters.length;
                    sb.append(letters[currentPosition]);
                } else {
                    sb.append(letters[futurePosition]);
                }
            }
        }
        return sb.toString();
    }

    public String encryptPhraseWithoutDigits(String phraseToEncrypt) {
        char[] charArray = phraseToEncrypt.toCharArray();
        StringBuilder sb = new StringBuilder();
        int firstLetter = 0;
        int lastLetter = 25;
        for (char item : charArray) {
            if (Character.isLetter(item)) {
                int letterNumber = lastLetter - Arrays.binarySearch(letters, item);
                sb.append(letters[letterNumber]);
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
