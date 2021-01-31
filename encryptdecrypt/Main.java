package encryptdecrypt;


public class Main {
    public static void main(String[] args) {
        InformationCollector collector = new InformationCollector(args);

        if ("enc".equals(collector.mode)) {
            Encryptor encryptor = new Encryptor(collector.phrase, collector.offset);
            System.out.println(encryptor.encryptPhraseWithDigit());
        } else {
            Decryptor decryptor = new Decryptor(collector.phrase, collector.offset);
            System.out.println(decryptor.decryptPhraseWithDigit());
        }
    }
}
