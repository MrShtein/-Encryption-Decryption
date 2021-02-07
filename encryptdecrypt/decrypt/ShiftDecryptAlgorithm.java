package encryptdecrypt.decrypt;

import java.util.Arrays;

public class ShiftDecryptAlgorithm implements DecryptAlgorithm {

    private final int COUNTOFSYMBOLS = 26;
    private int offset;
    private char[] lowerCaseLetters;
    private char[] upperCaseLetters;
    private String data;

    public ShiftDecryptAlgorithm(int offset, String data) {
        this.offset = offset;
        this.data = data;
        this.lowerCaseLetters = new char[COUNTOFSYMBOLS];
        this.upperCaseLetters = new char[COUNTOFSYMBOLS];
        setSymbols();
    }

    public String decryptData() {
        char[] phraseInSymbolsArray = data.toCharArray();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < phraseInSymbolsArray.length; i++) {
            char currentSymbol = phraseInSymbolsArray[i];
            if (!Character.isLetter(currentSymbol)) {
                sb.append(currentSymbol);
            } else {
                int futurePosition;
                if (currentSymbol >= 'A' && currentSymbol <= 'Z') {
                    int currentSymbolPosition = Arrays.binarySearch(upperCaseLetters, currentSymbol);
                    futurePosition = getFutureLetterPosition(currentSymbolPosition);
                    sb.append(upperCaseLetters[futurePosition]);
                } else {
                    int currentSymbolPosition = Arrays.binarySearch(lowerCaseLetters, currentSymbol);
                    futurePosition = getFutureLetterPosition(currentSymbolPosition);
                    sb.append(lowerCaseLetters[futurePosition]);
                }
            }
        }
        return sb.toString();
    }

    public int getFutureLetterPosition(int currentSymbolPosition){
        int futureSymbolPosition = currentSymbolPosition - offset;
        if (futureSymbolPosition < 0) {
            return lowerCaseLetters.length + futureSymbolPosition;
        } else {
            return futureSymbolPosition;
        }
    }

    @Override
    public void setSymbols() {
        int i = 0;
        for (char l = 'a', u = 'A'; l <= 'z'; l++, u++) {
            lowerCaseLetters[i] = l;
            upperCaseLetters[i] = u;
            i++;
        }
    }
}
