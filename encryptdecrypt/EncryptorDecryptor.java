package encryptdecrypt;

public class EncryptorDecryptor {

    protected final char[] symbols;
    protected final String phrase;
    protected final int offset;

    public EncryptorDecryptor(String phrase, int offset) {
        this.symbols = addSymbols();
        this.phrase = phrase;
        this.offset = offset;
    }

    public char[] addSymbols() {
        char[] symbols = new char[95];
        for (int i = 0, start = 32; start <= 126; start++, i++) {
            symbols[i] = (char) start;
        }
        return symbols;
    }

}
