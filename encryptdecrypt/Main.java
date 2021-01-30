package encryptdecrypt;


public class Main {
    public static void main(String[] args) {

        Encryptor encryptor = new Encryptor();
        String encryptedPhrase = encryptor.encryptPhrase("we found a treasure!");
        System.out.println(encryptedPhrase);
    }
}
