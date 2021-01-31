package encryptdecrypt;

public class EncryptorDecryptor {

    protected final char[] symbols;

    public EncryptorDecryptor() {
        this.symbols = addSymbols();
    }

    public char[] addSymbols() {
        char[] symbols = new char[95];
        for (int i = 0, start = 32; start <= 126; start++, i++) {
            symbols[i] = (char) start;
        }
        return symbols;
    }

}
