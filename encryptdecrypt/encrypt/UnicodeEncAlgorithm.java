package encryptdecrypt.encrypt;


import java.util.Arrays;

public class UnicodeEncAlgorithm implements EncryptAlgorithm {

    private final int COUNTOFSYMBOLS = 95;
    private int offset;
    private char[] symbols;
    private String data;

    public UnicodeEncAlgorithm(int offset, String data) {
        this.offset = offset;
        this.data = data;
        symbols = new char[COUNTOFSYMBOLS];
        setSymbols();
    }

    @Override
    public void setSymbols() {
        int i = 0;
        for (char start = ' '; start <= '~'; start++) {
            symbols[i] = start;
            i++;
        }
    }

    @Override
    public String encryptData() {
        char[] charArray = data.toCharArray();
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
}
