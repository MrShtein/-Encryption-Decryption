package encryptdecrypt.decrypt;

import java.util.Arrays;

public class UnicodeDecryptAlgorithm implements DecryptAlgorithm{

    private final int COUNTOFSYMBOLS = 95;
    private int offset;
    private char[] symbols;
    private String data;

    public UnicodeDecryptAlgorithm(int offset, String data) {
        this.offset = offset;
        this.data = data;
        this.symbols = new char[COUNTOFSYMBOLS];
        setSymbols();
    }

    @Override
    public String decryptData() {
        char[] phraseInSymbolsArray = data.toCharArray();
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

    @Override
    public void setSymbols() {
        int i = 0;
        for (char start = ' '; start <= '~'; start++) {
            symbols[i] = start;
            i++;
        }
    }
}
