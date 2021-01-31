package encryptdecrypt;

import java.util.Arrays;

public class Encryptor extends EncryptorDecryptor {

    public Encryptor(String phrase, int offset) {
        super(phrase, offset);
    }

    public String encryptPhraseWithDigit() {
        char[] charArray = phrase.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < charArray.length; i++) {
            int letterPositionInArray = Arrays.binarySearch(symbols, charArray[i]);
            int futurePosition = letterPositionInArray + offset;
            if (futurePosition > symbols.length - 1) {
                int currentPosition = futurePosition - symbols.length;
                sb.append(symbols[currentPosition]);
            } else {
                sb.append(symbols[futurePosition]);
            }
        }
        return sb.toString();
    }

    public String encryptPhraseWithoutDigits() {
        char[] charArray = phrase.toCharArray();
        StringBuilder sb = new StringBuilder();
        int firstLetter = 0;
        int lastLetter = 25;
        for (char item : charArray) {
            if (Character.isLetter(item)) {
                int letterNumber = lastLetter - Arrays.binarySearch(symbols, item);
                sb.append(symbols[letterNumber]);
            } else {
                sb.append(item);
            }
        }
        return sb.toString();
    }

    public void hidePhrase() {
        for (int i = 0; i < phrase.length(); i++) {
            char currentChar = phrase.charAt(i);
            if (Character.isLetter(currentChar)) {
                System.out.print("#");
            } else {
                System.out.print(currentChar);
            }
        }
    }
}
