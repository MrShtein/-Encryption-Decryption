package encryptdecrypt.encrypt;

import java.util.Arrays;

public class ShiftEncAlgorithm implements EncryptAlgorithm {
    private final int COUNTOFSYMBOLS = 26;
    private int offset;
    private char[] lowerCaseLetters;
    private char[] upperCaseLetters;
    private String data;

    public ShiftEncAlgorithm(int offset, String data) {
        this.offset = offset;
        this.data = data;
        lowerCaseLetters = new char[COUNTOFSYMBOLS];
        upperCaseLetters = new char[COUNTOFSYMBOLS];
        setSymbols();
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

    @Override
    public String encryptData() {
        char[] charArray = data.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < charArray.length; i++) {
            if (!Character.isLetter(charArray[i])) {
                sb.append(charArray[i]);
            } else {
                int futurePosition;
                if (charArray[i] >= 'A' && charArray[i] <= 'Z') {
                    int letterPosition = Arrays.binarySearch(upperCaseLetters, charArray[i]);
                    futurePosition = getFutureLetterPosition(letterPosition);
                    sb.append(upperCaseLetters[futurePosition]);
                } else {
                    int letterPosition = Arrays.binarySearch(lowerCaseLetters, charArray[i]);
                    futurePosition = getFutureLetterPosition(letterPosition);
                    sb.append(lowerCaseLetters[futurePosition]);
                }
            }
        }
        return sb.toString();
    }

    public int getFutureLetterPosition(int letterPositionInArray) {
        int futurePosition = letterPositionInArray + offset;
        if (futurePosition > COUNTOFSYMBOLS - 1) {
            return futurePosition - COUNTOFSYMBOLS;
        } else {
            return futurePosition;
        }
    }
}
