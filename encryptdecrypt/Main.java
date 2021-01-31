package encryptdecrypt;


public class Main {
    public static void main(String[] args) {

        Encryptor encryptor = new Encryptor();
        InformationCollector collector = new InformationCollector();
        String phraseToEncrypt = collector.getPhrase();
        int offset = collector.getOffset();
        String encryptedPhrase = encryptor.encryptPhraseWithDigit(phraseToEncrypt, offset);
        System.out.println(encryptedPhrase);
    }
}
