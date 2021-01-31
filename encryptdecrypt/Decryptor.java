package encryptdecrypt;

import java.util.Arrays;

public class Decryptor extends EncryptorDecryptor {

    public Decryptor(String phrase, int offset) {
        super(phrase, offset);
    }

    public String decryptPhraseWithDigit() {
        char[] phraseInSymbolsArray = phrase.toCharArray();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < phraseInSymbolsArray.length; i++) {
            char currentSymbol = phraseInSymbolsArray[i];
            int currentSymbolPosition = Arrays.binarySearch(symbols, currentSymbol);
            int futureSymbolPosition = currentSymbolPosition - offset;

            if (futureSymbolPosition < 0) {
                sb.append(symbols[symbols.length + futureSymbolPosition]);
            } else {
                sb.append(symbols[currentSymbolPosition - offset]);
            }
        }
        return sb.toString();
    }



}
