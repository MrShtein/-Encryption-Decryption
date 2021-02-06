package encryptdecrypt.encrypt;

import java.util.Arrays;

public class ShiftEncAlgorithm implements EncryptAlgorithm {
    private final int COUNTOFSYMBOLS = 26;
    private int offset;
    private char[] symbols;
    private String data;

    public ShiftEncAlgorithm(int offset, String data) {
        this.offset = offset;
        this.data = data;
        this.symbols = setSymbols();
    }

    @Override
    public char[] setSymbols() {
        char[] symbols = new char[COUNTOFSYMBOLS];
        int i = 0;
        for (char l = 'a'; l <= 'z'; l++) {
            symbols[i] = l;
            i++;
        }
        return symbols;
    }

    @Override
    public String encryptData() {
        char[] charArray = data.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < charArray.length; i++) {
            if (!Character.isLetter(charArray[i])) {
                sb.append(charArray[i]);
            } else {
                int letterPositionInArray = Arrays.binarySearch(symbols, charArray[i]);
                int futurePosition = letterPositionInArray + offset;
                if (futurePosition > symbols.length - 1) {
                    int currentPosition = futurePosition - symbols.length;
                    if (charArray[i] >= 'A' && charArray[i] <= 'Z') {
                        sb.append(String.valueOf(symbols[currentPosition]).toUpperCase());
                    } else {
                        sb.append(symbols[currentPosition]);
                    }
                } else {
                    if (charArray[i] >= 'A' && charArray[i] <= 'Z') {
                        sb.append(String.valueOf(symbols[futurePosition]).toUpperCase());
                    } else {
                        sb.append(symbols[futurePosition]);
                    }
                }
            }
        }
        return sb.toString();
    }
}
