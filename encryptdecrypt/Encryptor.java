package encryptdecrypt;

import java.util.Arrays;

public class Encryptor extends EncryptorDecryptor {

    public Encryptor() {
        super();
    }

    public String encryptPhraseWithDigit(String phraseToEncrypt, int offset) {
        char[] charArray = phraseToEncrypt.toCharArray();
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

    public String encryptPhraseWithoutDigits(String phraseToEncrypt) {
        char[] charArray = phraseToEncrypt.toCharArray();
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
