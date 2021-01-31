package encryptdecrypt;


public class Main {
    public static void main(String[] args) {
        InformationCollector collector = new InformationCollector();
        String action = collector.getPhrase();

        if ("enc".equals(action)) {
            Encryptor encryptor = new Encryptor(collector.getPhrase(), collector.getOffset());
            System.out.println(encryptor.encryptPhraseWithDigit());
        } else {
            Decryptor decryptor = new Decryptor(collector.getPhrase(), collector.getOffset());
            System.out.println(decryptor.decryptPhraseWithDigit());
        }
    }
}
